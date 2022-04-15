/*	DANNY SOTO J.
	14/04/2022
*/

/*En este script crearémos todos los procedimientos almacenados, triggers necesarios para
  solucionar el problema */
USE SUPERMERCADODB
GO

/*Desarrollamos un trigger que se dispare al vender un producto en facturas,
  actualizando el campo de CANTIDAD_VENDIDA  en la tabla de inventario y restando 
  la CANTIDAD_VENDIDA  con EXISTENCIA.*/
CREATE OR ALTER TRIGGER TR_FI_FACTURAS
ON FACTURAS
FOR INSERT
AS
	DECLARE @ID_PRODUCTO VARCHAR(50), @CANTIDAD INT
	SELECT @ID_PRODUCTO = ID_PRODUCTO FROM inserted
	SELECT @CANTIDAD = CANTIDAD FROM inserted

	IF(EXISTS(SELECT ID_PRODUCTO FROM INVENTARIOS WHERE ID_PRODUCTO = @ID_PRODUCTO))
		UPDATE INVENTARIOS SET CANTIDAD_VENDIDA = @CANTIDAD, EXISTENCIA -= @CANTIDAD
		
GO





