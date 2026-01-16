USE sakila;

-- 91:  Para cada país, cuenta cuántas categorías diferentes han sido alquiladas por clientes residentes en ese país.

SELECT co.country_id, co.country,
COUNT(DISTINCT c.category_id) AS rental_category
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN customer cu USING(address_id)
JOIN rental r USING(customer_id)
JOIN inventory i USING(inventory_id)
JOIN film_category c USING(film_id)
GROUP BY co.country_id, co.country;


-- 92:  Para cada cliente, muestra el importe medio de sus pagos redondeado a 2 decimales, solo si ha hecho al menos 10 pagos.

SELECT c.customer_id, c.first_name, c.last_name,
ROUND(AVG(p.amount), 2) AS import_medium
FROM customer c
JOIN payment p USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING COUNT(p.payment_id) >= 10;


-- 93:  Para cada categoría, muestra el número de películas con replacement_cost > 20 que hayan sido alquiladas al menos una vez.

SELECT c.category_id, c.name AS categoria,
COUNT(DISTINCT f.film_id) AS expensive_films
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
WHERE f.replacement_cost > 20
GROUP BY c.category_id, c.name;


-- 94:  Para cada tienda, suma los importes pagados en fines de semana.

SELECT s.store_id,
SUM(p.amount) AS total_finde
FROM store s
JOIN staff st USING(store_id)
JOIN payment p USING(staff_id)
WHERE DAYOFWEEK(p.payment_date) IN (1, 7)
GROUP BY s.store_id;


-- 95:  Para cada actor, cuenta cuántas películas suyas fueron alquiladas por al menos 5 clientes distintos.

SELECT a.actor_id, a.first_name, a.last_name,
COUNT(DISTINCT f.film_id) AS films_5customer_Plus
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY a.actor_id, a.first_name, a.last_name, f.film_id
HAVING COUNT(DISTINCT r.customer_id) >= 5;


-- 96:  Para cada idioma, muestra el número de películas cuyo título empieza por la letra 'A' y que han sido alquiladas.

SELECT l.language_id, l.name AS idioma,
COUNT(DISTINCT f.film_id) AS films_letter_A
FROM language l
JOIN film f USING(language_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
WHERE f.title LIKE 'A%'
GROUP BY l.language_id, l.name;


-- 97:  Para cada país, suma el importe total de pagos realizados por clientes residentes y filtra países con total >= 1000.

SELECT co.country_id, co.country,
SUM(p.amount) AS total_paid
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN customer c USING(address_id)
JOIN payment p USING(customer_id)
GROUP BY co.country_id, co.country
HAVING SUM(p.amount) >= 1000;


-- 98:  Para cada cliente, cuenta los días entre su primer y último alquiler en 2005, mostrando solo los que tengan >= 5 alquileres.

SELECT c.customer_id, c.first_name, c.last_name,
DATEDIFF(MAX(r.rental_date), MIN(r.rental_date)) AS dias_entre,
COUNT(r.rental_id) AS total_alquileres
FROM customer c
JOIN rental r USING(customer_id)
WHERE YEAR(r.rental_date) = 2005
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING COUNT(r.rental_id) >= 5;


-- 99:  Para cada tienda, muestra la media de importes cobrados por transacción en el año 2006 (2 decimales).

SELECT s.store_id,
ROUND(AVG(p.amount), 2) AS import_medium
FROM store s
JOIN staff st USING(store_id)
JOIN payment p USING(staff_id)
WHERE YEAR(p.payment_date) = 2006
GROUP BY s.store_id;


-- 100:  Para cada categoría, calcula la media de duración de películas alquiladas en 2006 y ordénalas descendentemente por dicha media.

SELECT c.category_id, c.name AS categoria,
AVG(f.length) AS length_medium
FROM category c
JOIN film_category fc USING(category_id)
JOIN film f USING(film_id)
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
WHERE YEAR(r.rental_date) = 2006
GROUP BY c.category_id, c.name
ORDER BY length_medium DESC;
