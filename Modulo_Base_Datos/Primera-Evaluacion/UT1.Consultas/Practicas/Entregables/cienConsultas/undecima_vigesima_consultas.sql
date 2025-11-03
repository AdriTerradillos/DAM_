-- 11:  Muestra los clientes cuyo importe total pagado es al menos 200.

SELECT c.custmer_id, CONCAT(c.first_name, ' ', c.last_name) AS cliente,
SUM(p.amount) AS total_pagado
FROM staff s
JOIN payment p USING(customer_id) -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (staff) y PK (customer)
GROUP BY c.customer_id
HAVING SUM(p.amount) >= 200
ORDER BY total_pagado DESC;


-- 12:  Para cada empleado (staff), muestra el número de pagos que ha procesado.

SELECT s.staff_id, CONCAT(s.first_name, ' ', s.last_name) AS empleado,
COUNT(p.payment_id) AS num_pagos
FROM staff s
JOIN payment p USING(staff_id) -- coinciden con mismo dato de registro "staff_id" en ambas tablas FK (payment) y PK (staff)
GROUP BY s.staff_id
ORDER BY num_pagos DESC;


-- 13:  Para cada empleado, muestra el importe total procesado.

SELECT s.staff_id, CONCAT(s.first_name, ' ', s,last_name) AS empleado,
SUM(p.amount) AS total_procesado
FROM staff s
JOIN payment p USING(staff_id)  -- coinciden con mismo dato de registro "staff_id" en ambas tablas FK (payment) y PK (staff)
GROUP BY s.staff_id
ORDER BY total_procesado DESC;


-- 14:  Para cada tienda, cuenta cuántos artículos de inventario tiene.

SELECT s.store_id, COUNT(i.inventory_id) AS num_inventario
FROM store s
JOIN inventory i USING(store_id)  -- coinciden con mismo dato de registro "store_id" en ambas tablas FK (inventory) y PK (payment)
GROUP BY s.store_id
ORDER BY num_inventario DESC;


-- 15:  Para cada tienda, cuenta cuántos clientes tiene asignados.

SELECT s.store_id, COUNT(c.customer_id) AS num_clientes
FROM store s
JOIN customer c USING(store_id)  -- coinciden con mismo dato de registro "store_id" en ambas tablas FK (customer) y PK (store)
GROUP BY s.store_id
ORDER BY num_clientes DESC;


-- 16:  Para cada tienda, cuenta cuántos empleados (staff) tiene asignados.

SELECT s.store_id, COUNT(staff_id) AS num_empleados
FROM store s
JOIN staff USING(store_id)  -- coinciden con mismo dato de registro "store_id" en ambas tablas FK (staff) y PK (store)
GROUP BY s.store_id;


-- 17:  Para cada dirección (address), cuenta cuántas tiendas hay ubicadas ahí (debería ser 0/1 en datos estándar).

SELECT a.address_id, a.address, COUNT(s.store_id) AS num_tiendas
FROM address a
LEFT JOIN store s USING(address_id)  -- coinciden con mismo dato de registro "address_id" en ambas tablas FK (store) y PK (address)
GROUP BY a.address_id;


-- 18:  Para cada dirección, cuenta cuántos empleados residen en esa dirección.

SELECT a.address_id, a.address, COUNT(st.staff_id) AS num_empleados
FROM address a
LEFT JOIN staff st USING(address_id)  -- coinciden con mismo dato de registro "address_id" en ambas tablas FK (staff) y PK (address)
GROUP BY a.address_id;


-- 19:  Para cada dirección, cuenta cuántos clientes residen ahí.

SELECT a.address_id, a.address, COUNT(c.customer_id) AS num_clientes
FROM address a
LEFT JOIN customer c USING(address_id) -- coinciden con mismo dato de registro "address_id" en ambas tablas FK (customer) y PK (address)
GROUP BY a.address_id;


-- 20:  Para cada ciudad, cuenta cuántas direcciones hay registradas.

SELECT ci.city_id, ci.city, COUNT(a.address_id) AS num_direcciones
FROM city ci
JOIN address a USING(city_id)  -- coinciden con mismo dato de registro "city_id" en ambas tablas FK (address) y PK (city)
GROUP BY ci.city_id
ORDER BY num_direcciones DESC;

