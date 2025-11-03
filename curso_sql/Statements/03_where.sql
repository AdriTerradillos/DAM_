-- limitamos el criterio de las datos que queremos recuperar (lo que yo quiero buscar es algo concreto...)

SELECT * FROM users WHERE age >= 25; -- selecciona aquellos usuarios de mi tabla users que sean mayores de 25 años

SELECT name FROM users WHERE age >= 25; -- selecciona aquellos nombres de los usuarios de mi tabla users que sean mayores de 25 años

SELECT DISTINCT name FROM users WHERE age >= 25; -- selecciona los nombres distintos de los usuarios de los usuarios de mi tabla users que sean mayores de 25 años

SELECT DISTINCT age FROM users WHERE age >= 25; -- selecciona la edad  no repetida / distinta de los usuarios de los usuarios de mi tabla users que sean mayores de 25 años
