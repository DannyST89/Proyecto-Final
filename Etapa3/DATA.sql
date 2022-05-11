
/*En este script unicamente agregamos datos de prueba,
  ya que necesitaba verificar el funcionamiento correcto
  de cada funcionalidad del programa.*/
 USE SUPERMERCADODB
 GO
  /*Agregamos datos a la tabla EMPLEADOS*/
 INSERT INTO EMPLEADOS(NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,CORREO,DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA)

		VALUES('Carlos','Arguedas','Mora','84751210','ArgM@gmail.com','San José','Cajero',GETDATE(),'CMora','Carlos1299'),
			  ('Josue','Molina','Rivera','87751278','jmolina@gmail.com','Heredia','Cajero',GETDATE(),'JMolina','Josue0222'),
			  ('Alberto','Martínez','Lizano','87785578','Albertoa@outlook.com','Alajuela','Bodeguero',GETDATE(),'AMartinez','Martinez0404')

GO
INSERT INTO PROVEEDORES(NOMBRE_PROVEEDOR,DIRECCION,TELEFONO,EXTENSION,CORREO,NUMERO_CUENTA)
						VALUES('Coca Cola','Alajuela','24561212','101','ventaCR@CocaCola.com','IBAN124570154721'),
							  ('Dos Pinos','Alajuela','24601589','115','mercadeoDospinos@DosPinos.com','00215024574034'),
							  ('Cafe 1820','Cartago','23568961','103','ventas@cafe1820.com','IBAN124056534')
							 
GO
INSERT INTO PRODUCTOS(ID_PROVEEDOR,NOMBRE_PROVEEDOR,DESCRIPCION,PRECIO_UNIDAD)
		VALUES(1,'Coca Cola','Fanta Fresa 350 ml',450.00),
			  (2,'Dos Pinos','Leche Semidescremada 1L',1050.00),
			  (3,'Cafe 1820', 'Molido Tueste Oscuro 500G',3520.00)
GO
INSERT INTO INVENTARIOS(ID_PRODUCTO,DESCRIPCION,CANTIDA_INGRESADA,EXISTENCIA,CANTIDAD_VENDIDA)
				VALUES(1,'Fanta Fresa 300 ml',10,10,0),
				      (2,'Leche Semidescremada 1L',10,10,0),
					  (3,'Molido Tueste Oscuro 500G',10,10,0)
GO


			

