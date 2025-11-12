-- ==============================================
-- SECCIÓN B) 30 CONSULTAS CON JOIN DE 3 TABLAS
-- ==============================================

USE sakila;

-- 31:  Para cada categoría, muestra la duración promedio de sus películas.

SELECT c.category_id, c.name AS category_name,
AVG(f.length) AS avg_length
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
GROUP BY c.category_id, c.name;


-- 32:  Para cada cliente, muestra el número total de películas distintas que ha alquilado.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(DISTINCT i.film_id) AS films_rented
FROM customer c
JOIN rental r USING(customer_id)
JOIN inventory i USING(inventory_id)
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 33:  Para cada empleado, muestra el número total de clientes que ha atendido (por pagos).

SELECT s.staff_id, s.first_name, s.last_name,
COUNT(DISTINCT p.customer_id) AS clientes_atendidos
FROM staff s
JOIN payment p USING(staff_id)
GROUP BY s.staff_id, s.first_name, s.last_name;


-- 34:  Para cada categoría, muestra el total de alquileres realizados de sus películas.

SELECT c.category_id, c.name AS category_name,
COUNT(r.rental_id) AS total_rentals
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY c.category_id, c.name;


-- 35:  Para cada tienda, muestra el importe total generado por los pagos realizados en ella.

SELECT s.store_id,
SUM(p.amount) AS total_ingresos
FROM store s
JOIN staff st USING(store_id)
JOIN payment p USING(staff_id)
GROUP BY s.store_id;


-- 36:  Para cada cliente, muestra el importe promedio pagado por alquiler.

SELECT c.customer_id, c.first_name, c.last_name,
AVG(p.amount) AS avg_pago
FROM customer c
JOIN payment p USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 37:  Muestra los clientes que tienen un pago medio superior a 5.

SELECT c.customer_id, c.first_name, c.last_name,
AVG(p.amount) AS avg_pago
FROM customer c
JOIN payment p USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING AVG(p.amount) > 5;


-- 38:  Para cada película, muestra la fecha más reciente en que fue alquilada.

SELECT f.film_id, f.title,
MAX(r.rental_date) AS ultima_fecha_alquiler
FROM film f
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY f.film_id, f.title;


-- 39:  Para cada cliente, muestra la fecha de su último alquiler.

SELECT c.customer_id, c.first_name, c.last_name,
MAX(r.rental_date) AS ultima_fecha
FROM customer c
JOIN rental r USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 40:  Para cada cliente, muestra la fecha de su primer alquiler.

SELECT c.customer_id, c.first_name, c.last_name,
MIN(r.rental_date) AS primera_fecha
FROM customer c
JOIN rental r USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name;
