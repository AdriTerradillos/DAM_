USE sakila;


-- 1:  Para cada actor, muestra el número total de películas en las que aparece; es decir,
-- cuenta cuántas filas de film_actor corresponden a cada actor.

-- OBJETIVO: Mostrar cada actor junto con la cantidad total de películas en las que aparece

SELECT a.actor_id, a.first_name, a.last_name, 
	COUNT(fa.film_id) AS total_films
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
GROUP BY a.actor_id, a.first_name, a.last_name;


-- 2:  Lista solo los actores que participan en 20 o más películas (umbral alto) con su conteo.

-- OBJETIVO: Mostrar cada uno de los actores que haya participado en 20 o más películas
SELECT a.actor_id, a.first_name, a.last_name, 
		COUNT(fa.film_id) AS films_20plus
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY a.actor_id, a.first_name, a.last_name
HAVING COUNT(f.film_id) >= 20;


-- 3:  Para cada idioma, indica cuántas películas están catalogadas en ese idioma.

-- OBJETIVO: Mostrar el idioma por grupos de cada una de las películas existentes

SELECT l.language_id, l.name AS language_name, 
	COUNT(f.film_id) AS films_in_language
FROM language l
JOIN film f ON l.language_id = f.language_id
GROUP BY l.language_id, l.name;


-- 4:  Muestra el promedio de duración (length) de las películas por idioma y filtra aquellos idiomas con duración media estrictamente mayor a 110 minutos.

-- OBJETIVO: Mostrar aquellas películas según su idioma con una duración mayor a 110 minutos
SELECT l.language_id, l.name AS language_name,
AVG(f.length) AS avg_length
FROM film f
JOIN language l ON f.language_id = l.language_id
GROUP BY l.language_id
HAVING AVG(f.length) > 110;


-- 5:  Para cada película, muestra cuántas copias hay en el inventario.

SELECT f.film_id, f.title,
COUNT(inventory_id) AS copies
FROM film f
JOIN inventory i USING(film_id) -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (inventory) y PK (film)
GROUP BY f.film_id;


-- 6:  Lista solo las películas que tienen al menos 5 copias en inventario.

SELECT f.film_id, f.title, 
COUNT(i.inventory_id) AS num_copias
FROM film f
JOIN inventory i USING(film_id) -- coinciden con mismo dato de registro "film_id" en ambas tablas FK (inventory) y PK (film)
GROUP BY f.film_id
HAVING COUNT(i.inventory_id) >= 5;


-- 7:  Para cada artículo de inventario, cuenta cuántos alquileres se han realizado.

SELECT i.inventory_id, 
COUNT(r.rental_id) AS rentals
FROM inventory i
JOIN rental r USING(inventory_id) -- coinciden con mismo dato de registro "inventory_id" en ambas tablas FK (rental) y PK (inventory)
GROUP BY i.inventory_id;
 
 
-- 8:  Para cada cliente, muestra cuántos alquileres ha realizado en total.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(r.rental_id) AS total_rentals
FROM customer c
JOIN rental r USING(customer_id)  -- coinciden con mismo dato de registro "customer_id" en ambas tablas FK (rental) y PK (customer)
GROUP BY c.customer_id;


-- 9:  Lista los clientes con 30 o más alquileres acumulados.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(r.rental_id) AS rentals_30plus
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING COUNT(r.rental_id) >= 30;



-- 10:  Para cada cliente, muestra el total de pagos (suma en euros/dólares) que ha realizado.

SELECT c.customer_id, c.first_name, c.last_name,
SUM(p.amount) AS total_amount
FROM customer c
JOIN payment p USING(customer_id) -- coinciden con mismo dato de registro "customer_id" en ambas tablas FK (payment) y PK (customer)
GROUP BY c.customer_id;


