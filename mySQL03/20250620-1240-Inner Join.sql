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
SELECT 
	users.id AS id_users,
	users.email,
	addresses.id AS id_addresses,
	addresses.address,
	addresses.postal_code
  FROM users
  INNER JOIN addresses
  ON addresses.user_id = users.id;

SELECT 
	u.id AS id_users,
	u.email,
	a.id AS id_addresses,
	a.address,
	a.postal_code
  FROM users AS u
  INNER JOIN addresses a
  ON a.user_id = u.id;
  
  /*
   Mostrar los usuarios con el nombre del rol asignado
   users: id, email
   roles: id, name
  */
  SELECT
	u.id AS user_id,
    u.email,
    uhr.role_id AS role_id,
    r.name AS role_name
    FROM users u
    INNER JOIN users_has_roles uhr
    ON u.id = uhr.user_id
    INNER JOIN roles r
    ON uhr.role_id = r.id;

/*
 Mostrar los usuarios con tus ordener y el id de los items de
 cada orden
   users: id, email
   orders: id, total_amout
   order_items: product_id, quantity, price_at_purchase
   products: name, sku
*/
SELECT 
	u.id AS user_id,
	u.email,
	o.id AS order_id,
	o.total_amount,
	oi.product_id,
	oi.quantity,
	oi.price_at_purchase,
    p.name AS product_name,
    p.sku
	FROM users u
	INNER JOIN orders o
	ON u.id = o.user_id
	INNER JOIN order_items oi
	ON o.id = oi.order_id
    INNER JOIN products p
    ON oi.product_id = p.id;

-- De lo anterior, solo mostrar los usuarios con id = 2
SELECT 
	u.id AS user_id,
	u.email,
	o.id AS order_id,
	o.total_amount,
	oi.product_id,
	oi.quantity,
	oi.price_at_purchase,
    p.name AS product_name,
    p.sku
	FROM users u
	INNER JOIN orders o
	ON u.id = o.user_id
	INNER JOIN order_items oi
	ON o.id = oi.order_id
    INNER JOIN products p
    ON oi.product_id = p.id
    WHERE u.id = 3;
    
    
