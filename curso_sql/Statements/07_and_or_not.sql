-- NOT (que no se cumpla la condición)
SELECT * FROM users WHERE NOT email = 'miriam@gmail.com'  -- selecciona  aquellos usuarios de mi tabla users aquellos que sean distintos al email 'miriam@gmail.com' 

-- AND (que se cumplan ambas condiciones)
SELECT * FROM users WHERE NOT email = 'miriam@gmail.com' AND age >= 25; -- selecciona  aquellos usuarios de mi tabla users aquellos que sean distintos al email 'miriam@gmail.com' Y ADEMÁS su edad sea mayor o igual a 25

-- OR (que se cumpla una u otra ondición)
SELECT * FROM users WHERE NOT email = 'miriam@gmail.com' OR age >= 25; -- selecciona  aquellos usuarios de mi tabla users aquellos que sean distintos al email 'miriam@gmail.com' Ó que su edad sea mayor o igual a 25 
