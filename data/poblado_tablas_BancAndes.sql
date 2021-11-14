INSERT INTO USUARIO (NUMERODOCUMENTO, TIPODOCUMENTO, LOGIN, PALABRACLAVE, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL)
VALUES (325654, 'cedula de ciudadania', 're.perez', 'Juan1234', 'Juan', 'colombiano', 'carrera 13 # 45-56', 'juanPerez@gmail.com', 3162589478, 'Bogota', 'Bogota D.C', '12545');

INSERT INTO USUARIO (NUMERODOCUMENTO, TIPODOCUMENTO, LOGIN, PALABRACLAVE, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL)
VALUES (215465, 'Pasaporte', 'pepito@', 'al.wer32', 'cahil', 'colombiano', 'calle 13 # 58a-10', 'chill@hotmail.com', 3212599576, 'Bogota', 'Bogota D.C', '12545');

INSERT INTO USUARIO (NUMERODOCUMENTO, TIPODOCUMENTO, LOGIN, PALABRACLAVE, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL)
VALUES (826783, 'tarjeta de identidad', 'arcoirirs1235', 'desde56', 'Elena', 'colombiana', 'calle 98 # 125-45', 'ElenaArcoiris@hotmail.com', 3129899576, 'Cali', 'Valle del cauca', '16584');


INSERT INTO USUARIO (NUMERODOCUMENTO, TIPODOCUMENTO, LOGIN, PALABRACLAVE, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL)
VALUES (365462, 'NIT', 'pinturasAlvarez', '20212', 'Alvarez', 'colombiano', 'carrera 43 # 78b-10', 'pinturas.Alv2021@hotmail.com', 3154568985, 'Barranquilla', 'Magdalena', '1111');


INSERT INTO USUARIO (NUMERODOCUMENTO, TIPODOCUMENTO, LOGIN, PALABRACLAVE, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL)
VALUES (268754, 'cedula de ciudadania', 'ana.sofia', 'Sofi1110', 'Sofia', 'colombiano', 'carrera 11 # 13a-10', 'anasofia@hotmail.com', 3112355489, 'Villanueva', 'Casanare', '0000');

INSERT INTO USUARIO (NUMERODOCUMENTO, TIPODOCUMENTO, LOGIN, PALABRACLAVE, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL)
VALUES (655421, 'cedula de ciudadania', 'predro23', 'perez1223', 'Pedro', 'colombiano', 'carrera 11 # 13a-48', 'pedro@hotmail.com', 3105355489, 'Vilavicencio', 'Meta', '0002');

INSERT INTO USUARIO (NUMERODOCUMENTO, TIPODOCUMENTO, LOGIN, PALABRACLAVE, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL)
VALUES (656585, 'cedula de ciudadania', 'pena77', 'h9n9w35y', 'William', 'colombiano', 'carrera 11 # 13-58', 'willepa234@hotmail.com', 3107296587, 'Medellin', 'Antioquia', '0003');


INSERT INTO ADMINISTRADOR (NUMEROIDADIMINISTRADOR, tipodocumentoadministrador) 
VALUES ('215465', 'Pasaporte');


INSERT INTO ADMINISTRADOR (NUMEROIDADIMINISTRADOR, tipodocumentoadministrador) 
VALUES ('365452', 'cedula de ciudadania');

INSERT INTO CUENTANATURAL ()


INSERT INTO EMPLEADO (numeroid, tipoempleado, tipodocumentousuario) VALUES (656585, 'Cajero', 'cedula de ciudadania' );

INSERT INTO EMPLEADO (numeroid, tipoempleado, tipodocumentousuario) VALUES (325654, 'Gerente general', 'cedula de ciudadania' );



INSERT INTO CLIENTE (numeroid, tipopersona,tipodocumentousuario) VALUES (268754,'Natural', 'cedula de ciudadania' );

INSERT INTO CLIENTE (numeroid, tipopersona,tipodocumentousuario) VALUES (655421,'Natural', 'cedula de ciudadania' );



INSERT INTO CUENTA (numerounico,tipocuenta,saldo,estado,numeroidcliente,fechacreacioncuenta,fechaultimomovimiento) VALUES (123456, 'CDT', 235, 'Activa', 268754, '20/5/2021', null);

INSERT INTO CUENTA (numerounico,tipocuenta,saldo,estado,numeroidcliente,fechacreacioncuenta,fechaultimomovimiento) VALUES (123444, 'Ahorros', 265789, 'Activa', 655421, '13/9/2021', null);

INSERT INTO OPERACIONESBANCARIAS (id,valor,fechahora,numerocuenta,empleado,administrador) VALUES (234567, 654879, '19/10/21', 123456, NULL, NULL);

INSERT INTO OPERACIONESBANCARIAS (id,valor,fechahora,numerocuenta,empleado,administrador) VALUES (125458, 102000, '19/8/21', 123444, NULL, NULL);

INSERT INTO OPERACIONCUENTA (idoperacioncuenta,tipoopecuentna) VALUES (234567, 'Transferir');

INSERT INTO OPERACIONINVERSION (idoperacioninversion, tipoopeinversion)VALUES(125458, 'Liquidar');


INSERT INTO OFICINA (nombre, direccion, numpuntosatencion, idempleado) VALUES ('BancAndes de la 38', 'carrera 38 # 24c-5', 1, 325654);


INSERT INTO PUNTODEATENCION (id, tipopuntoatencion, localizacion, oficina)VALUES (4, 'Oficina', 'carrera 38 # 24c-5', 'BancAndes de la 38');

INSERT INTO CAJEROSPUNTOATENCION (idpuntoatencion,idempleado) VALUES (4, 656585);

INSERT INTO PRESTAMO (id,monto,interes,numcuotas,diapago,estado,tipoprestamo,idcliente)
VALUES(65,235698,2,65,5,'Activo','Libre inversion', 268754);

INSERT INTO OPERACIONPRESTAMO (idoperacionprestamo,tipoopeprestamo,idprestamo,valorpagado)
VALUES (89,'Consignar',65,32000 );