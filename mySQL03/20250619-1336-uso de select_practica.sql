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
