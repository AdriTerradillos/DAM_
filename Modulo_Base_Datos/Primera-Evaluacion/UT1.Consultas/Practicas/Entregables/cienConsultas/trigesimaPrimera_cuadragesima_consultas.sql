-- ==============================================
-- SECCIÓN B) 30 CONSULTAS CON JOIN DE 3 TABLAS
-- ==============================================


-- 31:  Para cada actor, cuenta cuántas películas tiene y muestra solo los que superan 15 películas.

SELECT a.actor_id, a.first_name, a.last_name, COUNT(fa.film_id) AS num_peliculas
FROM actor a
JOIN film_actor fa USING(actor_id) -- coinciden con mismo dato de registro "actor_id" en ambas tablas FK (film) y PK (actor) = tabla intermedia (film_actor))
GROUP BY a.actor_id
HAVING COUNT(fa.film_id) > 15
ORDER BY num_peliculas DESC;


-- 32:  Para cada categoría (por nombre), cuenta cuántas películas hay en esa categoría.

SELECT c.name AS categoria, COUNT(fc.film_id) AS num_peliculas
FROM category c
JOIN film_category fc USING(category_id)  -- coinciden con mismo dato de registro "category_id" en ambas tablas FK (film) y PK (category) = tabla intermedia (film_category))
JOIN film f USING(film_id)  -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (category) y PK (film) = tabla intermedia (film_category))
GROUP BY c.category_id
ORDER BY num_peliculas DESC;


-- 33:  Para cada película, cuenta cuántos alquileres se han hecho de sus copias.

SELECT f.film_id, f.title, COUNT(r.rental_id) AS num_alquileres
FROM film f
JOIN inventory i USING(film_id)  -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (inventory) y PK (film)
JOIN rental r USING(inventory_id) -- coinciden con mismo dato de registro "inventory_id" en ambas tablas FK (film) y PK (inventory) 
GROUP BY f.film_id 
ORDER BY num_alquileres DESC;


-- 34:  Para cada cliente, suma el importe pagado en 2005 y filtra clientes con total >= 150.

SELECT c.customer_id, CONCAT(c.first_name,' ',c.last_name) AS cliente, SUM(p.amount) AS total_2005
FROM customer c
JOIN payment p USING(customer_id) -- coinciden con mismo dato de registro "customer_id" en ambas tablas FK (payment) y PK (customer)
WHERE YEAR(p.payment_date) = 2005 
GROUP BY c.customer_id
HAVING SUM(p.amount) >= 150
ORDER BY total_2005 DESC;


-- 35:  Para cada tienda, suma el importe cobrado por todos sus empleados.

SELECT s.store_id, SUM(p.amount) AS total_cobrado
FROM store s
JOIN staff st USING(store_id) -- coinciden con mismo dato de registro "store_id" en ambas tablas FK (staff) y PK (store)
JOIN payment p USING(staff_id) -- coinciden con mismo dato de registro "staff_id" en ambas tablas FK (store) y PK (staff)
GROUP BY s.store_id
ORDER BY total_cobrado DESC;


-- 36:  Para cada ciudad, cuenta cuántos empleados residen ahí (staff -> address -> city).

SELECT ci.city_id, ci.city, COUNT(st.staff_id) AS num_empleados
FROM city ci
JOIN address a USING(city_id) -- coinciden con mismo dato de registro "city_id" en ambas tablas FK (address) y PK (city)
JOIN staff st USING(address_id) -- coinciden con mismo dato de registro "address_id" en ambas tablas FK (city) y PK (address)
GROUP BY ci.city_id
ORDER BY num_empleados DESC;


-- 37:  Para cada ciudad, cuenta cuántas tiendas existen (store -> address -> city).

SELECT ci.city_id, ci.city, COUNT(s.store_id) AS num_tiendas
FROM city ci
JOIN address a USING(city_id)  -- coinciden con mismo dato de registro "city_id" en ambas tablas FK (address) y PK (city)
JOIN store s USING(address_id) -- coinciden con mismo dato de registro "address" en ambas tablas FK (city) y PK (address)
GROUP BY ci.city_id
ORDER BY num_tiendas DESC;


-- 38:  Para cada actor, calcula la duración media de sus películas del año 2006.

SELECT a.actor_id, a.first_name, a.last_name, 
AVG(f.length) AS duracion_media_2006
FROM actor a
JOIN film_actor fa USING(actor_id)  -- coinciden con mismo dato de registro "actor_id" en ambas tablas FK (film) y PK (actor) = tabla intermedia (film_actor)
JOIN film f ON fa.film_id = f.film_id 
WHERE YEAR(f.release_year) = 2006 OR f.release_year = 2006
GROUP BY a.actor_id
ORDER BY duracion_media_2006 DESC;


-- 39:  Para cada categoría, calcula la duración media y muestra solo las que superan 120.

SELECT c.category_id, c.name AS categoria, 
AVG(f.length) AS duracion_media
FROM category c
JOIN film_category fc USING(category_id) -- coinciden con mismo dato de registro "category_id" en ambas tablas FK (film) y PK (category) = tabla intermedia (film_category)
JOIN film f USING(film_id) -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (category) y PK (film) = tabla intermedia (film_category)
GROUP BY c.category_id
HAVING AVG(f.length) > 120
ORDER BY duracion_media DESC;


-- 40:  Para cada idioma, suma las tarifas de alquiler (rental_rate) de todas sus películas.

SELECT l.language_id, l.name AS idioma, 
SUM(f.rental_rate) AS suma_rental_rate
FROM language l
JOIN film f USING(language_id) -- coinciden con mismo dato de registro "language_id" en ambas tablas FK (film) y PK (laanguage)
GROUP BY l.language_id
ORDER BY suma_rental_rate DESC;

