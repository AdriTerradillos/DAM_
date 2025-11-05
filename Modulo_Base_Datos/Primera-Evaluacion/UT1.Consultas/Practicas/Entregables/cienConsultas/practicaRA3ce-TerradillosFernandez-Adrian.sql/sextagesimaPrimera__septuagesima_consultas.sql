
USE sakila;

-- ==============================================
-- SECCIÓN C) 20 CONSULTAS CON JOIN DE 4 TABLAS
-- ==============================================


-- 61:  Para cada ciudad, cuenta cuántos clientes hay y muestra solo ciudades con 10 o más clientes.

SELECT ci.city_id, ci.city,
COUNT(c.customer_id) AS total_clientes
FROM city ci
JOIN address a USING(city_id)
JOIN customer c USING(address_id)
GROUP BY ci.city_id, ci.city
HAVING COUNT(c.customer_id) >= 10;


-- 62:  Para cada actor, cuenta cuántos alquileres totales suman todas sus películas.

SELECT a.actor_id, a.first_name, a.last_name,
COUNT(r.rental_id) AS total_alquileres
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY a.actor_id, a.first_name, a.last_name;


-- 63:  Para cada categoría, suma los importes pagados derivados de películas de esa categoría.

SELECT c.category_id, c.name AS categoria,
SUM(p.amount) AS total_pagado
FROM category c
JOIN film_category fc USING(category_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
JOIN payment p USING(rental_id)
GROUP BY c.category_id, c.name;


-- 64:  Para cada ciudad, suma los importes pagados por clientes residentes en esa ciudad en 2005.

SELECT ci.city_id, ci.city,
SUM(p.amount) AS total_2005
FROM city ci
JOIN address a USING(city_id)
JOIN customer c USING(address_id)
JOIN payment p USING(customer_id)
WHERE YEAR(p.payment_date) = 2005
GROUP BY ci.city_id, ci.city;


-- 65:  Para cada tienda, cuenta cuántos actores distintos aparecen en las películas de su inventario.

SELECT s.store_id,
COUNT(DISTINCT fa.actor_id) AS actores_distintos
FROM store s
JOIN inventory i USING(store_id)
JOIN film_actor fa USING(film_id)
GROUP BY s.store_id;


-- 66:  Para cada idioma, cuenta cuántos alquileres totales se han hecho de películas en ese idioma.

SELECT l.language_id, l.name AS idioma,
COUNT(r.rental_id) AS total_alquileres
FROM language l
JOIN film f USING(language_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY l.language_id, l.name;


-- 67:  Para cada cliente, cuenta en cuántos meses distintos de 2005 realizó pagos.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(DISTINCT MONTH(p.payment_date)) AS meses_distintos
FROM customer c
JOIN payment p USING(customer_id)
WHERE YEAR(p.payment_date) = 2005
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 68:  Para cada categoría, calcula la duración media de las películas alquiladas.

SELECT c.category_id, c.name AS categoria,
AVG(f.length) AS duracion_media
FROM category c
JOIN film_category fc USING(category_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
JOIN film f USING(film_id)
GROUP BY c.category_id, c.name;


-- 69:  Para cada país, cuenta cuántos clientes hay.

SELECT co.country_id, co.country,
COUNT(c.customer_id) AS total_clientes
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN customer c USING(address_id)
GROUP BY co.country_id, co.country;


-- 70:  Para cada país, suma los importes pagados por sus clientes.

SELECT co.country_id, co.country,
SUM(p.amount) AS total_pagado
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN customer c USING(address_id)
JOIN payment p USING(customer_id)
GROUP BY co.country_id, co.country;


