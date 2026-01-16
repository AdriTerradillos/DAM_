USE ejemplos_tipos_join;

# Ejercicio con JOIN'S

/* Ejercicio 1: INNER JOIN
	Listado de alumnos con sus id_curso (solo emparejados)
*/

SELECT a.id_alumno, a.nombre, m.id_curso
FROM alumnos a
INNER JOIN matriculas m ON a.id_alumno = m.id_alumno;
    

/* Ejercicio 2: Alumnos sin matrícula (Anti-JOIN)
	Alumnos sin ninguna matrícula.
*/

SELECT a.id_alumno, a.nombre
FROM alumnos a
LEFT JOIN matriculas m ON a.id_alumno = m.id_alumno
WHERE m.id_matricula IS NULL;


/* Ejercicio 3: Matrículas huérfanas
	Matrículas que no tienen alumno.
*/

SELECT m.id_matricula, m.id_alumno, m.id_curso
FROM matriculas m
LEFT JOIN alumnos a ON m.id_alumno = a.id_alumno
WHERE a.id_alumno IS NULL;


/* Ejercicio 4: Cursos sin matrícula
	Cursos del catálogo sin ninguna matrícula.
*/

SELECT c.id_curso, c.nombre_curso
FROM cursos c
LEFT JOIN matriculas m ON c.id_curso = m.id_curso
WHERE m.id_curso IS NULL;


-- Ejercicio 5: Número de matrículas por alumno (incluye 0)

SELECT a.id_alumno, a.nombre, COUNT(m.id_matricula) AS n_matriculas
FROM alumnos a
LEFT JOIN matriculas m ON a.id_alumno = m.id_alumno
GROUP BY a.id_alumno, a.nombre;
    
    
-- Ejercicio 6: Alumnos con más de un curso

SELECT a.id_alumno, a.nombre, COUNT(m.id_curso) AS n
FROM alumnos a
JOIN matriculas m ON a.id_alumno = m.id_alumno
GROUP BY a.id_alumno, a.nombre
HAVING COUNT(m.id_curso) > 1;


/* Ejercicio 7: FULL OUTER JOIN emulado
	Alumnos y sus matrículas, incluyendo huérfanas (o matrículas que no tienen alumno)
*/
    
   -- LEFT JOIN
SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
LEFT JOIN matriculas m ON a.id_alumno = m.id_alumno
UNION
-- RIGHT JOIN huérfanas
SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
RIGHT JOIN matriculas m ON a.id_alumno = m.id_alumno
WHERE a.id_alumno IS NULL;


/* Ejercicio 8: Número de alumnos por curso
	Para cada curso, número de alumnos con matrícula válida
    (alumno y curso existen)
*/

SELECT c.id_curso, c.nombre_curso, COUNT(m.id_curso) AS n_alumnos
FROM cursos c
LEFT JOIN matriculas m ON c.id_curso = m.id_curso
LEFT JOIN alumnos a ON m.id_alumno = a.id_alumno
GROUP BY c.id_curso, c.nombre_curso;

