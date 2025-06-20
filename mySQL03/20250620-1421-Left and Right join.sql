-- Mostrar todos los usuarios y las direcciones asignadas
SELECT *
 FROM users u  
 RIGHT JOIN addresses a
 ON u.id = a.user_id;

SELECT *
 FROM addresses a 
 RIGHT JOIN users u
 ON u.id = a.user_id;