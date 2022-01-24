package com.bolsadeideas.springboot.app.controllers;


import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Cuenta;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.models.service.ITipoDocumentoService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;


@Controller

@SessionAttributes("cliente")

public class ClienteController {
	
	
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private ITipoDocumentoService tipoDocumentoService;

	@GetMapping(value = "/ver/{id}")
	
	
	//VER DETALLE DE CLIENTE

	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("cliente", cliente);
		model.put("titulo", "Detalle cliente: " + cliente.getNombres());
		return "ver";
	}
	
	
	
	
	//LISTAR LOS CLIENTES

	@RequestMapping(value = "/listar", method = RequestMethod.GET)

	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Cliente> clientes = clienteService.findAll(pageRequest);

		PageRender<Cliente> pageRender = new PageRender<Cliente>("/listar", clientes);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		return "listar";

	}
	
	
	// FORMULARIO  CREAR CLIENTE

	@RequestMapping(value = "/form")

	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");

		// carga de la tabla tipo_documento los documentos
		// Cedula,Tarjeta de identidad, Pasaporte
		
		model.put("tiposDocumentos", this.tipoDocumentoService.findAll());

		return "form";
	}
	
	
	
	//EDITAR CLIENTE

	@RequestMapping(value = "/form/{id}")

	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		model.put("tiposDocumentos", this.tipoDocumentoService.findAll());
		return "form";
	}
	
	
	
	//GUARDAR CLIENTE

	@RequestMapping(value = "/form", method = RequestMethod.POST)

	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}

		String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con éxito!" : "Cliente creado con éxito!";

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	
	
	
	//ELIMINAR CLIENTE 

	@RequestMapping(value = "/eliminar/{id}")

	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		
		//Si el id existe
		
		if (id != null) {
			
			Cliente cliente = clienteService.findOne(id);
			
			if (cliente != null) {

				if (!cliente.getCuentas().isEmpty()) {
					
					// si el cliente posee  cuenta en estado Cancelada
					// elimina el cliente con su cuentas y las cuentas
					
					Cuenta matchingObject = cliente.getCuentas().stream()
							.filter(c -> c.getEstadoCuenta().getNombre().equals("CANCELADA")).findAny().orElse(null);
					
					if (matchingObject != null) {
						clienteService.delete(id);
						flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
						
					} else {
						flash.addFlashAttribute("error", "El cliente posee cuenta/s en estado Activo o Inactivo");
					}

				} else {
					
					// si el cliente no posee cuenta 
					//  lo elimina directamente el cliente
					
					clienteService.delete(id);
					flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
				}

			}

		}
		return "redirect:/listar";
	}


}