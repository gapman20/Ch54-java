/*
 MySQL y en la mayoría de los sistemas de gestión 
 de bases de datos relacionales, existen varios 
 tipos de joins que se utilizan para combinar 
 datos de múltiples tablas.

- INNER JOIN: Este tipo de join devuelve solo las filas 
	que tienen una coincidencia en ambas tablas basadas 
    en una condición de unión especificada. 
- LEFT JOIN: Este join devuelve todas las filas de la tabla 
	izquierda (tabla1) y las filas coincidentes de la tabla 
	derecha (tabla2). Si no hay ninguna coincidencia en la 
    tabla derecha, se devolverán NULL para las columnas de 
    la tabla derecha.
- RIGHT JOIN:Es similar al LEFT JOIN, pero devuelve todas 
	las filas de la tabla derecha y las filas coincidentes 
    de la tabla izquierda. Si no hay ninguna coincidencia 
    en la tabla izquierda, se devolverán NULL para las 
    columnas de la tabla izquierda.
*/

-- Mostrar los productos de el nombre de la categoria
SELECT 
     products.id, 
     products.name AS product_name, 
     products.price, 
     products.category_id,
     categories.name AS category_name
 FROM products -- tabla de la izquierda
 INNER JOIN categories -- tabla de la derecha
 ON products.category_id = categories.id;
 
/*
 Mostrar los usuarios y las direcciones que tiene asignadas
  users: id, email
  addresses: id, address, postal_code
*/



