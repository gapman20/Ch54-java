/*
 Mostrar 10 productos, comenzando con el registro n.11
 Mostrar solo los campos id, name, price
 Ordenar los resultados por el price, name
*/
SELECT id, name, price
	FROM products
    ORDER BY price, name
    LIMIT 10 OFFSET 10; -- comenzar con el registro 11
    
/*
 ¿Cuántos productos existen en el rango de 100 a 500 pesos?
*/
SELECT COUNT(*) AS "Productos entre $100 - $500"
FROM products
WHERE price BETWEEN 100 AND 500;

-- Encontrar todos los productos que dentro del nombre contenga la palabra "auto"
SELECT *
	FROM products
    WHERE name LIKE "%auto%";

/*
 Las funciones agregadas son funciones que realizan cálculos 
 sobre un conjunto de valores (varias filas) y devuelven 
 un único resultado.

 SUM(), AVG(), MIN(), MAX()
 
 Resumen datos de múltiples filas en un solo valor.
*/

SELECT MAX(price)
	FROM products;
    
-- Muestra los productos que tengan el mayor precio
SELECT * 
 FROM products
 ORDER BY price DESC -- No se recomienda realizar
 LIMIT 1; -- por que solo mostraría un producto, si hay más con el mismo precio se ignora
    
-- Consultas anidadas
SELECT *
 FROM products
 WHERE price = ( SELECT MAX(price)
	              FROM products
			    );

/*
 Mostrar los productos que tenga el mayor precio, que no superen los $1000
*/
SELECT *
   FROM products
   WHERE price = ( SELECT MAX(price)
                     FROM products
                     WHERE price BETWEEN 0 AND 1000
                     );

-- Mostrar los productos con el mayor precio de la categoría 5 (Toys and Games)
SELECT *
	FROM products
    WHERE category_id = 5 AND  price = (SELECT MAX(price) 
										FROM products 
										WHERE category_id = 5
									   );
                                       
SELECT * FROM products;

/*
 Mostrar los productos con los campos
  id, name, price , iva (price * .16) , total (price + iva)
  50,  Bicicleta, 2500, 400 , 2900
  
  Ordenar por el precio total de forma descendente
*/
SELECT id,  name,  price,
  (price * 0.16) AS iva,
  (price + (price * 0.16)) AS total
FROM products
ORDER BY total DESC;

/*
 GROUP BY
 Agrupa filas que tienen el mismo valor en una o varias columnas, 
 y normalmente se usa con funciones de agregación (COUNT, SUM, AVG, MAX, MIN).
*/

SELECT category_id
	FROM products;

-- Obtener el número de productos por categoría
SELECT category_id
 FROM products
 GROUP BY category_id;
 
SELECT category_id, COUNT(category_id)
 FROM products
 GROUP BY category_id;

-- Cuántos usuarios tenemos de cada role
SELECT role_id, COUNT(user_id) AS total_usuarios
FROM users_has_roles
GROUP BY role_id;

-- Cuántas ordenes existen por cliente?

