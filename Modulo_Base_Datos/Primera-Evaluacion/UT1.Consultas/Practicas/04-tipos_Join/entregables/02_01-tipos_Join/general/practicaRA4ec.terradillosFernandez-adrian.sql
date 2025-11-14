USE tienda_online;

# EJERCICIO 18: Productos NUNCA vendidos

-- 1. ¿Qué productos existen?
-- 2. ¿Qué productos han sido vendidos?
-- 3. Encontrar los productos que no se encuentran en la lista anterior

-- Consulta con LEFT JOIN + IS NULL

SELECT DISTINCT p.nombre AS producto
FROM productos p
LEFT JOIN detalle_pedido d ON p.id_producto = d.id_producto
WHERE d.id_producto IS NULL
ORDER BY producto ASC;