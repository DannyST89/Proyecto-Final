
/*En este script unicamente agregamos datos de prueba,
  ya que necesitaba verificar el funcionamiento correcto
  de cada funcionalidad del programa.*/
  USE SUPERMERCADODB
  GO
  /*Agregamos datos a la tabla EMPLEADOS*/
  INSERT INTO EMPLEADOS(NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,CORREO,
						DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA)
						VALUES('Carlos','Arguedas','Mora','84751210','ArgM@gmail.com','Atenas','Cajero',GETDATE(),'CMora','Carlos1299')