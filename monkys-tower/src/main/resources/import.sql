-- Rol 1: Administrador con acceso total
INSERT INTO `roles` (`name`, `description`) VALUES ('Admin', 'Acceso total al sistema y a la configuración.');

-- Rol 2: Cliente estándar que realiza compras
INSERT INTO `roles` (`name`, `description`) VALUES ('Customer', 'Usuario que puede realizar compras y ver el historial de sus pedidos.');

-- Rol 3: Encargado de la logística del almacén
INSERT INTO `roles` (`name`, `description`) VALUES ('Warehouse Manager', 'Gestiona el inventario de productos, empaqueta y realiza los envíos.');

-- Rol 4: Agente de soporte para atender a clientes
INSERT INTO `roles` (`name`, `description`) VALUES ('Support Agent', 'Agente que atiende consultas de clientes y gestiona devoluciones.');

-- Rol 5: Encargado de la estrategia de precios y campañas
INSERT INTO `roles` (`name`, `description`) VALUES ('Marketing Manager', 'Crea y administra descuentos, promociones y campañas de marketing.');