-- 41:  Para cada actor, muestra la película más larga en la que ha participado.

SELECT a.actor_id, a.first_name, a.last_name,
MAX(f.length) AS max_length
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN film f USING(film_id)
GROUP BY a.actor_id, a.first_name, a.last_name;


-- 42:  Para cada cliente, muestra la cantidad máxima pagada en un solo pago.

SELECT c.customer_id, c.first_name, c.last_name,
MAX(p.amount) AS max_pago
FROM customer c
JOIN payment p USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 43:  Para cada tienda, muestra el alquiler más reciente registrado.

SELECT s.store_id,
MAX(r.rental_date) AS ultima_fecha
FROM store s
JOIN inventory i USING(store_id)
JOIN rental r USING(inventory_id)
GROUP BY s.store_id;


-- 44:  Para cada categoría, muestra el total de películas con duración superior a 120 minutos.

SELECT c.category_id, c.name AS category_name,
COUNT(f.film_id) AS films_largas
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
WHERE f.length > 120
GROUP BY c.category_id, c.name;


-- 45:  Para cada país, muestra el total de clientes residentes.

SELECT co.country_id, co.country,
COUNT(cu.customer_id) AS total_clientes
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN customer cu USING(address_id)
GROUP BY co.country_id, co.country;


-- 46:  Para cada película, muestra el total de ingresos generados (sumando pagos).

SELECT f.film_id, f.title,
SUM(p.amount) AS total_ingresos
FROM film f
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
JOIN payment p USING(rental_id)
GROUP BY f.film_id, f.title;


-- 47:  Para cada cliente, muestra cuántas categorías distintas de películas ha alquilado.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(DISTINCT fc.category_id) AS categorias_alquiladas
FROM customer c
JOIN rental r USING(customer_id)
JOIN inventory i USING(inventory_id)
JOIN film f USING(film_id)
JOIN film_category fc USING(film_id)
GROUP BY c.customer_id, c.first_name, c.last_name;


-- 48:  Para cada categoría, muestra el promedio de ingresos generados por sus películas.

-- cuatro tablas relacionales (inventory hace de anexo)
SELECT c.category_id, c.name AS category_name,
AVG(p.amount) AS avg_ingresos
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
JOIN payment p USING(rental_id)
GROUP BY c.category_id, c.name;


-- 49:  Para cada actor, muestra el número total de categorías distintas en las que ha trabajado.

SELECT a.actor_id, a.first_name, a.last_name,
COUNT(DISTINCT fc.category_id) AS categorias_participadas
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN film_category fc USING(film_id)
GROUP BY a.actor_id, a.first_name, a.last_name;


-- 50:  Para cada tienda, muestra la cantidad total de películas distintas disponibles.

SELECT s.store_id,
COUNT(DISTINCT i.film_id) AS total_peliculas
FROM store s
JOIN inventory i USING(store_id)
GROUP BY s.store_id;