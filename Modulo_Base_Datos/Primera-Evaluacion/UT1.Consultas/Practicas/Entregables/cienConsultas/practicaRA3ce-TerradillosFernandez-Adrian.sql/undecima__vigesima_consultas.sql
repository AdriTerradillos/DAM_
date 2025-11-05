USE sakila;

-- 11:  Muestra los clientes cuyo importe total pagado es al menos 200.

SELECT c.customer_id, c.first_name, c.last_name,
SUM(p.amount) AS total_pagado
FROM customer c
JOIN payment p USING(customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING SUM(p.amount) >= 200;


-- 12:  Para cada empleado (staff), muestra el número de pagos que ha procesado.

SELECT s.staff_id, s.first_name, s.last_name,
COUNT(p.payment_id) AS num_pagos
FROM staff s
JOIN payment p USING(staff_id)
GROUP BY s.staff_id, s.first_name, s.last_name;


-- 13:  Para cada empleado, muestra el importe total procesado.

SELECT s.staff_id, s.first_name, s.last_name,
SUM(p.amount) AS total_procesado
FROM staff s
JOIN payment p USING(staff_id)
GROUP BY s.staff_id, s.first_name, s.last_name;


-- 14:  Para cada tienda, cuenta cuántos artículos de inventario tiene.

SELECT s.store_id, COUNT(i.inventory_id) AS total_inventario
FROM store s
JOIN inventory i USING(store_id)
GROUP BY s.store_id;


-- 15:  Para cada tienda, cuenta cuántos clientes tiene asignados.

SELECT s.store_id, COUNT(c.customer_id) AS total_clientes
FROM store s
JOIN customer c USING(store_id)
GROUP BY s.store_id;


-- 16:  Para cada tienda, cuenta cuántos empleados (staff) tiene asignados.

SELECT s.store_id, COUNT(st.staff_id) AS total_empleados
FROM store s
JOIN staff st USING(store_id)
GROUP BY s.store_id;


-- 17:  Para cada dirección (address), cuenta cuántas tiendas hay ubicadas ahí (0 o 1 normalmente).

SELECT a.address_id, a.address,
COUNT(s.store_id) AS total_tiendas
FROM address a
LEFT JOIN store s USING(address_id)
GROUP BY a.address_id, a.address;


-- 18:  Para cada dirección, cuenta cuántos empleados residen en esa dirección.

SELECT a.address_id, a.address,
COUNT(s.staff_id) AS total_empleados
FROM address a
LEFT JOIN staff s USING(address_id)
GROUP BY a.address_id, a.address;


-- 19:  Para cada dirección, cuenta cuántos clientes residen ahí.

SELECT a.address_id, a.address,
COUNT(c.customer_id) AS total_clientes
FROM address a
LEFT JOIN customer c USING(address_id)
GROUP BY a.address_id, a.address;


-- 20:  Para cada ciudad, cuenta cuántas direcciones hay registradas.

SELECT c.city_id, c.city,
COUNT(a.address_id) AS total_direcciones
FROM city c
JOIN address a USING(city_id)
GROUP BY c.city_id, c.city;


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


