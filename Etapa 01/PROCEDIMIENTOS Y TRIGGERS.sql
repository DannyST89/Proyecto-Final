/*	DANNY SOTO J.
	14/04/2022
*/

/*En este script crearémos todos los procedimientos almacenados, triggers necesarios para
  solucionar el problema */
USE SUPERMERCADODB
GO

/*Desarrollamos un trigger que se dispare al insertar un producto en la tabla de PRODUCTOS,
  se debe de insertar ese producto en la tabla de inventarios, en cado de ya exister ese id,
  unicamente se suma a la cantidad de existencia la cantidad que fue ingresada.*/
CREATE OR ALTER TRIGGER TR_FI_PRODUCTO
ON PRODUCTOS
FOR INSERT
AS
	DECLARE @ID_PRODUCTO VARCHAR(50), @DESCRIPCION VARCHAR(50), @CANTIDAD INT,@PRECIO_UNIDAD DECIMAL(10,2)
	SELECT @ID_PRODUCTO = ID_PRODUCTO FROM inserted
	SELECT @DESCRIPCION = DESCRIPCION FROM inserted
	SELECT @CANTIDAD = CANTIDAD FROM inserted
	SELECT @PRECIO_UNIDAD = PRECIO_UNIDAD FROM inserted
	IF(EXISTS(SELECT ID_PRODUCTO FROM INVENTARIOS WHERE ID_PRODUCTO = @ID_PRODUCTO))
		UPDATE INVENTARIOS SET EXISTENCIA += @CANTIDAD
	ELSE
		INSERT INTO INVENTARIOS (ID_PRODUCTO,DESCRIPCION,EXISTENCIA,PRECIO_UNIDAD)
			VALUES(@ID_PRODUCTO,@DESCRIPCION,@CANTIDAD,@PRECIO_UNIDAD)
GO





