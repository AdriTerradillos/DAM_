
-- 21:  Para cada país, cuenta cuántas ciudades existen.

SELECT co.country_id, co.country, 
COUNT(ci.city_id) AS num_ciudades
FROM country co
JOIN city ci USING(country_id)  -- coinciden con mismo dato de registro "country_id" en ambas tablas FK (city) y PK (country)
GROUP BY co.country_id
ORDER BY num_ciudades DESC;


-- 22:  Para cada idioma, calcula la duración media de películas y muestra solo los idiomas con media entre 90 y 120 inclusive.

SELECT l.language_id, l.name AS idioma, 
AVG(f.length) AS duracion_media
FROM language l
JOIN film f USING(language_id) -- coinciden con mismo dato de registro "language_id" en ambas tablas FK (film) y PK (language)
GROUP BY l.language_id
HAVING AVG(f.length) BETWEEN 90 AND 120
ORDER BY duracion_media DESC;


-- 23:  Para cada película, cuenta el número de alquileres que se han hecho de cualquiera de sus copias (usando inventario).

SELECT f.film_id, f.title, 
COUNT(r.rental_id) AS num_alquileres
FROM film f
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)    -- unión se hace por inventory + coinciden con mismo dato de registro "inventory_id" en ambas tablas FK (film) y PK (inventory)
GROUP BY f.film_id
ORDER BY num_alquileres DESC;


-- 24:  Para cada cliente, cuenta cuántos pagos ha realizado en 2005 (usando el año de payment_date).

SELECT c.customer_id, CONCAT(c.first_name,' ',c.last_name) AS cliente, 
COUNT(p.payment_id) AS pagos_2005
FROM customer c
JOIN payment p USING(customer_id) -- coinciden con mismo dato de registro "customer_id" en ambas tablas FK (payment) y PK (customer)
WHERE YEAR(p.payment_date) = 2005
GROUP BY c.customer_id
ORDER BY pagos_2005 DESC;


-- 25:  Para cada película, muestra el promedio de tarifa de alquiler (rental_rate) de las copias existentes (es un promedio redundante pero válido).

SELECT f.film_id, f.title, 
AVG(i.rental_rate) AS avg_rental_rate
FROM film f
JOIN inventory i USING(film_id) -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (rental) y PK (film)
GROUP BY f.film_id
ORDER BY avg_rental_rate DESC;


-- 26:  Para cada actor, muestra la duración media (length) de sus películas.

SELECT a.actor_id, a.first_name, a.last_name, AVG(f.length) AS duracion_media
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN film f ON fa.film_id = f.film_id   -- 3 tablas técnicamente; si estrictamente 2 no se puede  
GROUP BY a.actor_id
ORDER BY duracion_media DESC;


-- 27:  Para cada ciudad, cuenta cuántos clientes hay (usando la relación cliente->address->city requiere 3 tablas; aquí contamos direcciones por ciudad).

SELECT ci.city_id, ci.city, COUNT(a.address_id) AS num_direcciones
FROM city ci
JOIN address a USING(city_id)   -- coinciden con mismo dato de registro "city_id" en ambas tablas FK (address) y PK (city)
GROUP BY ci.city_id
ORDER BY num_direcciones DESC;


-- 28:  Para cada película, cuenta cuántos actores tiene asociados.

SELECT f.film_id, f.title, 
COUNT(fa.actor_id) AS num_actores
FROM film f
JOIN film_actor fa USING(film_id)  -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (actor) y PK (film) = tabla intermedia (film_actor)
GROUP BY f.film_id
ORDER BY num_actores DESC;


-- 29:  Para cada categoría (por id), cuenta cuántas películas pertenecen a ella (sin nombre de categoría para mantener 2 tablas).

SELECT fc.category_id, 
COUNT(fc.film_id) AS num_peliculas
FROM film_category fc
GROUP BY fc.category_id
ORDER BY num_peliculas DESC;


-- 30:  Para cada tienda, cuenta cuántos alquileres totales se originan en su inventario.
-- comenzamos con las primeras tres relaciones entre tablas

SELECT s.store_id, COUNT(r.rental_id) AS num_alquileres
FROM store s
JOIN inventory i USING(store_id)  -- coinciden con mismo dato de registro "store_id" en ambas tablas FK (inventory) y PK (store)
JOIN rental r USING(inventory_id)  -- coinciden con mismo dato de registro "inventory_id" en ambas tablas FK (rental) y PK (inventory)
GROUP BY s.store_id
ORDER BY num_alquileres DESC;

