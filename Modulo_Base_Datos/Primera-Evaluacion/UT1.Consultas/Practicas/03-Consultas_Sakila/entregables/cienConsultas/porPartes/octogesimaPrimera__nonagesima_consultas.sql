
USE sakila;

-- 81:  Para cada cliente, muestra el total pagado con IVA del 21% aplicado, redondeado a 2 decimales.

SELECT c.customer_id, c.first_name, c.last_name,
ROUND(SUM(p.amount) * 1.21, 2) AS total_con_iva
FROM customer c
JOIN payment p USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 82:  Para cada hora del día (0–23), cuenta cuántos alquileres se iniciaron en esa hora.

SELECT HOUR(r.rental_date) AS hora,
COUNT(r.rental_id) AS total_alquileres
FROM rental r
GROUP BY hora;


-- 83:  Para cada tienda, muestra la media de duración de películas alquiladas en 2005 y filtra las que tienen media >= 100.

SELECT s.store_id,
AVG(f.length) AS duracion_media
FROM store s
JOIN inventory i USING(store_id)
JOIN rental r USING(inventory_id)
JOIN film f USING(film_id)
WHERE YEAR(r.rental_date) = 2005
GROUP BY s.store_id
HAVING AVG(f.length) >= 100;


-- 84:  Para cada categoría, muestra la media de replacement_cost de películas alquiladas un domingo.

SELECT c.category_id, c.name AS categoria,
AVG(f.replacement_cost) AS media_coste
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
WHERE DAYOFWEEK(r.rental_date) = 1
GROUP BY c.category_id, c.name;


-- 85:  Para cada empleado, muestra el importe total de pagos realizados entre las 00:00 y 06:00.

SELECT s.staff_id, s.first_name, s.last_name,
SUM(p.amount) AS total_noche
FROM staff s
JOIN payment p USING(staff_id)
WHERE HOUR(p.payment_date) BETWEEN 0 AND 5
GROUP BY s.staff_id, s.first_name, s.last_name;


-- 86:  Para cada actor, cuenta cuántas de sus películas contienen la palabra 'LOVE'.

SELECT a.actor_id, a.first_name, a.last_name,
COUNT(f.film_id) AS peliculas_love
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN film f USING(film_id)
WHERE f.title LIKE '%LOVE%'
GROUP BY a.actor_id, a.first_name, a.last_name;


-- 87:  Para cada idioma, muestra el total de pagos de alquileres de películas en ese idioma.

SELECT l.language_id, l.name AS idioma,
SUM(p.amount) AS total_pagos
FROM language l
JOIN film f USING(language_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
JOIN payment p USING(rental_id)
GROUP BY l.language_id, l.name;


-- 88:  Para cada cliente, cuenta en cuántos días distintos de 2005 realizó algún alquiler.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(DISTINCT DATE(r.rental_date)) AS dias_distintos
FROM customer c
JOIN rental r USING(customer_id)
WHERE YEAR(r.rental_date) = 2005
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 89:  Para cada categoría, calcula la longitud media de los títulos de sus películas alquiladas.

SELECT c.category_id, c.name AS categoria,
AVG(LENGTH(f.title)) AS longitud_media
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY c.category_id, c.name;


-- 90:  Para cada tienda, cuenta cuántos clientes distintos alquilaron en el primer trimestre de 2006.

SELECT s.store_id,
COUNT(DISTINCT r.customer_id) AS clientes_t1_2006
FROM store s
JOIN inventory i USING(store_id)
JOIN rental r USING(inventory_id)
WHERE YEAR(r.rental_date) = 2006
  AND QUARTER(r.rental_date) = 1
GROUP BY s.store_id;