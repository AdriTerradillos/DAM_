-- para dar un criterio de búsqueda variable (una condicion donde x sea igual a eso que quiero buscar) --> 'contiene...', 'se parece a...')



SELECT * FROM users WHERE email LIKE '%gmail.com%';  -- selecciona  aquellos usuarios de mi tabla users que contienen algo así como 'gmail.com' de mi columna gmail

SELECT * FROM users WHERE email LIKE 'gmail.com%';  -- selecciona  aquellos usuarios de mi tabla users que contienen algo así como que empiecen con 'gmail.com' de mi columna gmail

SELECT * FROM users WHERE email LIKE '%miriam@%';  -- selecciona  aquellos usuarios de mi tabla users que contienen algo antes de sintáxis LIKE seguido de '%miriam@%' seguido de sintáxis final de mi columna gmail

SELECT * FROM users WHERE email LIKE '%@g%';  -- selecciona  aquellos usuarios de mi tabla users que contienen algo antes de sintáxis LIKE con '%@.g%' seguido de sintáxis final de mi columna gmail



