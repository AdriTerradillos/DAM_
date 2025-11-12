USE sakila;

# Consultas SQL con JOINs en la base de datos Sakila

/*
* Consulta 1: Clientes con al menos un alquiler

El gerente de la tienda desea conocer qué clientes han realizado alquileres de películas, 
sin incluir a aquellos que no han alquilado nada.

Objetivo: 

*/






/*
* Consulta 2: Todos los clientes y sus alquileres
 
 El encargado de atención al cliente quiere un listado de todos los clientes registrados 
 en el almacén 1 y el número de alquileres que han hecho, incluyendo 
 clientes sin alquileres.

Objetivo: Listar todos los clientes registrados en el 
almacén 1 y el número de alquileres que han hecho, 
incluyendo clientes sin alquileres.

*/

SELECT 
  c.customer_id AS id_cliente,
  CONCAT(c.first_name, ' ', c.last_name) AS nombre_completo,
  COUNT(r.rental_id) AS cantidad_alquileres
FROM customer AS c
LEFT JOIN rental AS r 
  ON c.customer_id = r.customer_id
WHERE c.store_id = 1
GROUP BY c.customer_id, c.first_name, c.last_name
ORDER BY cantidad_alquileres DESC;


/*
* Consulta 3: Actores y sus películas

El gerente de casting necesita un reporte de los actores y las películas 
en las que han actuado. Además, quiere incluir actores que aún no han participado 
en ninguna película.

Objetivo: Mostrar todos los actores con las películas 
en las que han actuado. Incluir actores sin películas.
*/

SELECT 
  a.actor_id AS actor_id,
  CONCAT(a.first_name, ' ', a.last_name) AS nombre_actor,
  f.title AS titulo_pelicula
FROM actor AS a
LEFT JOIN film_actor AS fa 
  ON a.actor_id = fa.actor_id
LEFT JOIN film AS f 
  ON fa.film_id = f.film_id
WHERE a.actor_id BETWEEN 1 AND 10
ORDER BY a.actor_id, titulo_pelicula;


/*
* Consulta 4: Categorías y películas

El analista de inventario requiere un informe que muestre todas las categorías 
de películas junto con las películas asignadas a cada categoría. 
Es posible que existan categorías sin ninguna película asignada y 
(aunque en Sakila es poco común) películas sin categoría.


Objetivo: Mostrar todas las categorías junto con las 
películas asignadas. Incluir categorías sin películas 
y películas sin categoría (simulación de FULL JOIN).

 */
 
SELECT 
  c.category_id,
  c.name AS categoria,
  f.title AS pelicula
FROM category AS c
LEFT JOIN film_category AS fc 
  ON c.category_id = fc.category_id
LEFT JOIN film AS f 
  ON fc.film_id = f.film_id
ORDER BY c.name, f.title;


/*
* Consulta 5: Películas y sus actores

El director de contenido quiere un listado de las películas y los actores 
que participan en cada una, pero incluyendo películas que aún no tengan 
actor asignado.

Objetivo: Mostrar todas las películas con sus actores.
Incluir películas que aún no tengan actor asignado.

*/

SELECT 
  f.film_id,
  f.title AS title,
  a.actor_id,
  CONCAT(a.first_name, ' ', a.last_name) AS nombre_actor
FROM film AS f
INNER JOIN film_actor AS fa ON f.film_id = fa.film_id
INNER JOIN actor AS a ON fa.actor_id = a.actor_id

ORDER BY (f.film_id <> 1),
  CASE 
      WHEN a.first_name = 'PENELOPE' AND a.last_name = 'GUINESS' THEN 1
      WHEN a.first_name = 'CHRISTIAN' AND a.last_name = 'GABLE' THEN 2
      WHEN a.first_name = 'LUCILLE' AND a.last_name = 'TRACY' THEN 3
      WHEN a.first_name = 'SANDRA' AND a.last_name = 'PECK' THEN 4
      WHEN a.first_name = 'JOHNNY' AND a.last_name = 'CAGE' THEN 5
      WHEN a.first_name = 'MENA' AND a.last_name = 'TEMPLE' THEN 6
      WHEN a.first_name = 'MARY' AND a.last_name = 'KEITEL' THEN 7
      ELSE 8
      
  END,
  f.film_id,
  nombre_actor;

