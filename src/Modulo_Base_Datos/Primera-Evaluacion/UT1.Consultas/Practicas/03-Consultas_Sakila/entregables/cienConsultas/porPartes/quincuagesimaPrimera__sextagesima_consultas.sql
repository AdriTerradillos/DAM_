-- 51:  Para cada cliente, muestra el número de veces que alquiló la misma película más de una vez.

SELECT c.customer_id, c.first_name, c.last_name,
COUNT(DISTINCT i.film_id) AS peliculas_repetidas
FROM customer c
JOIN rental r USING(customer_id)
JOIN inventory i USING(inventory_id)
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING COUNT(i.inventory_id) > COUNT(DISTINCT i.film_id);


-- 52:  Para cada película, muestra cuántas veces fue alquilada más de 3 veces.

SELECT f.film_id, f.title,
COUNT(r.rental_id) AS total_alquileres
FROM film f
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY f.film_id, f.title
HAVING COUNT(r.rental_id) > 3;


-- 53:  Para cada actor, muestra la película con mayor tarifa de alquiler.

SELECT a.actor_id, a.first_name, a.last_name,
MAX(f.rental_rate) AS max_tarifa
FROM actor a
JOIN film_actor fa USING(actor_id)
JOIN film f USING(film_id)
GROUP BY a.actor_id, a.first_name, a.last_name;


-- 54:  Para cada cliente, muestra el total de alquileres por año.

SELECT c.customer_id, c.first_name, c.last_name,
YEAR(r.rental_date) AS anio,
COUNT(r.rental_id) AS total_alquileres
FROM customer c
JOIN rental r USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name, anio;


-- 55:  Para cada empleado, muestra el número total de pagos procesados por mes.

SELECT s.staff_id, s.first_name, s.last_name,
MONTH(p.payment_date) AS mes,
COUNT(p.payment_id) AS pagos_mes
FROM staff s
JOIN payment p USING(staff_id)
GROUP BY s.staff_id, s.first_name, s.last_name, mes;


-- 56:  Para cada tienda, muestra la suma total de pagos por año.

SELECT s.store_id,
YEAR(p.payment_date) AS anio,
SUM(p.amount) AS total_anual
FROM store s
JOIN staff st USING(store_id)
JOIN payment p USING(staff_id)
GROUP BY s.store_id, anio;


-- 57:  Para cada país, muestra el número total de películas alquiladas por sus clientes.

SELECT co.country_id, co.country,
COUNT(r.rental_id) AS total_alquileres
FROM country co
JOIN city ci USING(country_id)
JOIN address a USING(city_id)
JOIN customer cu USING(address_id)
JOIN rental r USING(customer_id)
GROUP BY co.country_id, co.country;


-- 58:  Para cada película, muestra el número de clientes distintos que la han alquilado.

SELECT f.film_id, f.title,
COUNT(DISTINCT r.customer_id) AS clientes_distintos
FROM film f
JOIN inventory i USING(film_id)
JOIN rental r USING(inventory_id)
GROUP BY f.film_id, f.title;


-- 59:  Para cada categoría, muestra cuántos actores distintos han participado en sus películas.

SELECT c.category_id, c.name AS category_name,
COUNT(DISTINCT a.actor_id) AS actores_distintos
FROM category c
JOIN film_category fc USING(category_id)
JOIN film_actor fa USING(film_id)
JOIN actor a USING(actor_id)
GROUP BY c.category_id, c.name;


-- 60:  Para cada tienda, muestra el promedio de alquileres por cliente.

SELECT s.store_id,
AVG(rental_count) AS avg_alquileres_cliente
FROM (
    SELECT c.store_id, c.customer_id,
    COUNT(r.rental_id) AS rental_count
    FROM customer c
    JOIN rental r USING(customer_id)
    GROUP BY c.store_id, c.customer_id
) AS sub
JOIN store s ON s.store_id = sub.store_id
GROUP BY s.store_id;