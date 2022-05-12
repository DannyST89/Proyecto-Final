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
CREATE TRIGGER TR_FI_FACTURAS
ON FACTURAS
FOR INSERT

AS
	DECLARE @ID_FACTURA INT,@ID_EMPLEADO INT,@ID_PRODUCTO INT,@DESCRIPCION VARCHAR(100),@CANTIDAD INT,@PRECIO_UNIDAD DECIMAL(10,2), @TOTAL DECIMAL(10,2)
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
		WHERE ID_PRODUCTO = @ID_PRODUCTO

		/*Insertamos la venta realizada en la tabla ventas*/
		INSERT INTO VENTAS(ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,CANTIDAD,PRECIO_UNIDAD,TOTAL)
				VALUES(@ID_FACTURA,@ID_EMPLEADO,@ID_PRODUCTO,@DESCRIPCION,@CANTIDAD,@PRECIO_UNIDAD, @TOTAL)
		
GO
--AL ELIMINARSE UNA FACTURA
GO
CREATE TRIGGER TR_FD_FACTURAS
ON FACTURAS
FOR DELETE

AS
	DECLARE @ID_PRODUCTO INT ,@CANTIDAD INT
	SELECT @ID_PRODUCTO = ID_PRODUCTO FROM deleted
	SELECT @CANTIDAD = CANTIDAD FROM deleted
	

	IF(EXISTS(SELECT ID_PRODUCTO FROM INVENTARIOS WHERE ID_PRODUCTO = @ID_PRODUCTO))
	--Actualizamos la tabla de inventario    (se suma la cantidad vendida a las vendidas anteriormente )
		UPDATE INVENTARIOS SET CANTIDAD_VENDIDA -= @CANTIDAD, EXISTENCIA += @CANTIDAD
		WHERE ID_PRODUCTO = @ID_PRODUCTO
		
GO
/*-------------------------------------------------------------------------------------------*/
/* 2- Desarrollamos un procedimiento almacenado para insertar un EMPLEADO Y si existe lo actualiza*/
GO
CREATE PROCEDURE SP_INSERTAR_EMPLEADO(@ID_EMPLEADO INT OUT,@NOMBRE VARCHAR(20),@PRIMER_APELLIDO VARCHAR(20),@SEGUNDO_APELLIDO VARCHAR(20),
											   @TELEFONO VARCHAR(20),@CORREO VARCHAR(30),@DIRECCION VARCHAR(100),@CARGO VARCHAR(30),
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
-- 3- Creamos procedimiento almacenado para eliminar un empleado
GO
CREATE PROCEDURE SP_ELIMINAR_EMPLEADO(@ID_EMPLEADO INT OUT,@MSJ VARCHAR(100) OUT)
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
						SET @MSJ = 'Eliminado Correctamente'
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
/* 5- Precedimiento almacenado para insertar un provedor, si existe lo actualiza*/
GO
CREATE PROCEDURE SP_INSERTAR_PROVEEDOR(@ID_PROVEEDOR INT OUT,@NOMBRE_PROVEEDOR VARCHAR(20),@DIRECCION VARCHAR(100),@TELEFONO VARCHAR(20),
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
/*-------------------------------------------------------------------------------------------*/
/*-------------------------------------------------------------------------------------------*/
/*CREAT EVERYTHING FROM SCRATCH TO LEARN MORE HOW TO DO IT*/
-- 6- Se crea procedimiento almacenado para eliminar un proveedor
GO
CREATE PROCEDURE SP_ELIMINAR_PROVEEDOR(@ID_PROVEEDOR INT OUT,@MSJ VARCHAR(100) OUT)
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
						SET @MSJ = 'Proveedor Eliminado'
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

-- 7- Creamos un procedimiento almacenado que nos permita agregar un producto, si es producto existe lo podemos actualizar
GO
CREATE PROCEDURE SP_INSERTAR_PRODUCTO(@ID_PRODUCTO INT OUT,											   
											   @ID_PROVEEDOR INT,											   
											   @NOMBRE_PROVEEDOR VARCHAR(20),
											   @DESCRIPCION VARCHAR(100),
											   @PRECIO_UNIDAD DECIMAL(10,2),
											   @MSJ VARCHAR(200) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(EXISTS(SELECT 1 FROM PRODUCTOS WHERE ID_PRODUCTO = @ID_PRODUCTO))
					BEGIN
						UPDATE PRODUCTOS SET ID_PROVEEDOR = @ID_PROVEEDOR,											 
											 NOMBRE_PROVEEDOR = @NOMBRE_PROVEEDOR,
											 DESCRIPCION = @DESCRIPCION,
											 PRECIO_UNIDAD = @PRECIO_UNIDAD
						WHERE ID_PRODUCTO = @ID_PRODUCTO
						SET @MSJ = 'Producto actualizado correctamente'
					END
				ELSE
					BEGIN
						INSERT INTO PRODUCTOS(ID_PROVEEDOR,NOMBRE_PROVEEDOR,DESCRIPCION,PRECIO_UNIDAD)
										VALUES(@ID_PROVEEDOR,@NOMBRE_PROVEEDOR,@DESCRIPCION,@PRECIO_UNIDAD)
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
-- 8- procedimiento almacenado para eliminar un producto
GO
CREATE PROCEDURE SP_ELIMINAR_PRODUCTO(@ID_PRODUCTO INT OUT, @MSJ VARCHAR(200) OUT)
AS 
	BEGIN
		IF NOT EXISTS(SELECT 1 FROM PRODUCTOS WHERE ID_PRODUCTO=@ID_PRODUCTO) 
			SET @MSJ='No se encontraron registros'
		ELSE
			BEGIN
				IF NOT EXISTS(SELECT 1 FROM INVENTARIOS WHERE ID_PRODUCTO=@ID_PRODUCTO) 
					BEGIN
						DELETE FROM PRODUCTOS WHERE ID_PRODUCTO=@ID_PRODUCTO
						SET @MSJ='Producto eliminado correctamente'
					END
				ELSE
					SET @MSJ='No es posible eliminar un producto que tenga inventario'
			END
	END
GO
/*-------------------------------------------------------------------------------------------*/
-- 9- Creamos procedimiento almacenado para insertar un factura*/
-- Recordemos que al insertar una factura debería de verse afectadas las tablas ventas e inventarios
-- ademas, de la de facturas por supuesto.
GO
CREATE PROCEDURE SP_INSERTAR_FACTURA(@ID_FACTURA INT OUT,
											  @ID_EMPLEADO INT,
											  @ID_PRODUCTO INT,
											  @DESCRIPCION VARCHAR(100),
											  @CANTIDAD INT,
											  @PRECIO_UNIDAD DECIMAL(10,2),
											  @SUBTOTAL DECIMAL(10,2),
											  @IVA DECIMAL(10,2),
											  @DESCUENTO INT,
											  @TOTAL DECIMAL(10,2),
											  @MSJ VARCHAR(200) OUT)
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
				IF(EXISTS(SELECT 1 FROM FACTURAS WHERE ID_FACTURA = @ID_FACTURA))
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
-- 10- Creamos un procedimiento almacenado que nos permita filtar las ventas según la fecha ingresada mediante consulta
GO
CREATE PROCEDURE SP_FILTRAR_VENTAS_XFECHA(@FECHA_SELECCIONADA DATE OUT)
AS
	BEGIN
		SELECT ID_VENTA,ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,FECHA_VENTA,CANTIDAD,PRECIO_UNIDAD,TOTAL AS [TOTAL FINAL]
		FROM VENTAS 
		WHERE FECHA_VENTA = @FECHA_SELECCIONADA
	END
GO
/*-------------------------------------------------------------------------------------------*/
/* 11- Creámos procedimiento almacenado para filtrar las ventas segun el id del vendedor mediante una consulta*/
GO
CREATE PROCEDURE SP_FILTRAR_VENTAS_XEMPLEADO(@ID_EMPLEADO INT OUT)
AS
	BEGIN
		SELECT ID_VENTA,ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,FECHA_VENTA,CANTIDAD,PRECIO_UNIDAD,TOTAL AS [TOTAL FINAL]
		FROM VENTAS
		WHERE ID_EMPLEADO = @ID_EMPLEADO
	END

GO
/*-------------------------------------------------------------------------------------------*/
-- 12- se desarrolla procedimiento almacenado para eliminar un cliente
GO
CREATE PROCEDURE SP_ELIMINAR_CLIENTE(@ID_CLIENTE INT OUT, @MSJ VARCHAR(100) OUT)
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
-- 13- Se crea el procedimiento almacenado para actualizar el inventario
GO
CREATE PROCEDURE SP_ACTUALIZAR_INVENTARIO(@ID_INVENTARIO INT OUT,
												   @ID_PRODUCTO VARCHAR(50),
												   @DESCRIPTION VARCHAR(100),
												   @CANTIDAD_INGRESADO INT,
												   @EXISTENCIA INT,
												   @MSJ VARCHAR(200) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION
				IF(EXISTS(SELECT 1 FROM INVENTARIOS WHERE ID_INVENTARIO = @ID_INVENTARIO))
					BEGIN
						UPDATE INVENTARIOS SET ID_PRODUCTO = @ID_PRODUCTO,
											   DESCRIPCION = @DESCRIPTION,
											   CANTIDA_INGRESADA = @CANTIDAD_INGRESADO,
											   EXISTENCIA +=  @CANTIDAD_INGRESADO
						WHERE ID_INVENTARIO = @ID_INVENTARIO
						SET @MSJ = 'Inventario actualizado correctamente'
					END
				ELSE IF(NOT EXISTS(SELECT 1 FROM INVENTARIOS WHERE ID_INVENTARIO = @ID_INVENTARIO))
					BEGIN
						INSERT INTO INVENTARIOS(ID_PRODUCTO, DESCRIPCION, CANTIDA_INGRESADA, EXISTENCIA)
						                  VALUES(@ID_PRODUCTO , @DESCRIPTION , @CANTIDAD_INGRESADO, @EXISTENCIA)
						SET @MSJ = 'Registro insertado'
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
-- 14- Creámos procedimiento almacenado para eliminar un producto del inventario
GO
CREATE PROCEDURE SP_ELIMINAR_PRODUCTO_INVENTARIO(@ID_INVENTARIO INT OUT, @MSJ VARCHAR(200) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION	
				IF(EXISTS(SELECT 1 FROM INVENTARIOS WHERE ID_INVENTARIO = @ID_INVENTARIO AND EXISTENCIA = 0))
					BEGIN
						DELETE FROM INVENTARIOS WHERE ID_INVENTARIO = @ID_INVENTARIO
						SET @MSJ = 'Eliminado correctamente'
					END
				ELSE
					BEGIN
						SET @MSJ = 'No es posible eliminar un producto con existencia'
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
---- 15- Creámos procedimiento almacenado para eliminar una venta
CREATE PROCEDURE SP_ELIMINAR_VENTAS(@ID_VENTA INT OUT, @MSJ VARCHAR(100) OUT)
AS
	BEGIN	
		BEGIN TRY	
			BEGIN TRANSACTION
				IF(EXISTS(SELECT 1 FROM VENTAS WHERE ID_VENTA = @ID_VENTA))
					BEGIN
						DELETE FROM VENTAS WHERE ID_VENTA = @ID_VENTA
						SET @MSJ = 'Venta eliminada correctamente'
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
-- 16-- crear un trigger que se dispare al eliminar una venta, 
--       restando de inventarios la cantidad vendida y la existencia de ese producto vendido. además se debe eliminar los registros de la tabla facturas
--       este trigger se crea con la razón de que se realiza una factura pero el cliente finalmente 
--       deside no llevar los productos por diferentes razones
--GO
--CREATE TRIGGER TR_FD_VENTAS
--ON VENTAS
--FOR DELETE
--AS --Obtenemos los valores para eliminar y actualizar las tablas requeridas
--	DECLARE @ID_FACTURA INT
--	DECLARE @ID_VENTA INT
--	DECLARE @ID_PRODUCTO VARCHAR(50) -- Para localizar en inventarios el producto
--	DECLARE @CANTIDAD_VENDIDA INT -- Después de localizar el id, necesitamos actulizar los datos restando la cantidad vendida
--	SET @ID_FACTURA = (SELECT ID_FACTURA FROM deleted)						  -- la cual será eliminada en la tabla ventas
--	SET @ID_VENTA = (SELECT ID_VENTA FROM deleted)
--	SET @ID_PRODUCTO = (SELECT ID_PRODUCTO FROM deleted)
--	SET @CANTIDAD_VENDIDA = (SELECT CANTIDAD FROM deleted)

--	IF(EXISTS( SELECT 1 FROM VENTAS WHERE ID_VENTA = @ID_VENTA))
--		--Al eliminarse la venta, a la cantidad vendida le restamos esa venta que no se hizo 
--		UPDATE INVENTARIOS SET CANTIDAD_VENDIDA -= @CANTIDAD_VENDIDA,
--		-- Actualizamos la existencia sumandole la cantidad vendida eliminada, ya que la crearse la factura se restó de existencia
--							   EXISTENCIA += @CANTIDAD_VENDIDA
--		WHERE ID_PRODUCTO = @ID_PRODUCTO
--GO
/*-------------------------------------------------------------------------------------------*/
/*Trigger que se dispara al eliminar un empleado*/
--CREATE TRIGGER TR_CAMBIA_ESTADO_INA
--ON EMPLEADOS
--INSTEAD OF DELETE
--AS 
--	DECLARE @ID_EMPLEADO INT
--	SET @ID_EMPLEADO = (SELECT ID_EMPLEADO FROM deleted)
--	IF(EXISTS( SELECT 1 FROM EMPLEADOS WHERE ID_EMPLEADO = @ID_EMPLEADO))
		
--		UPDATE EMPLEADOS SET ESTADO = 'INA'		
							  
--		WHERE ID_EMPLEADO= @ID_EMPLEADO
--GO
/*-------------------------------------------------------------------------------------------*/
/*Trigger que se dispara al eliminar un proveedor*/
--CREATE  TRIGGER TR_INACTIVAR_PROVEEDOR
--ON PROVEEDORES
--INSTEAD OF DELETE
--AS 
--	DECLARE @ID_PROVEEDOR INT
--	SET @ID_PROVEEDOR = (SELECT ID_PROVEEDOR FROM deleted)
--	IF(EXISTS( SELECT 1 FROM PROVEEDORES WHERE ID_PROVEEDOR = @ID_PROVEEDOR))
		
--		UPDATE PROVEEDORES SET ESTADO = 'INA'		
							  
--		WHERE ID_PROVEEDOR= @ID_PROVEEDOR
--GO

/*CREAR UN PROCEDIMIENTO ALMACENADO QUE ME PERMITA BUSCAR UN PROVEEDOR*/
GO
CREATE PROCEDURE SP_BUSCAR_PROVEEDOR(@ID_PROVEEDOR INT OUT)
AS
	BEGIN
		SELECT NOMBRE_PROVEEDOR
		FROM PROVEEDORES
		WHERE ID_PROVEEDOR = @ID_PROVEEDOR
	END

GO
--Eliminar una factura
GO
CREATE PROCEDURE SP_ELIMINAR_FACTURA(@ID_FACTURA INT OUT, @MSJ VARCHAR(200) OUT)
AS
	BEGIN
		BEGIN TRY
			BEGIN TRANSACTION	
				IF(EXISTS(SELECT 1 FROM FACTURAS WHERE ID_FACTURA = @ID_FACTURA))
					BEGIN
						DELETE FROM FACTURAS WHERE ID_FACTURA = @ID_FACTURA
						SET @MSJ = 'Eliminada correctamente'
					END
				ELSE
					SET @MSJ = 'No fue posible eliminar la factura'
			COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
			SET @MSJ = ERROR_MESSAGE()
		END CATCH
	END
GO
