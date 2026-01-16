USE sakila;

-- 11:  Muestra los clientes cuyo importe total pagado es al menos 200.

SELECT c.customer_id, c.first_name, c.last_name,
SUM(p.amount) AS total_pagado
FROM customer c
JOIN payment p USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING SUM(p.amount) >= 200;


-- 12:  Para cada empleado (staff), muestra el número de pagos que ha procesado.

SELECT s.staff_id, s.first_name, s.last_name,
COUNT(p.payment_id) AS num_pagos
FROM staff s
JOIN payment p USING(staff_id)
GROUP BY s.staff_id, s.first_name, s.last_name;


-- 13:  Para cada empleado, muestra el importe total procesado.

SELECT s.staff_id, s.first_name, s.last_name,
SUM(p.amount) AS total_procesado
FROM staff s
JOIN payment p USING(staff_id)
GROUP BY s.staff_id, s.first_name, s.last_name;


-- 14:  Para cada tienda, cuenta cuántos artículos de inventario tiene.

SELECT s.store_id, COUNT(i.inventory_id) AS total_inventario
FROM store s
JOIN inventory i USING(store_id)
GROUP BY s.store_id;


-- 15:  Para cada tienda, cuenta cuántos clientes tiene asignados.

SELECT s.store_id, COUNT(c.customer_id) AS total_clientes
FROM store s
JOIN customer c USING(store_id)
GROUP BY s.store_id;


-- 16:  Para cada tienda, cuenta cuántos empleados (staff) tiene asignados.

SELECT s.store_id, COUNT(st.staff_id) AS total_empleados
FROM store s
JOIN staff st USING(store_id)
GROUP BY s.store_id;


-- 17:  Para cada dirección (address), cuenta cuántas tiendas hay ubicadas ahí (0 o 1 normalmente).

SELECT a.address_id, a.address,
COUNT(s.store_id) AS total_tiendas
FROM address a
LEFT JOIN store s USING(address_id)
GROUP BY a.address_id, a.address;


-- 18:  Para cada dirección, cuenta cuántos empleados residen en esa dirección.

SELECT a.address_id, a.address,
COUNT(s.staff_id) AS total_empleados
FROM address a
LEFT JOIN staff s USING(address_id)
GROUP BY a.address_id, a.address;


-- 19:  Para cada dirección, cuenta cuántos clientes residen ahí.

SELECT a.address_id, a.address,
COUNT(c.customer_id) AS total_clientes
FROM address a
LEFT JOIN customer c USING(address_id)
GROUP BY a.address_id, a.address;


-- 20:  Para cada ciudad, cuenta cuántas direcciones hay registradas.

SELECT c.city_id, c.city,
COUNT(a.address_id) AS total_direcciones
FROM city c
JOIN address a USING(city_id)
GROUP BY c.city_id, c.city;
