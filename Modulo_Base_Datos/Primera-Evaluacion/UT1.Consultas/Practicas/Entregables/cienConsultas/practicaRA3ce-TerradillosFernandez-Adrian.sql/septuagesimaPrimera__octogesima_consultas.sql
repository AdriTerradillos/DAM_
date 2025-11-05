
USE sakila;

-- 71:  Para cada tienda, cuenta cuántas categorías distintas existen en su inventario.

SELECT s.store_id,
COUNT(DISTINCT fc.category_id) AS categorias_distintas
FROM store s
JOIN inventory i USING(store_id)
JOIN film_category fc USING(film_id)
GROUP BY s.store_id;

-- 72:  Para cada tienda, suma la recaudación por categoría.

SELECT s.store_id, c.name AS categoria,
SUM(p.amount) AS total_categoria
FROM store s
JOIN inventory i USING(store_id)
JOIN film_category fc USING(film_id)
JOIN category c USING(category_id)
JOIN rental r USING(inventory_id)
JOIN payment p USING(rental_id)
GROUP BY s.store_id;


-- 73:  Para cada actor, cuenta en cuántas tiendas distintas se han alquilado sus películas.

SELECT a.actor_id, a.first_name, a.last_name,
COUNT(DISTINCT i.store_id) AS tiendas_distintas
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY a.actor_id;


-- 74:  Para cada categoría, cuenta cuántos clientes distintos han alquilado películas de esa categoría.

SELECT c.category_id, c.name AS categoria,
COUNT(DISTINCT r.customer_id) AS clientes_distintos
FROM category c
JOIN film_category fc USING(category_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY c.category_id;


-- 75:  Para cada idioma, cuenta cuántos actores distintos participan en películas alquiladas en ese idioma.

SELECT l.language_id, l.name AS idioma,
COUNT(DISTINCT a.actor_id) AS actores_distintos
FROM language l
JOIN film f USING(language_id)
JOIN film_actor fa USING(film_id)
JOIN actor a USING(actor_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY l.language_id;


-- 76:  Para cada país, cuenta cuántas tiendas hay.

SELECT co.country_id, co.country,
COUNT(s.store_id) AS total_tiendas
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN store s USING(address_id)
GROUP BY co.country_id;


-- 77:  Para cada cliente, cuenta los alquileres en los que la devolución fue el mismo día.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(r.rental_id) AS devoluciones_mismo_dia
FROM customer c
JOIN rental r USING(customer_id)
WHERE DATE(r.rental_date) = DATE(r.return_date)
GROUP BY c.customer_id;


-- 78:  Para cada tienda, cuenta cuántos clientes distintos realizaron pagos en 2005.

SELECT s.store_id,
COUNT(DISTINCT p.customer_id) AS clientes_2005
FROM store s
JOIN staff st USING(store_id)
JOIN payment p USING(staff_id)
WHERE YEAR(p.payment_date) = 2005
GROUP BY s.store_id;


-- 79:  Para cada categoría, cuenta cuántas películas con título de longitud > 15 han sido alquiladas.

SELECT c.category_id, c.name AS categoria,
COUNT(DISTINCT f.film_id) AS peliculas_largas
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
WHERE LENGTH(f.title) > 15
GROUP BY c.category_id;


-- 80:  Para cada país, suma los pagos procesados por empleados de las tiendas ubicadas en ese país.

SELECT co.country_id, co.country,
SUM(p.amount) AS total_pais
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN store s USING(address_id)
JOIN staff st USING(store_id)
JOIN payment p USING(staff_id)
GROUP BY co.country_id;

