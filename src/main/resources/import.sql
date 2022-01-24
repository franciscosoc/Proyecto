/* Populate tables */


INSERT INTO tipo_cuenta (nombre) VALUES('CUENTA DE AHORRO');
INSERT INTO tipo_cuenta (nombre) VALUES('CUENTA CORRIENTE');

INSERT INTO estado_cuenta (nombre) VALUES('ACTIVO');
INSERT INTO estado_cuenta (nombre) VALUES('INACTIVO');
INSERT INTO estado_cuenta (nombre) VALUES('CANCELADA');

INSERT INTO tipo_documento (nombre) VALUES('CEDULA');
INSERT INTO tipo_documento (nombre) VALUES('TARJETA DE IDENTIDAD');
INSERT INTO tipo_documento (nombre) VALUES('PASAPORTE');


INSERT INTO clientes (`id`,`apellidos`,`email`,`fecha_creacion`,`fecha_nacimiento`,`nombres`,`nro_identificacion`,`tipo_documento_id`) VALUES (1,'SOTO PEREZ','elronaldo61@hotmail.com','2022-01-23 02:00:00.000000','2009-07-05 01:00:00.000000','FRANCISCO JOSE','221212',1);
INSERT INTO clientes (`id`,`apellidos`,`email`,`fecha_creacion`,`fecha_nacimiento`,`nombres`,`nro_identificacion`,`tipo_documento_id`) VALUES (2,'MARTINES HOYOS','el@hotmail.com','2022-01-23 02:00:00.000000','2009-07-05 01:00:00.000000','PEDRO JOSE','221213',1);
INSERT INTO clientes (`id`,`apellidos`,`email`,`fecha_creacion`,`fecha_nacimiento`,`nombres`,`nro_identificacion`,`tipo_documento_id`) VALUES (3,'HOYOS DIAZ','ella@hotmail.com','2022-01-23 02:00:00.000000','2009-07-05 01:00:00.000000','ANTONIO JOSE','221214',1);
INSERT INTO clientes (`id`,`apellidos`,`email`,`fecha_creacion`,`fecha_nacimiento`,`nombres`,`nro_identificacion`,`tipo_documento_id`) VALUES (4,'LLORENTE HOYOS','escritor@hotmail.com','2022-01-23 02:00:00.000000','2009-07-05 01:00:00.000000','SANTIAGO JOSE','221215',1);
INSERT INTO clientes (`id`,`apellidos`,`email`,`fecha_creacion`,`fecha_nacimiento`,`nombres`,`nro_identificacion`,`tipo_documento_id`) VALUES (5,'NIEVES ROJANO','poeta@hotmail.com','2022-01-23 02:00:00.000000','2009-07-05 01:00:00.000000','LUCAS JOSE','221216',1);
INSERT INTO clientes (`id`,`apellidos`,`email`,`fecha_creacion`,`fecha_nacimiento`,`nombres`,`nro_identificacion`,`tipo_documento_id`) VALUES (6,'SALAZAR HURTADO','crack@hotmail.com','2022-01-23 02:00:00.000000','2009-07-05 01:00:00.000000','JUAN JOSE','221217',1);
INSERT INTO clientes (`id`,`apellidos`,`email`,`fecha_creacion`,`fecha_nacimiento`,`nombres`,`nro_identificacion`,`tipo_documento_id`) VALUES (7,'MEDINA IZQUIERDO','elronaldo61@hotmail.com','2022-01-23 02:00:00.000000','2009-07-05 01:00:00.000000','MARIO JOSE','221218',1);
