CREATE SEQUENCE BancAndes_sequence;

CREATE TABLE USUARIO
(
numeroDocumento INT NOT NULL ,
tipoDocumento VARCHAR(255) NOT NULL ,
login VARCHAR (255) NOT NULL UNIQUE,
palabraClave VARCHAR (255)NOT NULL UNIQUE,
nombre VARCHAR (255)NOT NULL,
nacionalidad VARCHAR (255)NOT NULL ,
direccionFisica VARCHAR (255)NOT NULL ,
direccionElectronica VARCHAR (255)NOT NULL UNIQUE,
telefono INT NOT NULL UNIQUE,
ciudad VARCHAR (255) NOT NULL,
departamento VARCHAR (255) NOT NULL,
codigoPostal INT NOT NULL ,
);

ALTER TABLE USUARIO
ADD CONSTRAINT PK_USUARIO
PRIMARY KEY (numeroDocumento, tipoDocumento);

ALTER TABLE USUARIO
ADD CONSTRAINT CK_TIPO_DOCUMENTO
CHECK (tipoDocumento IN ('Registro civil', 'tarjeta de identidad', 'cedula de ciudadania', 'NIT', 'Pasaporte', 'Cedula de extranjeria' ));




CREATE TABLE EMPLEADO
(
numeroID INT,
tipoEmpleado VARCHAR (255)
);

ALTER TABLE EMPLEADO
ADD CONSTRAINT PK_EMPLEADO
PRIMARY KEY (numeroID);

ALTER TABLE EMPLEADO
ADD tipoDocumentoUsuario VARCHAR(255);

ALTER TABLE EMPLEADO
MODIFY tipoDocumentoUsuario VARCHAR (255) NOT NULL ;


ALTER TABLE EMPLEADO
ADD CONSTRAINT FK_E_USUARIO
FOREIGN KEY (numeroID, tipoDocumentoUsuario) REFERENCES USUARIO (numeroDocumento, tipoDocumento);


ALTER TABLE EMPLEADO
MODIFY tipoEmpleado VARCHAR (255) NOT NULL;

ALTER TABLE EMPLEADO
ADD CONSTRAINT CK_TIPO_EMPLEADO
CHECK (TIPOEMPLEADO IN ('Asesor', 'Cajero', 'Gerente oficina', 'Gerente general' ));

ALTER TABLE EMPLEADO
ADD CONSTRAINT CK_TIPO_DOCUMENTO_EMPLEADO
CHECK (tipoDocumentoUsuario IN ('Registro civil', 'tarjeta de identidad', 'cedula de ciudadania', 'NIT', 'Pasaporte', 'Cedula de extranjeria' ));







CREATE TABLE OFICINA (
nombre VARCHAR (255),
direccion VARCHAR (255) NOT NULL UNIQUE,
numPuntosAtencion INT,
idEmpleado INT
);

ALTER TABLE OFICINA
ADD CONSTRAINT PK_OFICINA
PRIMARY KEY (nombre);

ALTER TABLE OFICINA
ADD CONSTRAINT NUMERO_ID_EMPLEADO
    FOREIGN KEY (idEmpleado)
    REFERENCES EMPLEADO(numeroId);
    
ALTER TABLE OFICINA
MODIFY idEmpleado INT NOT NULL;







CREATE TABLE PUNTODEATENCION
(
id INT,
tipoPuntoAtencion VARCHAR (255) NOT NULL,
localizacion VARCHAR (255) NOT NULL UNIQUE,
oficina VARCHAR (255)
);

ALTER TABLE  PUNTODEATENCION
ADD CONSTRAINT PK_PUNTOATENCION
PRIMARY KEY (id);

ALTER TABLE PUNTODEATENCION
ADD CONSTRAINT CK_TIPO_PUNTO_ATENCION
CHECK (tipoPuntoAtencion IN ('Oficina', 'Cajero automatico', 'Virtual'));

ALTER TABLE PUNTODEATENCION
ADD CONSTRAINT NOMBRE_OFICINA_FK
    FOREIGN KEY (oficina)
    REFERENCES OFICINA(nombre);





CREATE TABLE CAJEROSPUNTOATENCION (
idPuntoAtencion INT NOT NULL,
idEmpleado INT NOT NULL UNIQUE
);


ALTER TABLE  CAJEROSPUNTOATENCION
ADD CONSTRAINT PK_CAJEROSPUNTOATENCION
PRIMARY KEY (idPuntoAtencion, idEmpleado);

ALTER TABLE  CAJEROSPUNTOATENCION
ADD CONSTRAINT ID_PUNTO_ATENCION_FK
    FOREIGN KEY (idPuntoAtencion)
    REFERENCES PUNTODEATENCION(id);

ALTER TABLE  CAJEROSPUNTOATENCION
ADD CONSTRAINT ID_EMPLEADO_FK
    FOREIGN KEY (idEmpleado)
    REFERENCES EMPLEADO(numeroId);







CREATE TABLE CLIENTE
(
numeroID INT,
tipoPersona VARCHAR (255)
);

ALTER TABLE CLIENTE
ADD tipoDocumentoUsuario VARCHAR(255);

ALTER TABLE CLIENTE
MODIFY tipoDocumentoUsuario VARCHAR (255) NOT NULL ;


ALTER TABLE CLIENTE
ADD CONSTRAINT PK_CLIENTE
PRIMARY KEY (numeroID);


ALTER TABLE CLIENTE
ADD CONSTRAINT CK_TIPO_CLIENTE
CHECK (tipoPersona IN ('Natural', 'Juridica'));

ALTER TABLE CLIENTE
ADD CONSTRAINT FK_C_CLIENTE
FOREIGN KEY (numeroID, tipoDocumentoUsuario) REFERENCES USUARIO (numeroDocumento, tipoDocumento);


ALTER TABLE CLIENTE
ADD CONSTRAINT CK_TIPO_DOCUMENTO_CLIENTE
CHECK (tipoDocumentoUsuario IN ('Registro civil', 'tarjeta de identidad', 'cedula de ciudadania', 'NIT', 'Pasaporte', 'Cedula de extranjeria' ));






CREATE TABLE ADMINISTRADOR(
numeroIDAdiministrador INT,
tipoDocumentoAdministrador VARCHAR (255)
);

ALTER TABLE ADMINISTRADOR
ADD CONSTRAINT FK_C_ADMINISTRADOR
FOREIGN KEY (numeroIDAdiministrador, tipoDocumentoAdministrador) REFERENCES USUARIO (numeroDocumento, tipoDocumento);

ALTER TABLE ADMINISTRADOR
MODIFY tipoDocumentoAdministrador VARCHAR (255) NOT NULL 
;

ALTER TABLE ADMINISTRADOR
ADD CONSTRAINT PK_ADMINISTRADOR
PRIMARY KEY (numeroIDAdiministrador);

ALTER TABLE ADMINISTRADOR
ADD CONSTRAINT CK_TIPO_DOCUMENTO_ADMINISTRADOR
CHECK (tipoDocumentoAdministrador IN ('Registro civil', 'tarjeta de identidad', 'cedula de ciudadania', 'NIT', 'Pasaporte', 'Cedula de extranjeria' ));





CREATE TABLE CUENTA (
numeroUnico INT,
tipoCuenta VARCHAR (255) NOT NULL,
saldo INT NOT NULL,
estado VARCHAR (255) NOT NULL,
numeroIDCliente INT,
numeroIDEmpleado INT,
fechaCreacionCuenta DATE NOT NULL,
fechaUltimoMovimiento DATE 
);

ALTER TABLE CUENTA
ADD CONSTRAINT PK_CUENTA
PRIMARY KEY (numeroUnico);

ALTER TABLE CUENTA
ADD CONSTRAINT CK_TIPO_CUENTA
CHECK (tipoCuenta IN ('Ahorros', 'Corriente', 'AFC', 'CDT', 'Nomina' ));


ALTER TABLE CUENTA
ADD CONSTRAINT CK_ESTADO_CUENTA
CHECK (tipoCuenta IN ('Activa', 'Cerrada'));

ALTER TABLE CUENTA
    ADD CONSTRAINT CUENTAS_Cliente_FK
    FOREIGN KEY (numeroIDCliente)
    REFERENCES CLIENTE(numeroID);



ALTER TABLE CUENTA
    ADD CONSTRAINT CUENTAS_EMPLEADO_FK
    FOREIGN KEY (numeroIDEmpleado)
    REFERENCES EMPLEADO(numeroID);








CREATE TABLE OPERACIONESBANCARIAS
(
id INT,
valor INT NOT NULL,
fechaHora DATE NOT NULL,
numeroCuenta INT,
empleado INT,
administrador INT
);


ALTER TABLE OPERACIONESBANCARIAS
ADD CONSTRAINT PK_OPERACIONESBANCARIAS
PRIMARY KEY (id);

ALTER TABLE OPERACIONESBANCARIAS
    ADD CONSTRAINT NUMERO_CUENTA_FK
    FOREIGN KEY (numeroCuenta)
    REFERENCES CUENTA(numeroUnico);

ALTER TABLE OPERACIONESBANCARIAS
    ADD CONSTRAINT NUMERO_ADMINISTRADOR_FK
    FOREIGN KEY (administrador)
    REFERENCES ADMINISTRADOR(numeroIDAdiministrador);

ALTER TABLE OPERACIONESBANCARIAS
    ADD CONSTRAINT NUMERO_EMPLEADO_FK
    FOREIGN KEY (empleado)
    REFERENCES ADMINISTRADOR(numeroIDAdiministrador);






CREATE TABLE OPERACIONCUENTA
(
idOperacionCuenta INT,
tipoOpeCuentna VARCHAR(255) NOT NULL
);

ALTER TABLE OPERACIONCUENTA
ADD CONSTRAINT PK_OPERACION_CUENTA
PRIMARY KEY (idOperacionCuenta);

ALTER TABLE OPERACIONCUENTA
ADD CONSTRAINT NUMERO_CUENTA_BANCARIA_FK
    FOREIGN KEY (idOperacionCuenta)
    REFERENCES OPERACIONESBANCARIAS(id);


ALTER TABLE OPERACIONCUENTA
ADD CONSTRAINT CK_TIPO_OPERACION_CUENTA
CHECK (tipoOpeCuentna IN ('Abrir', 'Cerrar', 'Transferir', 'Retirar', 'Consignar' ));





CREATE TABLE OPERACIONCDT(
idOperacionCDT INT,
tipoOpeCDT VARCHAR (255) NOT NULL ,
fechaVencimiento DATE NOT NULL,
tasaRendimientos INT NOT NULL
);

ALTER TABLE OPERACIONCDT
ADD CONSTRAINT PK_OPERACION_CDT
PRIMARY KEY (idOperacionCDT);

ALTER TABLE OPERACIONCDT
ADD CONSTRAINT CK_TIPO_OPERACION_CDT
CHECK (tipoOpeCDT IN ('Abrir', 'Cerrar', 'Renovar'));

ALTER TABLE OPERACIONCDT
ADD CONSTRAINT NUMERO_CUENTA_BANCARIA_CDT_FK
    FOREIGN KEY (idOperacionCDT)
    REFERENCES OPERACIONESBANCARIAS(id);





CREATE TABLE OPERACIONACCIONES (
    idOperacionAcciones INT,
    numAcciones INT,
    tipoOpeAcciones VARCHAR(255)
);


ALTER TABLE OPERACIONACCIONES
ADD CONSTRAINT PK_OPERACION_ACCIONES
PRIMARY KEY (idOperacionAcciones);


ALTER TABLE OPERACIONACCIONES
ADD CONSTRAINT CK_TIPO_OPERACION_ACCIONES
CHECK (tipoOpeAcciones IN ('Vender', 'Comprar'));




ALTER TABLE OPERACIONACCIONES
MODIFY tipoOpeAcciones VARCHAR(255) NOT NULL;


ALTER TABLE OPERACIONACCIONES
MODIFY numAcciones INT NOT NULL;

ALTER TABLE OPERACIONACCIONES
ADD CONSTRAINT NUMERO_CUENTA_BANCARIA_ACCCIONES_FK
    FOREIGN KEY (idOperacionAcciones)
    REFERENCES OPERACIONESBANCARIAS(id);




CREATE TABLE OPERACIONINVERSION (
idOperacionInversion INT,
tipoOpeInversion VARCHAR (255) NOT NULL
);

ALTER TABLE OPERACIONINVERSION
ADD CONSTRAINT PK_OPERACION_INVERSION
PRIMARY KEY (idOperacionInversion);

ALTER TABLE OPERACIONINVERSION
ADD CONSTRAINT CK_TIPO_OPERACION_INVERSION
CHECK (tipoOpeInversion IN ('Abrir', 'Cerrar', 'Liquidar', 'Renovar'));


ALTER TABLE OPERACIONINVERSION  
ADD CONSTRAINT NUMERO_CUENTA_BANCARIA_INVERSION_FK
    FOREIGN KEY (idOperacionInversion)
    REFERENCES OPERACIONESBANCARIAS(id);






CREATE TABLE PRESTAMO (
id INT,
monto INT NOT NULL,
interes INT NOT NULL,
numCuotas INT NOT NULL,
diaPago INT NOT NULL,
estado VARCHAR (255) NOT NULL,
tipoPrestamo VARCHAR (255) NOT NULL,
idCliente INT NOT NULL,
oficina VARCHAR (255)
);


ALTER TABLE PRESTAMO
ADD CONSTRAINT PK_PRESTAMO
PRIMARY KEY (id);



ALTER TABLE PRESTAMO
ADD CONSTRAINT ID_CLIENTE_FK
    FOREIGN KEY (idCliente)
    REFERENCES CLIENTE(numeroId);


ALTER TABLE PRESTAMO
ADD CONSTRAINT  NOMBRE_OFICINA_PRESTAMO_FK
    FOREIGN KEY (oficina)
    REFERENCES OFICINA(nombre);

ALTER TABLE PRESTAMO
ADD CONSTRAINT CK_ESTADO_PRESTAMO
CHECK (estado IN ('Activo', 'Cerrado'));

ALTER TABLE PRESTAMO
ADD CONSTRAINT CK_TIPO_PRESTAMO
CHECK (tipoPrestamo IN ('Vivienda', 'Estudio', 'Automovil', 'CalamidadDomestica', 'Libre inversion'));






CREATE TABLE CUOTAMINIMAPRESTAMO
(
idPrestamo INT NOT NULL UNIQUE,
valorCuotaMinima INT NOT NULL
);


ALTER TABLE CUOTAMINIMAPRESTAMO
ADD CONSTRAINT PK_CUOTAMINIMAPRESTAMO
PRIMARY KEY (idPrestamo, valorCuotaMinima);


ALTER TABLE CUOTAMINIMAPRESTAMO
ADD CONSTRAINT  ID_PRESTAMO_FK
    FOREIGN KEY (idPrestamo)
    REFERENCES PRESTAMO(id);





CREATE TABLE OPERACIONPRESTAMO
(
idOperacionPrestamo INT,
tipoOpePrestamo VARCHAR (255) NOT NULL,
idPrestamo INT NOT NULL,
valorPagado INT

);

ALTER TABLE OPERACIONPRESTAMO
ADD CONSTRAINT PK_OPERACION_PRESTAMO
PRIMARY KEY (idOperacionPrestamo);

ALTER TABLE OPERACIONPRESTAMO
ADD CONSTRAINT  PRESTAMO_ID_FK
    FOREIGN KEY (idPrestamo)
    REFERENCES PRESTAMO(id);
    
    ALTER TABLE OPERACIONPRESTAMO
ADD CONSTRAINT CK_TIPO_OPERACIONPRESTAMO
CHECK (tipoOpePrestamo IN ('Abrir', 'Transferir', 'Cerrar', 'Consignar', 'Retirar'));
    

    
