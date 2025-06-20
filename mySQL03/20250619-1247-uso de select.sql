USE ch54_monkys_tower;
/*
  La sentencia SELECT en MySQL se utiliza para consultar 
  y recuperar datos de una o más tablas de una base de datos. 
  Es una de las operaciones más fundamentales y utilizadas en SQL.

  SELECT [column_name(s) | *]
	FROM table_name
	[WHERE condition]
	[GROUP BY column_name(s)]
	[HAVING condition]
	[ORDER BY column_name(s) ASC|DESC]
	[LIMIT count];
*/


-- Usa el comodin * para seleccionar todas las columnas
SELECT * FROM users;

-- Especificar las columnas que se quieren obtener
SELECT id, email, phone_number FROM users;

-- Usar un alias para el nombre de las columnas
SELECT
	id AS identificador,
    email AS "correo electrónico",
    phone_number AS "número telefónico"
    FROM users;
    
-- ordenar de manera ascedente o descendente las columnas
SELECT id, email, first_name, last_name
	FROM users
    ORDER BY first_name ASC, last_name DESC;
    
-- limitar el número de resultados
SELECT *
	FROM users
    ORDER BY first_name
    LIMIT 10;
-- limitar el número de resultado y el inicio de los mismos
SELECT *
	FROM users
    ORDER BY id
    LIMIT 10 OFFSET 15; -- comenzar en el registro 16
    
-- mostrar los registros donde el nombre sea "Charles"
SELECT *
	FROM users
    WHERE first_name = "charles"
    ORDER BY last_name;

-- Mostrar los registros donde el nombre sea "Charles" o "Michael"
SELECT *
	FROM users
    WHERE first_name = "charles" OR first_name = "Michael"
    ORDER BY last_name;
    
SELECT *
	FROM users
    WHERE first_name IN ("charles", "michael")
    ORDER BY last_name;

-- Seleccionar un rango
-- Define el valor inicial del rango. 
-- El operador BETWEEN incluye este valor en la búsqueda.
SELECT * 
	FROM users
    WHERE created_at >= "2025-01-01" AND created_at <= "2025-03-31"; 
    
SELECT *
	FROM users
    WHERE created_at BETWEEN "2025-01-01" AND "2025-03-31"; -- 11,12,20
    
-- No mostrar los registros que estén dentro de un rango
SELECT *
	FROM users
    WHERE created_at NOT BETWEEN "2025-01-01" AND "2025-03-31";
    
-- Contabilizar el núm. de registros
/* COUNT(*): Cuenta el número total de filas en una 
      tabla o grupo, incluyendo filas con valores NULL y duplicados.
   COUNT(column_name): Cuenta el número de filas donde 
      column_name no es NULL. Ignora los valores nulos.
   COUNT(DISTINCT column_name): Cuenta el número de valores únicos
      y no nulos en una columna.
*/
SELECT COUNT(*) AS "Total de usuarios"
  FROM users;
  
/*
 DISTINC: eliminar filas duplicadas de un resultado de una 
 consulta SELECT. Devuelve únicamente los valores únicos.
*/
SELECT COUNT(DISTINCT first_name)
	FROM users;
    
/*
  Patrones de búsqueda
  Comodín _ : busqueda de cualquier caracter
  Comodín % : busqueda de cualquier número de caracteres
*/
-- muestra los usuarios que tengan el email @gmail.com
SELECT *
	FROM users
    WHERE email LIKE "%@gmail.com";
    
-- mostrar todos los usuarios que su correo comience con "a" y su dominio sea @gmail.com
SELECT *
	FROM users
    WHERE email LIKE "a%@gmail.com";


    
