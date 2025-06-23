
-- Crear un usuario --------------------------------------------------
CREATE USER "user_name"@"ip_acceso" IDENTIFIED BY "user_password";


CREATE USER "nancy"@"%" IDENTIFIED BY "lacalledelassirenas";
CREATE USER "mike"@"%" IDENTIFIED BY "bella";

-- Crear permisos para los usuarios -----------------------------------

-- usuario de solo lectura
GRANT SELECT ON monkys_tower.* TO "mike"@"%";
-- Agregar como solo lectura en todas las tablas  a mike en spring_jpa_monkys_tower
GRANT SELECT ON spring_jpa_monkys_tower.* TO "mike"@"%";

-- usuario con todos los privilegios
GRANT ALL PRIVILEGES ON monkys_tower.* TO "nancy"@"%";
-- agregar todos los provilegios a nancy en spring_jpa_monkys_tower
GRANT ALL PRIVILEGES ON spring_jpa_monkys_tower.* to "nancy"@"%";

/*
 Recarga en memoria los privilegios de usuario que están 
 almacenados en las tablas del sistema (mysql.user, mysql.db, etc.).
 
 Cuando creas, modificas o eliminas usuarios manualmente (por ejemplo, 
 con INSERT, UPDATE, o DELETE sobre las tablas internas), MySQL no 
 aplica los cambios de inmediato. Necesita que se recarguen.
*/ 
FLUSH PRIVILEGES;