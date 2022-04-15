/*	DANNY SOTO J.
	14/04/2022
*/

/*En este script crearémos todos los procedimientos almacenados, triggers necesarios para
  solucionar el problema */
  USE SUPERMERCADODB
  GO
  /*Creámos un trigger que al ingresar un nuevo EMPLEADO se agregue el estado de activo*/
  CREATE TRIGGER TR_CAMBIAR_ESTADO_EMPLEADO
  ON EMPLEADOS
  FOR INSERT
  AS
	DECLARE	@ESTADO VARCHAR(3)
	SELECT	@ESTADO = ESTADO FROM inserted
	INSERT INTO EMPLEADOS(ESTADO)
			VALUES('ACT')
	