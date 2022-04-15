
/*En este script unicamente agregamos datos de prueba,
  ya que necesitaba verificar el funcionamiento correcto
  de cada funcionalidad del programa.*/
 USE SUPERMERCADODB
 GO
  /*Agregamos datos a la tabla EMPLEADOS*/
 INSERT INTO EMPLEADOS(NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,CORREO,DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA)

		VALUES('Carlos','Arguedas','Mora','84751210','ArgM@gmail.com','Atenas','Cajero',GETDATE(),'CMora','Carlos1299')

GO

INSERT INTO PROVEEDORES(NOMBRE_PROVEEDOR,DIRECCION,TELEFONO,EXTENSION,CORREO,NUMERO_CUENTA)
						VALUES('Coca Cola','Alajuela','24561212','101','ventaCR@CocaCola.com','IBAN124570154721'),
							  ('Dos Pinos','Alajuela','24601589','115','mercadeoDospinos@DosPinos.com','00215024574034'),
							  ('Cafe 1820','Cartago','23568961','103','ventas@cafe1820.com','IBAN124056534')
							 
GO

INSERT INTO PRODUCTOS(ID_PRODUCTO,ID_EMPLEADO,ID_PROVEEDOR,DESCRIPCION,CANTIDAD,PRECIO_UNIDAD)
		VALUES(7896359014811,1,1,'Fanta Fresa 300 ml',3,450.00),
			  (0215487021548,1,2,'Leche Semidescremada 1L',1,1050.00),
			  (4125031006598,1,3,'Cafe 1820 Molido Puro Tueste Oscuro 500G',1,3520.00)





SELECT * FROM EMPLEADOS
SELECT * FROM PROVEEDORES
SELECT * FROM PRODUCTOS
SELECT * FROM INVENTARIOS

