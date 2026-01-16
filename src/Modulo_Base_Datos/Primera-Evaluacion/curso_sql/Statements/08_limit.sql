-- limit -> limita el número de resultados devueltos por una consulta

SELECT * FROM users LIMIT 2; -- selecciona  los tres primeros usuarios de mi tabla users

-- si mezclo NOT con Limit...
SELECT * FROM users WHERE NOT email='miriam@gmail.com' OR age >= 25 LIMIT 2; -- selecciona los dos primeros usuarios de mi tabla users distintos al email 'miriam@gmail.com' Y ADEMÁS su edad sea mayor o igual a 25
