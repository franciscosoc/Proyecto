package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Cuenta;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.models.service.IEstadoCuentaService;
import com.bolsadeideas.springboot.app.models.service.ITipoCuentaService;

@Controller
@RequestMapping("/cuenta")
@SessionAttributes("cuenta")
public class CuentaController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ITipoCuentaService tipoCuentaService;
	
	@Autowired
	private IEstadoCuentaService estadoCuentaService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/ver/{id}")
	
	public String ver(@PathVariable(value="id") Long id,
			Model model,
			RedirectAttributes flash) {
		
		Cuenta cuenta = clienteService.findCuentaById(id);
		
		if(cuenta == null) {
			
			
			flash.addFlashAttribute("error", "La cuenta no existe en la base de datos");
			return "redirect:/listar";
			
		}
		
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("titulo", "Cuenta : ".concat(cuenta.getNumeroCuenta()));
		

		return "cuenta/ver";
		
		
	}
	
	
	

	@GetMapping("/form/{clienteId}")
	
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(clienteId);

		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		Cuenta cuenta = new Cuenta();
		cuenta.setCliente(cliente);

		model.put("cuenta", cuenta);
		model.put("titulo", "Crear Cuenta");
		
		/* carga de la tabla tipo_cuenta los tipos de cuentas de ahorro y corriente */
		
		model.put("tiposCuentas", this.tipoCuentaService.findAll());
		
		/* carga de la tabla estado_cuenta los estados de las cuentas Activa, Inactiva o Cancelada */
		
		model.put("estadosCuentas", this.estadoCuentaService.findAll());

		return "cuenta/form";
		
	}
	
	@RequestMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cuenta cuenta = clienteService.findCuentaById(id);

		if (cuenta==null) {
			flash.addFlashAttribute("error", "El ID de la cuenta no existe en la BBDD!");
			return "redirect:/listar";
		}
		
		model.put("cuenta", cuenta);
		model.put("titulo", "Editar Cuenta");
		model.put("tiposCuentas", this.tipoCuentaService.findAll());
		model.put("estadosCuentas", this.estadoCuentaService.findAll());
		
		return "cuenta/form";
	}

	
	@PostMapping("/form")
	public String guardar(@Valid Cuenta cuenta,
			BindingResult result,
			Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, 
			RedirectAttributes flash,
			SessionStatus status) {
		
		
		if(result.hasErrors()) {
			
			model.addAttribute("titulo","Crear Cuenta");
			return "cuenta/form";
		
		}
	
		clienteService.saveCuenta(cuenta);
		status.setComplete();

		flash.addFlashAttribute("success", "Cuenta creada con éxito!");

		return "redirect:/ver/" + cuenta.getCliente().getId();
	}

	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		Cuenta cuenta = clienteService.findCuentaById(id);
		
		
		if(cuenta != null) {
		
			clienteService.deleteCuenta(id);
			flash.addFlashAttribute("success","Cuenta eliminada con exito");
		
			return "redirect:/ver/" + cuenta.getCliente().getId();
		}
		
		
		flash.addFlashAttribute("error","La cuenta no existe en la base de datos, no se pudo eliminar");
		
		return "redirect:/listar/";
		
		
		
	}
	
	
}
