/*	DANNY SOTO J.
	14/04/2022
*/

/*En este script crearémos todos los procedimientos almacenados, triggers , vistas y consultas necesarias para
  solucionar el problema  presentado*/
USE SUPERMERCADODB
GO
/*-------------------------------------------------------------------------------------------*/
/* 1- Desarrollamos un trigger que se dispare al vender un producto en facturas,
  actualizando el campo de CANTIDAD_VENDIDA  en la tabla de inventario y restando 
  la CANTIDAD_VENDIDA  con EXISTENCIA. además, 
  en el mismo trigger se dispara cargando la información
  requerida en la tabla ventas
  */
GO
CREATE OR ALTER TRIGGER TR_FI_FACTURAS
ON FACTURAS
FOR INSERT
AS
	DECLARE @ID_FACTURA INT,@ID_EMPLEADO INT,@ID_PRODUCTO VARCHAR(50),@DESCRIPCION VARCHAR(100),@CANTIDAD INT,@PRECIO_UNIDAD DECIMAL(10,2), @TOTAL DECIMAL(10,2)
	SELECT @ID_FACTURA = ID_FACTURA FROM inserted
	SELECT @ID_EMPLEADO = ID_EMPLEADO FROM inserted
	SELECT @ID_PRODUCTO = ID_PRODUCTO FROM inserted
	SELECT @DESCRIPCION = DESCRIPCION FROM inserted
	SELECT @CANTIDAD = CANTIDAD FROM inserted
	SELECT @PRECIO_UNIDAD = PRECIO_UNIDAD FROM inserted
	SELECT @TOTAL = TOTAL FROM inserted
	

	IF(EXISTS(SELECT ID_PRODUCTO FROM INVENTARIOS WHERE ID_PRODUCTO = @ID_PRODUCTO))
	--Actualizamos la tabla de inventario    (se suma la cantidad vendida a las vendidas anteriormente )
		UPDATE INVENTARIOS SET CANTIDAD_VENDIDA += @CANTIDAD, EXISTENCIA -= @CANTIDAD
		/*Insertamos la venta realizada en la tabla ventas*/
		INSERT INTO VENTAS(ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,CANTIDAD,PRECIO_UNIDAD,TOTAL)
				VALUES(@ID_FACTURA,@ID_EMPLEADO,@ID_PRODUCTO,@DESCRIPCION,@CANTIDAD,@PRECIO_UNIDAD, @TOTAL)
		
GO
/*-------------------------------------------------------------------------------------------*/
/* 2- Desarrollamos un procedimiento almacenado para insertar un EMPLEADO Y si existe lo actualiza*/
CREATE OR ALTER PROCEDURE SP_INSERTAR_EMPLEADO(@ID_EMPLEADO INT OUT,@NOMBRE VARCHAR(20),@PRIMER_APELLIDO VARCHAR(20),@SEGUNDO_APELLIDO VARCHAR(20),
											   @TELEFONO VARCHAR(20),@CORREO VARCHAR(20),@DIRECCION VARCHAR(100),@CARGO VARCHAR(30),
											   @FECHA_INGRESO DATE,@NOMBRE_USUARIO VARCHAR(20),@CONTRASENIA VARCHAR(15), @MSJ VARCHAR(100) OUT)
AS
BEGIN
	BEGIN TRY
		BEGIN TRANSACTION
			/*Si el id_empleado no está registrado  vamos a ingresar un empleado con un nuevo id*/
			IF(NOT EXISTS(SELECT 1 FROM EMPLEADOS WHERE ID_EMPLEADO = @ID_EMPLEADO))
				BEGIN
					INSERT INTO EMPLEADOS(NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,
										  CORREO,DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA)
								   VALUES(@NOMBRE,@PRIMER_APELLIDO,@SEGUNDO_APELLIDO,@TELEFONO,
										  @CORREO,@DIRECCION,@CARGO,@FECHA_INGRESO,@NOMBRE_USUARIO,@CONTRASENIA)
								   SET @MSJ = 'Empleado agregado correctamente'
				END
				/*Si ya está registrado lo vamos a actualizar*/
			ELSE
				BEGIN
					UPDATE EMPLEADOS SET NOMBRE = @NOMBRE,
										 PRIMER_APELLIDO = @PRIMER_APELLIDO,
										 SEGUNDO_APELLIDO = @SEGUNDO_APELLIDO,
										 TELEFONO = @TELEFONO,
										 CORREO =  @CORREO,
										 DIRECCION = @DIRECCION,
										 CARGO = @CARGO,
										 FECHA_INGRESO = @FECHA_INGRESO,
										 NOMBRE_USUARIO = @NOMBRE_USUARIO,
										 CONTRASENIA = @CONTRASENIA
					WHERE ID_EMPLEADO = @ID_EMPLEADO
					SET @MSJ = 'Empleado actualizado correctamente'
				END
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		ROLLBACK TRANSACTION
		SET @MSJ = ERROR_MESSAGE()
	END CATCH
END
GO
/*-------------------------------------------------------------------------------------------*/

/*Ejecutamos el procedimiento almacenado SP_INSERTAR_EMPLEADO*/
GO	
DECLARE @RC int
DECLARE @ID_EMPLEADO int
DECLARE @NOMBRE varchar(20)
DECLARE @PRIMER_APELLIDO varchar(20)
DECLARE @SEGUNDO_APELLIDO varchar(20)
DECLARE @TELEFONO varchar(20)
DECLARE @CORREO varchar(20)
DECLARE @DIRECCION varchar(100)
DECLARE @CARGO varchar(30)
DECLARE @FECHA_INGRESO date
DECLARE @NOMBRE_USUARIO varchar(20)
DECLARE @CONTRASENIA varchar(15)
DECLARE @MSJ varchar(100)

SET @ID_EMPLEADO = 1
SET @NOMBRE = 'Danny'
SET @PRIMER_APELLIDO = 'Soto'
SET @SEGUNDO_APELLIDO = 'Jiménez'
SET @TELEFONO = '84111915'
SET @CORREO = 'dnnst89@gmail.com'
SET @DIRECCION = 'Atenas'
SET @CARGO = 'Cajero'
SET @FECHA_INGRESO = GETDATE()
SET @NOMBRE_USUARIO = 'Dsoto'
SET @CONTRASENIA = 'Danny89'

EXECUTE @RC = [dbo].[SP_INSERTAR_EMPLEADO] 
   @ID_EMPLEADO OUTPUT
  ,@NOMBRE
  ,@PRIMER_APELLIDO
  ,@SEGUNDO_APELLIDO
  ,@TELEFONO
  ,@CORREO
  ,@DIRECCION
  ,@CARGO
  ,@FECHA_INGRESO
  ,@NOMBRE_USUARIO
  ,@CONTRASENIA
  ,@MSJ OUTPUT
  PRINT @MSJ
/*-------------------------------------------------------------------------------------------*/
--Creamos procedimiento almacenado para eliminar un empleado
GO
CREATE OR ALTER PROCEDURE SP_ELIMINAR_EMPLEADO(@ID_EMPLEADO INT OUT,@MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(NOT EXISTS(SELECT 1 FROM EMPLEADOS WHERE ID_EMPLEADO = @ID_EMPLEADO))
					BEGIN
						SET @MSJ = 'No se encontraron registros'
					END
				ELSE
					BEGIN
						DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = @ID_EMPLEADO
						SET @MSJ = 'Empleado eliminado correctamente'
					END
			COMMIT TRANSACTION			
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO

/*-------------------------------------------------------------------------------------------*/

/* 3- Creámos procedimiento almacenado para cambiar el estado de un empleado a INA ya que no se podrá eliminar completamente*/
GO
CREATE OR ALTER PROCEDURE SP_ESTADO_EMPLEADO_INA(@ID_EMPLEADO INT OUT, @MSJ VARCHAR(100) OUT)
AS
BEGIN
	BEGIN TRY
		BEGIN TRANSACTION
			/*Si el id_empleado está registrado  vamos a actualizar el estado a inactivo*/
			IF(EXISTS(SELECT 1 FROM EMPLEADOS WHERE ID_EMPLEADO = @ID_EMPLEADO))
				BEGIN
					UPDATE EMPLEADOS SET ESTADO = 'INA'										
					WHERE ID_EMPLEADO = @ID_EMPLEADO
					SET @MSJ = 'Inactivado correctamente'
				END
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		ROLLBACK TRANSACTION
		SET @MSJ = ERROR_MESSAGE()
	END CATCH
END
GO
/*-------------------------------------------------------------------------------------------*/
/*Ejecutamos el procedimiento almacenado SP_ESTADO_EMPLEADO_INA*/

GO
DECLARE @RC int
DECLARE @ID_EMPLEADO int
DECLARE @MSJ varchar(100)

SET @ID_EMPLEADO = 1

EXECUTE @RC = [dbo].[SP_ESTADO_EMPLEADO_INA] 
   @ID_EMPLEADO OUTPUT
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------*/
/* 4- Precedimiento almacenado para insertar un provedor, si existe lo actualiza*/
GO
CREATE OR ALTER PROCEDURE SP_INSERTAR_PROVEEDOR(@ID_PROVEEDOR INT OUT,@NOMBRE_PROVEEDOR VARCHAR(20),@DIRECCION VARCHAR(100),@TELEFONO VARCHAR(20),
											   @EXTENSION INT,@CORREO VARCHAR(30),@NUMERO_CUENTA VARCHAR(30), @MSJ VARCHAR(100) OUT)
AS
BEGIN
	BEGIN TRY
		BEGIN TRANSACTION
			/*Si el id_proveedor no está registrado  vamos a ingresar un proveedor con un nuevo id*/
			IF(NOT EXISTS(SELECT 1 FROM PROVEEDORES WHERE ID_PROVEEDOR = @ID_PROVEEDOR))
				BEGIN
					INSERT INTO PROVEEDORES(NOMBRE_PROVEEDOR,DIRECCION,TELEFONO,EXTENSION,CORREO,NUMERO_CUENTA)
								   VALUES(@NOMBRE_PROVEEDOR,@DIRECCION,@TELEFONO,@EXTENSION,@CORREO,@NUMERO_CUENTA)
								   SET @MSJ = 'Proveedor agregado correctamente'
				END
				/*Si ya está registrado lo vamos a actualizar*/
			ELSE
				BEGIN
					UPDATE PROVEEDORES SET NOMBRE_PROVEEDOR = @NOMBRE_PROVEEDOR,
										   DIRECCION = @DIRECCION,
										   TELEFONO = @TELEFONO,
										   EXTENSION = @EXTENSION,
										   CORREO = @CORREO,
										   NUMERO_CUENTA = @NUMERO_CUENTA
					WHERE ID_PROVEEDOR= @ID_PROVEEDOR
					SET @MSJ = 'Proveedor actualizado correctamente'
				END
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		ROLLBACK TRANSACTION
		SET @MSJ = ERROR_MESSAGE()
	END CATCH
END
GO
/*-------------------------------------------------------------------------------------------*/
--EXECUTE STORED PROCEDURE #4
GO
DECLARE @RC int
DECLARE @ID_PROVEEDOR int
DECLARE @NOMBRE_PROVEEDOR varchar(20)
DECLARE @DIRECCION varchar(100)
DECLARE @TELEFONO varchar(20)
DECLARE @EXTENSION int
DECLARE @CORREO varchar(30)
DECLARE @NUMERO_CUENTA varchar(30)
DECLARE @MSJ varchar(100)

SET @ID_PROVEEDOR = 3
SET @NOMBRE_PROVEEDOR = 'Cafe Montaña'
SET @DIRECCION = 'Heredia'
SET @TELEFONO = '26561236'
SET @EXTENSION = 124
SET @CORREO = 'ventar@montaña.com'
SET @NUMERO_CUENTA = 'IBAN1245004588213'

EXECUTE @RC = [dbo].[SP_AGREGAR_PROVEEDOR] 
   @ID_PROVEEDOR OUTPUT
  ,@NOMBRE_PROVEEDOR
  ,@DIRECCION
  ,@TELEFONO
  ,@EXTENSION
  ,@CORREO
  ,@NUMERO_CUENTA
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------*/
/*CREAT EVERYTHING FROM SCRATCH TO LEARN MORE HOW TO DO IT*/
-- 5- Se crea procedimiento almacenado para eliminar un proveedor
GO
CREATE OR ALTER PROCEDURE SP_ELIMINAR_PROVEEDOR(@ID_PROVEEDOR INT OUT,@MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(NOT EXISTS(SELECT 1 FROM PROVEEDORES WHERE ID_PROVEEDOR = @ID_PROVEEDOR))
					BEGIN
						SET @MSJ = 'No se encontraron registros'
					END
				ELSE
					BEGIN
						DELETE FROM PROVEEDORES WHERE ID_PROVEEDOR = @ID_PROVEEDOR
						SET @MSJ = 'Proveedor eliminado correctamente'
					END
			COMMIT TRANSACTION			
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
/*-------------------------------------------------------------------------------------------*/
--EXECUTE STORED PROCEDURE #5
GO
DECLARE @RC int
DECLARE @ID_PROVEEDOR int
DECLARE @MSJ varchar(100)

SET @ID_PROVEEDOR = 0

EXECUTE @RC = [dbo].[SP_ELIMINAR_PROVEEDOR] 
   @ID_PROVEEDOR OUTPUT
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------*/

-- 6- Creamos un procedimiento almacenado que nos permita agregar un producto, si es producto existe lo podemos actualizar
GO
CREATE OR ALTER PROCEDURE SP_INSERTAR_PRODUCTO(@ID_PRODUCTO VARCHAR(50) OUT,
											   @ID_PROVEEDOR INT,
											   @DESCRIPCION VARCHAR(100),
											   @PRECIO_UNIDAD DECIMAL(10,2),
											   @MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(EXISTS(SELECT 1 FROM PRODUCTOS WHERE ID_PRODUCTO = @ID_PRODUCTO))
					BEGIN
						UPDATE PRODUCTOS SET ID_PROVEEDOR = @ID_PROVEEDOR,
											 DESCRIPCION = @DESCRIPCION,
											 PRECIO_UNIDAD = @PRECIO_UNIDAD
						WHERE ID_PRODUCTO = @ID_PRODUCTO
						SET @MSJ = 'Producto actualizado correctamente'
					END
				ELSE
					BEGIN
						INSERT INTO PRODUCTOS(ID_PRODUCTO,ID_PROVEEDOR,DESCRIPCION,PRECIO_UNIDAD)
										VALUES(@ID_PRODUCTO,@ID_PROVEEDOR,@DESCRIPCION,@PRECIO_UNIDAD)
						SET @MSJ = 'Producto agregado correctamente'
					END
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO

/*-------------------------------------------------------------------------------------------*/
--EXECUTE STORED PROCEDURE #6
GO
DECLARE @RC int
DECLARE @ID_PRODUCTO VARCHAR(50)
DECLARE @ID_PROVEEDOR int
DECLARE @DESCRIPCION varchar(100)
DECLARE @PRECIO_UNIDAD decimal(10,2)
DECLARE @MSJ varchar(100)

SET @ID_PRODUCTO = '1450045134501'
SET @ID_PROVEEDOR = 3
SET @DESCRIPCION = 'Cafe Tueste Claro 250G'
SET @PRECIO_UNIDAD = 1100.00

EXECUTE @RC = [dbo].[SP_INSERTAR_PRODUCTO] 
   @ID_PRODUCTO OUTPUT
  ,@ID_PROVEEDOR
  ,@DESCRIPCION
  ,@PRECIO_UNIDAD
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------*/
-- 7- procedimiento almacenado para eliminar un producto
GO
CREATE PROCEDURE SP_ELIMINAR_PRODUCTO(@ID_PRODUCTO VARCHAR(50) OUT, @MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(EXISTS(SELECT 1 FROM PRODUCTOS WHERE ID_PRODUCTO = @ID_PRODUCTO))
					BEGIN
						DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = @ID_PRODUCTO
						SET @MSJ = 'Producto eliminado correctamente'
					END
				ELSE
					BEGIN
						SET @MSJ = 'No se encontraron registros'
					END
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
/*-------------------------------------------------------------------------------------------*/
/*EXECUTE STORED PROCEDURE #7*/
GO
DECLARE @RC int
DECLARE @ID_PRODUCTO varchar(50)
DECLARE @MSJ varchar(100)

SET @ID_PRODUCTO = '1450045134501'

EXECUTE @RC = [dbo].[SP_ELIMINAR_PRODUCTO] 
   @ID_PRODUCTO OUTPUT
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------
-- 8- Creamos procedimiento almacenado para insertar un factura*/
-- Recordemos que al insertar una factura debería de verse afectadas las tablas ventas e inventarios
-- ademas, de la de facturas por supuesto.
GO
CREATE OR ALTER PROCEDURE SP_INSERTAR_FACTURA(@ID_FACTURA INT OUT,
											  @ID_EMPLEADO INT,
											  @ID_PRODUCTO VARCHAR(50),
											  @DESCRIPCION VARCHAR(100),
											  @CANTIDAD INT,
											  @PRECIO_UNIDAD DECIMAL(10,2),
											  @SUBTOTAL DECIMAL(10,2),
											  @IVA DECIMAL(4,2),
											  @DESCUENTO DECIMAL(4,2),
											  @TOTAL DECIMAL(10,2),
											  @MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(NOT EXISTS(SELECT 1 FROM FACTURAS WHERE ID_FACTURA = @ID_FACTURA))
					BEGIN
						INSERT INTO FACTURAS(ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,CANTIDAD,PRECIO_UNIDAD,SUBTOTAL,IVA,DESCUENTO,TOTAL)
									  VALUES(@ID_EMPLEADO,@ID_PRODUCTO,@DESCRIPCION,@CANTIDAD,@PRECIO_UNIDAD,@SUBTOTAL,@IVA,@DESCUENTO,@TOTAL)
						SET @MSJ = 'Factura insertada correctamente'
					END
				ELSE
					BEGIN
						UPDATE FACTURAS SET ID_EMPLEADO = @ID_EMPLEADO,
											ID_PRODUCTO = @ID_PRODUCTO,
											DESCRIPCION = @DESCRIPCION,
											CANTIDAD = @CANTIDAD,
											PRECIO_UNIDAD = @PRECIO_UNIDAD,
											SUBTOTAL = @SUBTOTAL,
											IVA = @IVA,
											DESCUENTO = @DESCUENTO,
											TOTAL = @TOTAL
						WHERE ID_FACTURA = @ID_FACTURA
						SET @MSJ = 'Factura actualiada correctamente'
					END
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
/*-------------------------------------------------------------------------------------------*/
--EXECUTE STORED PROCEDURE #8
GO
DECLARE @RC int
DECLARE @ID_FACTURA int
DECLARE @ID_EMPLEADO int
DECLARE @ID_PRODUCTO varchar(50)
DECLARE @DESCRIPCION varchar(100)
DECLARE @CANTIDAD int
DECLARE @PRECIO_UNIDAD decimal(10,2)
DECLARE @SUBTOTAL decimal(10,2)
DECLARE @IVA decimal(4,2)
DECLARE @DESCUENTO decimal(4,2)
DECLARE @TOTAL decimal(10,2)
DECLARE @MSJ varchar(100)

SET @ID_EMPLEADO = 7
SET @ID_PRODUCTO = '7896359014811'
SET @DESCRIPCION = 'Fanta Fresa 300 ml'
SET @CANTIDAD = 5
SET @PRECIO_UNIDAD = 1300.00
SET @SUBTOTAL = 2300.00
SET @IVA = 0.13
SET @DESCUENTO = 0
SET @TOTAL = 2415.00

EXECUTE @RC = [dbo].[SP_INSERTAR_FACTURA] 
   @ID_FACTURA OUTPUT
  ,@ID_EMPLEADO
  ,@ID_PRODUCTO
  ,@DESCRIPCION
  ,@CANTIDAD
  ,@PRECIO_UNIDAD
  ,@SUBTOTAL
  ,@IVA
  ,@DESCUENTO
  ,@TOTAL
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------*/
-- 9- Creamos un procedimiento almacenado que nos permita filtar las ventas según la fecha ingresada mediante consulta
GO
CREATE OR ALTER PROCEDURE SP_FILTRAR_VENTAS_XFECHA(@FECHA_SELECCIONADA DATE OUT)
AS
	BEGIN
		SELECT ID_VENTA,ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,FECHA_VENTA,CANTIDAD,PRECIO_UNIDAD,TOTAL AS [TOTAL FINAL]
		FROM VENTAS 
		WHERE FECHA_VENTA = @FECHA_SELECCIONADA
	END
GO
/*-------------------------------------------------------------------------------------------*/
--EXECUTE STORED PROCEDURE #9
GO
DECLARE @RC int
DECLARE @FECHA_SELECCIONADA date

SET @FECHA_SELECCIONADA = '2022-04-16'

EXECUTE @RC = [dbo].[SP_FILTRAR_VENTAS_XFECHA] 
   @FECHA_SELECCIONADA OUTPUT
GO
/*-------------------------------------------------------------------------------------------*/
/* 10- Creámos procedimiento almacenado para filtrar las ventas segun el id del vendedor mediante una consulta*/
GO
CREATE OR ALTER PROCEDURE SP_FILTRAR_VENTAS_XEMPLEADO(@ID_EMPLEADO INT OUT)
AS
	BEGIN
		SELECT ID_VENTA,ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,FECHA_VENTA,CANTIDAD,PRECIO_UNIDAD,TOTAL AS [TOTAL FINAL]
		FROM VENTAS
		WHERE ID_EMPLEADO = @ID_EMPLEADO
	END

GO

--EXECUTE STORED PROCEDURE #10
GO
DECLARE @RC int
DECLARE @ID_EMPLEADO int

SET @ID_EMPLEADO = 7

EXECUTE @RC = [dbo].[SP_FILTRAR_VENTAS_XEMPLEADO] 
   @ID_EMPLEADO OUTPUT
GO
/*-------------------------------------------------------------------------------------------*/
-- 11- Se crea el procedimiento almacenado para insertar un cliente
GO
CREATE OR ALTER PROCEDURE SP_INSERTAR_CLIENTE(@ID_CLIENTE INT OUT,
											  @ID_FACTURA INT,
											  @NUM_IDENTIFICACION VARCHAR(20),
											  @NOMBRE_CLIENTE VARCHAR(20),
											  @APELLIDO1 VARCHAR(20),
											  @APELLIDO2 VARCHAR(20),
											  @TELEFONO VARCHAR(20),
											  @DIRECCION VARCHAR(100),
											  @MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(NOT EXISTS(SELECT 1 FROM CLIENTES WHERE ID_CLIENTE = @ID_CLIENTE))
					BEGIN
						INSERT INTO CLIENTES(ID_FACTURA,NUM_IDENTIFICACION,NOMBRE_CLIENTE,APELLIDO1,APELLIDO2,TELEFONO,DIRECCION)
									  VALUES( @ID_FACTURA,
											  @NUM_IDENTIFICACION,
											  @NOMBRE_CLIENTE,
											  @APELLIDO1,
											  @APELLIDO2,
											  @TELEFONO,
											  @DIRECCION)
						SET @MSJ = 'Cliente ingresado correctamente'
						
					END
				ELSE
					BEGIN
						UPDATE CLIENTES SET ID_FACTURA = @ID_FACTURA,
											NUM_IDENTIFICACION = @NUM_IDENTIFICACION,
											NOMBRE_CLIENTE = @NOMBRE_CLIENTE,
											APELLIDO1 = @APELLIDO1,
											APELLIDO2 = @APELLIDO2,
											TELEFONO = @TELEFONO,
											DIRECCION = @DIRECCION
						WHERE ID_CLIENTE = @ID_CLIENTE
						SET @MSJ = 'Cliente actualizado correctamente'
					END
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
--EXECUTE STORED PRECEDURE #11
GO

DECLARE @RC int
DECLARE @ID_CLIENTE int
DECLARE @ID_FACTURA int
DECLARE @NUM_IDENTIFICACION varchar(20)
DECLARE @NOMBRE_CLIENTE varchar(20)
DECLARE @APELLIDO1 varchar(20)
DECLARE @APELLIDO2 varchar(20)
DECLARE @TELEFONO varchar(20)
DECLARE @DIRECCION varchar(100)
DECLARE @MSJ varchar(100)

SET @ID_CLIENTE = 1
SET @ID_FACTURA = 4
SET @NUM_IDENTIFICACION = '202314569'
SET @NOMBRE_CLIENTE = 'Miguel'
SET @APELLIDO1 = 'Ruiz'
SET @APELLIDO2 = 'Gómez'
SET @TELEFONO = '84576932'
SET @DIRECCION = 'Alajuela'


EXECUTE @RC = [dbo].[SP_INSERTAR_CLIENTE] 
   @ID_CLIENTE OUTPUT
  ,@ID_FACTURA
  ,@NUM_IDENTIFICACION
  ,@NOMBRE_CLIENTE
  ,@APELLIDO1
  ,@APELLIDO2
  ,@TELEFONO
  ,@DIRECCION
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------*/
-- 12- se desarrolla procedimiento almacenado para eliminar un cliente
GO
CREATE OR ALTER PROCEDURE SP_ELIMINAR_CLIENTE(@ID_CLIENTE INT OUT, @MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION	
				IF(EXISTS(SELECT 1 FROM CLIENTES WHERE ID_CLIENTE = @ID_CLIENTE))
					BEGIN
						DELETE FROM CLIENTES WHERE ID_CLIENTE = @ID_CLIENTE
						SET @MSJ = 'Eliminado correctamente'
					END
				ELSE
					SET @MSJ = 'No se encontraron registros'
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
/*-------------------------------------------------------------------------------------------*/
--EXECUTE PROCEDURE #12
GO

DECLARE @RC int
DECLARE @ID_CLIENTE int
DECLARE @MSJ varchar(100)

SET @ID_CLIENTE = 1

EXECUTE @RC = [dbo].[SP_ELIMINAR_CLIENTE] 
   @ID_CLIENTE OUTPUT
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
-- 13- Se crea el procedimiento almacenado para actualizar el inventario
GO
CREATE OR ALTER PROCEDURE SP_ACTUALIZAR_INVENTARIO(@ID_INVENTARIO INT OUT,
												   @ID_PRODUCTO VARCHAR(50),
												   @DESCRIPTION VARCHAR(100),
												   @CANTIDAD_INGRESADO INT,
												   @EXISTENCIA INT,
												   @CANTIDAD_VENDIDA INT,
												   @PRECIO_UNIDAD DECIMAL(10,2),
												   @MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(EXISTS(SELECT 1 FROM INVENTARIOS WHERE ID_INVENTARIO = @ID_INVENTARIO))
					BEGIN
						UPDATE INVENTARIOS SET ID_PRODUCTO = @ID_PRODUCTO,
											   DESCRIPCION = @DESCRIPTION,
											   CANTIDA_INGRESADA = @CANTIDAD_INGRESADO,
											   EXISTENCIA =  @EXISTENCIA,
											   CANTIDAD_VENDIDA = @CANTIDAD_VENDIDA,
											   PRECIO_UNIDAD = @PRECIO_UNIDAD
						WHERE ID_INVENTARIO = @ID_INVENTARIO
						SET @MSJ = 'Inventario actualizado correctamente'
					END
				ELSE
					BEGIN
						SET @MSJ = 'No se encontraron registros'
					END
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
/*-------------------------------------------------------------------------------------------*/
--EXECUTE STORED PROCEDURE #13
GO

DECLARE @RC int
DECLARE @ID_INVENTARIO int
DECLARE @ID_PRODUCTO varchar(50)
DECLARE @DESCRIPTION varchar(100)
DECLARE @CANTIDAD_INGRESADO int
DECLARE @EXISTENCIA int
DECLARE @CANTIDAD_VENDIDA int
DECLARE @PRECIO_UNIDAD decimal(10,2)
DECLARE @MSJ varchar(100)

SET @ID_INVENTARIO = 1
SET @ID_PRODUCTO = '7896359014811'
SET @DESCRIPTION = 'Fanta Fresa 300 ml'
SET @CANTIDAD_INGRESADO = 10
SET @EXISTENCIA = 100
SET @CANTIDAD_VENDIDA = 13
SET @PRECIO_UNIDAD = 450.00


EXECUTE @RC = [dbo].[SP_ACTUALIZAR_INVENTARIO] 
   @ID_INVENTARIO OUTPUT
  ,@ID_PRODUCTO
  ,@DESCRIPTION
  ,@CANTIDAD_INGRESADO
  ,@EXISTENCIA
  ,@CANTIDAD_VENDIDA
  ,@PRECIO_UNIDAD
  ,@MSJ OUTPUT
  PRINT @MSJ
GO
/*-------------------------------------------------------------------------------------------*/
-- 14- Creámos procedimiento almacenado para eliminar un producto del inventario
GO
CREATE OR ALTER PROCEDURE SP_ELIMINAR_PRODUCTO_INVENTARIO(@ID_INVENTARIO INT OUT, @MSJ VARCHAR(100) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION	
				IF(EXISTS(SELECT 1 FROM INVENTARIOS WHERE ID_INVENTARIO = @ID_INVENTARIO))
					BEGIN
						DELETE FROM INVENTARIOS WHERE ID_INVENTARIO = @ID_INVENTARIO
						SET @MSJ = 'Eliminado correctamente'
					END
				ELSE
					SET @MSJ = 'No se encontraron registros'
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
/*-------------------------------------------------------------------------------------------*/
--EXECUTE STORED PRECEDURE #14
GO

DECLARE @RC int
DECLARE @ID_INVENTARIO int
DECLARE @MSJ varchar(100)

SET @ID_INVENTARIO = 1

EXECUTE @RC = [dbo].[SP_ELIMINAR_PRODUCTO_INVENTARIO] 
   @ID_INVENTARIO OUTPUT
  ,@MSJ OUTPUT
GO
/*-------------------------------------------------------------------------------------------*/
-- 15- creámos procedimiento almacenado para actualizar una venta
CREATE OR ALTER PROCEDURE SP_ACTUALIZAR_VENTAS




-- 16- Creámos procedimiento almacenado para eliminar una venta
CREATE OR ALTER PROCEDURE SP_ELIMINAR_VENTAS
