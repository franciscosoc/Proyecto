/* Populate tables */
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc', '103' ,'Andres', 'Guzman', 'profesor@hotmail.com', '2017-08-01','2010-08-01', '');*/
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc','105','John', 'Doe', 'john.doe@gmail.com', '2017-08-02','2009-08-01', '');*/
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc','107','Linus', 'Torvalds', 'linus.torvalds@gmail.com','2018-08-01' ,'2007-08-03', '');*/
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc','108','Lina', 'Garcia', 'lina@gmail.com', '2019-08-01' ,'2007-08-03', '');*/
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc','109','Andres', 'Toloza', 'andrest@gmail.com', '2015-08-01' ,'2006-08-03', '');*/
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc','1010','Pedro', 'Benitez', 'pedro@gmail.com', '2014-08-01' ,'2005-08-03', '');*/
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc','1011','Saray', 'Urango', 'saray@gmail.com', '2013-08-01' ,'2004-08-03', '');*/
/*INSERT INTO clientes (tipodoc, identificacion, nombre, apellido, email, create_at,fecha_nac, foto) VALUES('cc','1012','Caleb', 'Urango', 'caleb@gmail.com', '2011-08-01' ,'2003-08-03', '');*/



/* Populate tabla productos */
/*INSERT INTO productos (nombre, saldo, create_at) VALUES('Ahorros', 10000, NOW());*/



/* Creamos algunas facturas */
/*INSERT INTO cuentas (numeroc, estado, cliente_id, create_at) VALUES('789076543321', 'activa', 1, NOW());*/
/*INSERT INTO cuentas_items (cantidad, cuenta_id, producto_id) VALUES(1, 1, 1);*/


/*INSERT INTO cuentas (numeroc, estado, cliente_id, create_at) VALUES('700120121201', 'activa', 2, NOW());*/


INSERT INTO tipo_cuenta (nombre) VALUES('CUENTA DE AHORRO');
INSERT INTO tipo_cuenta (nombre) VALUES('CUENTA CORRIENTE');

INSERT INTO estado_cuenta (nombre) VALUES('ACTIVO');
INSERT INTO estado_cuenta (nombre) VALUES('INACTIVO');
INSERT INTO estado_cuenta (nombre) VALUES('CANCELADA');

INSERT INTO tipo_documento (nombre) VALUES('CEDULA');
INSERT INTO tipo_documento (nombre) VALUES('TARJETA DE IDENTIDAD');
INSERT INTO tipo_documento (nombre) VALUES('PASAPORTE');


