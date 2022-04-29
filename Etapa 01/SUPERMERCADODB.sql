/*  Danny Soto j
	Fecha 13/04/2022
*/

/*Cre�mos la base de datos */
CREATE DATABASE SUPERMERCADODB
GO
USE SUPERMERCADODB
GO

/*Cre�mos tabla 01 EMPLEADOS*/
CREATE TABLE EMPLEADOS(
	ID_EMPLEADO	INT IDENTITY(1,1) PRIMARY KEY,
	NOMBRE	VARCHAR(20) NOT NULL,
	PRIMER_APELLIDO	VARCHAR(20) NOT NULL,
	SEGUNDO_APELLIDO	VARCHAR(20) NOT NULL,
	TELEFONO VARCHAR(20) NOT NULL,
	CORREO VARCHAR(20) NOT NULL,
	DIRECCION VARCHAR(100) NULL,
	CARGO	VARCHAR(30) DEFAULT 'Cajero'NOT NULL,
	FECHA_INGRESO DATE DEFAULT GETDATE() NOT NULL,
	NOMBRE_USUARIO	VARCHAR(20) NOT NULL,
	CONTRASENIA	VARCHAR(15) NOT NULL,
	ESTADO	VARCHAR(3) DEFAULT 'ACT' NOT NULL
)
/*Cre�mos las restricciones de la tabla COLABORADORES*/

/*La fecha no puede ser mayor a la fecha actual*/
ALTER TABLE EMPLEADOS
ADD CONSTRAINT CKH_FECHA_INGRESO CHECK(FECHA_INGRESO <= GETDATE());
/*El colaborador tendr� dos estados ACT cuando ingresa y INA al desligarse de la empresa*/
ALTER TABLE EMPLEADOS
ADD CONSTRAINT CHK_ESTADO CHECK (ESTADO IN ('INA','ACT')and ESTADO = upper(ESTADO));
GO
/*--------------------------------------------------------------------------------*/
/*Cre�mos tabla 02 PROVEEDORES*/
CREATE TABLE PROVEEDORES(
	ID_PROVEEDOR	INT IDENTITY(1,1) PRIMARY KEY,
	NOMBRE_PROVEEDOR	VARCHAR(20) NOT NULL,
	DIRECCION	VARCHAR(100) NULL,
	TELEFONO VARCHAR(20) NOT NULL,
	EXTENSION	INT NULL,
	CORREO	VARCHAR(30) NULL,
	NUMERO_CUENTA	VARCHAR(25) NOT NULL,
)
ALTER TABLE PROVEEDORES
ADD ESTADO VARCHAR(3) DEFAULT 'ACT' NOT NULL
GO
/*El colaborador tendr� dos estados ACT cuando ingresa y INA al desligarse de la empresa*/
ALTER TABLE PROVEEDORES
ADD CONSTRAINT CHK_ESTADO_PROVEEDOR CHECK (ESTADO IN ('INA','ACT')and ESTADO = upper(ESTADO));
GO
/*--------------------------------------------------------------------------------*/
/*Cre�mos tabla 03 PRODUCTOS*/
/*�nicamente agregamos los productos al sistema*/
CREATE TABLE PRODUCTOS(
	ID_PRODUCTO	VARCHAR(50) PRIMARY KEY NOT NULL,
	ID_PROVEEDOR INT NOT NULL,	
	DESCRIPCION VARCHAR(100) NOT NULL,
	PRECIO_UNIDAD	DECIMAL(10,2) NOT NULL	)
GO
/*--------------------------------------------------------------------------------*/
/*Cre�mos tabla 04 INVENTARIOS*/
/*Agreg�mos los productos al inventario, consultando la tabla de producto
  tenemos acceso a los productos registrados y sus detalles,
  */
CREATE TABLE INVENTARIOS(
	ID_INVENTARIO INT IDENTITY(1,1) PRIMARY KEY,
	ID_PRODUCTO VARCHAR(50) NOT NULL,
	DESCRIPCION	VARCHAR(100) NOT NULL,
	CANTIDA_INGRESADA INT NOT NULL,/*CANTIDAD INGRESADO*/
	EXISTENCIA INT NOT NULL,
	CANTIDAD_VENDIDA INT NOT NULL,
	PRECIO_UNIDAD	DECIMAL(10,2) NOT NULL
)
GO
/*--------------------------------------------------------------------------------*/
/*Cre�mos tabla 05 FACTURAS*/
CREATE TABLE FACTURAS(
	ID_FACTURA	INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	ID_EMPLEADO INT NOT NULL,
	ID_PRODUCTO VARCHAR(50) NOT NULL,
	DESCRIPCION VARCHAR(100) NOT NULL,
	CANTIDAD	INT NOT NULL,
	PRECIO_UNIDAD DECIMAL(10,2) NOT NULL,
	SUBTOTAL DECIMAL(10,2) NOT NULL,
	IVA DECIMAL(10,2) NOT NULL,
	DESCUENTO DECIMAL(10,2) NOT NULL,
	TOTAL DECIMAL(10,2) NOT NULL
)
GO
/*--------------------------------------------------------------------------------*/
/*Cre�mos tabla 06 CLIENTES*/
CREATE TABLE CLIENTES(
	ID_CLIENTE INT IDENTITY(1,1) PRIMARY KEY,
	ID_FACTURA INT NOT NULL,
	NUM_IDENTIFICACION VARCHAR(20) NOT NULL,
	NOMBRE_CLIENTE VARCHAR(20) NOT NULL,
	APELLIDO1 VARCHAR(20) NOT NULL,
	APELLIDO2 VARCHAR(20) NOT NULL,
	TELEFONO VARCHAR(20) NOT NULL,
	DIRECCION VARCHAR(100) NOT NULL
)
GO
/*--------------------------------------------------------------------------------*/
/*Cre�mos tabla 07 VENTAS*/
CREATE TABLE VENTAS(
	ID_VENTA INT IDENTITY(1,1) PRIMARY KEY,
	ID_FACTURA INT NOT NULL,
	ID_EMPLEADO INT NOT NULL,
	ID_PRODUCTO VARCHAR(50) NOT NULL,
	DESCRIPCION VARCHAR(100) NOT NULL,
	FECHA_VENTA DATE  DEFAULT GETDATE() NOT NULL,
	CANTIDAD INT NOT NULL,
	PRECIO_UNIDAD DECIMAL(10,2) NOT NULL,
	TOTAL DECIMAL(10,2) NOT NULL
)

/*Creamos la restriccion de la tabla*/
ALTER TABLE VENTAS
ADD CONSTRAINT CKH_FECHA_VENTA CHECK(FECHA_VENTA <= GETDATE());
GO
/*--------------------------------------------------------------------------------*/

/*Implementamos las relaciones entre las tablas*/

/*Agregamos la referencia de la tabla PRODUCTOS la cual tiene relaciones con PROVEEDORES*/

ALTER TABLE PRODUCTOS
ADD CONSTRAINT CHK_PRODUCTOS_PROVEEDORES
FOREIGN KEY (ID_PROVEEDOR) REFERENCES PROVEEDORES(ID_PROVEEDOR);

/*Cre�mos la referencia de la tabla inventarios con la tabla productos*/

ALTER TABLE INVENTARIOS
ADD CONSTRAINT CHK_INVENTARIOS_PRODUCTOS
FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO);

/*Cre�mos las referencias de la tabla facturacion con la tabla productos y empleados*/

ALTER TABLE FACTURAS
ADD CONSTRAINT CHK_FACTURAS_EMPLEADOS
FOREIGN KEY (ID_EMPLEADO) REFERENCES EMPLEADOS(ID_EMPLEADO);

ALTER TABLE FACTURAS
ADD CONSTRAINT CHK_FACTURAS_PRODUCTOS
FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO);

/*Crea�mos la relaci�n de la tabla clientes con la tabla facturas*/
ALTER TABLE CLIENTES
ADD CONSTRAINT CHK_CLIENTES_FACTURAS
FOREIGN KEY (ID_FACTURA) REFERENCES FACTURAS(ID_FACTURA);

/*Creamos las relaciones de la tabla ventas con facturas,empleados y productos*/

ALTER TABLE VENTAS
ADD CONSTRAINT CHK_VENTAS_FACTURAS
FOREIGN KEY (ID_FACTURA) REFERENCES FACTURAS(ID_FACTURA);

ALTER TABLE VENTAS
ADD CONSTRAINT CHK_VENTAS_EMPLEADOS
FOREIGN KEY (ID_EMPLEADO) REFERENCES EMPLEADOS(ID_EMPLEADO);

ALTER TABLE VENTAS
ADD CONSTRAINT CHK_VENTAS_PRODUCTOS
FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO);
GO
