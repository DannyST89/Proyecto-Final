
/*En este script unicamente agregamos datos de prueba,
  ya que necesitaba verificar el funcionamiento correcto
  de cada funcionalidad del programa.*/
 USE SUPERMERCADODB
 GO
  /*Agregamos datos a la tabla EMPLEADOS*/
 INSERT INTO EMPLEADOS(NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,CORREO,DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA)

		VALUES('Carlos','Arguedas','Mora','84751210','ArgM@gmail.com','Atenas','Cajero',GETDATE(),'CMora','Carlos1299'),
			  ('Josue','Molina','Rivera','87751278','jmolina@gmail.com','San Rafael','Cajero',GETDATE(),'JMolina','Josue0222')

GO

INSERT INTO PROVEEDORES(NOMBRE_PROVEEDOR,DIRECCION,TELEFONO,EXTENSION,CORREO,NUMERO_CUENTA)
						VALUES('Coca Cola','Alajuela','24561212','101','ventaCR@CocaCola.com','IBAN124570154721'),
							  ('Dos Pinos','Alajuela','24601589','115','mercadeoDospinos@DosPinos.com','00215024574034'),
							  ('Cafe 1820','Cartago','23568961','103','ventas@cafe1820.com','IBAN124056534')
							 
GO

INSERT INTO PRODUCTOS(ID_PRODUCTO,ID_PROVEEDOR,DESCRIPCION,PRECIO_UNIDAD)
		VALUES(7896359014811,1,'Fanta Fresa 300 ml',450.00),
			  (0215487021548,2,'Leche Semidescremada 1L',1050.00),
			  (4125031006598,3,'Cafe 1820 Molido Puro Tueste Oscuro 500G',3520.00)



INSERT INTO INVENTARIOS(ID_PRODUCTO,DESCRIPCION,CANTIDA_INGRESADA,EXISTENCIA,CANTIDAD_VENDIDA,PRECIO_UNIDAD)
				VALUES(7896359014811,'Fanta Fresa 300 ml',10,10,0,450.00)

INSERT INTO FACTURAS(ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,CANTIDAD,PRECIO_UNIDAD,SUBTOTAL,IVA,DESCUENTO,TOTAL)
				VALUES(1,7896359014811,'Fanta Fresa 300 ml',5,450.00,450.00,58.5,0,508.5 * 5) /*multiplicamos el último dato unicamente para verificación*/



SELECT * FROM VENTAS
SELECT * FROM FACTURAS
SELECT * FROM INVENTARIOS
