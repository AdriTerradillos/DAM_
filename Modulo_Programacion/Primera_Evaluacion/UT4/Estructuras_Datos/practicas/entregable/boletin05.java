package Primera_Evaluacion.UT4.Estructuras_Datos.practicas.entregable;

import java.util.Random;


public class boletin05 {

    public static void main(String[] args) {


/*  Este boletín de ejercicios está orientado a practicar con todo lo visto en los
    boletines anteriores incluyendo, además vectores y/o arrays, listas o estructuras
    complejas similares
*/




/*     1.Escribir un programa que genere seis números aleatorios entre el 1 y el 49 sin que
       ninguno de ellos esté repetido (simulando una lotería primitiva).
*/

/* 1º- genero un array de 6 posiciones para guardar
    los números
    2º- Uso un bucle para ir generando núm aleatorios entre [1 - 49]
    3º- Compruebo el otro bucle si el núm ya esta en el array
    4º- Si no está repetido, lo guardo; si está, repito la generación
    5º- Muestro el mesaje por pantalla
 */

    }
        public void ejercici01() {

            System.out.println("Ejercicio 1");

            int[] numeros = new int[6];
            Random random = new Random();

            // entro al bucle
            for (int i = 0; i < numeros.length; i++) {
                int nuevo;
                boolean repetido;

                // anido do-while para comprobar las variables creadas

                do {
                    repetido = false;
                    nuevo = random.nextInt(49) + 1;

                    for (int j = 0; j < i; j++) {
                        if (numeros[j] == nuevo) {
                            repetido = true;
                            break;
                        }
                    }
                } while (repetido);
                numeros[i] = nuevo;
            }

            System.out.println("Números de la lotería: ");

            for (int i = 0; i < numeros.length; i++) {
                System.out.println(numeros[i] + " ");
            }
            System.out.println("\nFin del ejercicio");
            System.out.println();


        }















/*     2.Hacer un programa en que nos permita calcular todos los divisores comunes a dos
       números
*/


/*     3.Escribir un programa que cuenta las palabras que tiene una frase introducida
       previamente por teclado. Las palabras pueden estar separadas por más de un espacio pero
       siempre debe de haber al menos uno. No tenemos en cuenta los signos de puntuación como
       separadores.
*/



/*     4.Escribir un programa que nos pida una cadena por teclado y luego cuente cuantas
       palabras hay en ella con cuatro o más vocales diferentes. Por ejemplo, si introducimos
       la frase “Crisis constitucional por culpa del murcielago guineoecuatorial” Nos debería
       de decir que 3. Tendrías que tener en cuenta que las vocales pueden ir en mayúsculas o
       no y son la misma letra. Presupón que ninguna vocal va acentuada de ninguna forma.
*/




/*
       5.Escribe un programa que genere 100 números aleatorios comprendidos entre el 1 y 50
       (ambos inclusive) y, posteriormente, obtenga el mayor, el menor y el que mas veces se
       repite (y nos diga cuantas veces lo hace).
*/



/*     6.EJERCICIO CON FORMATO DE EXAMEN
       Escribe un programa que nos permita contar el número de veces que se repite cada cifra
       en un número. Por ejemplo, el número 885210003 tiene tres 0, un 1, un 2, un 5 y dos 8.

       A continuación tienes un ejemplo de ejecución:
       Introduce un número: 885210003
       Tu número tiene:
            2 números 8
            1 número 5
            1 número 3
            1 número 2
            3 números 0

        Fíjate que en la salida no deben de aparecer las
        cifras que no tenga el número. También que se distingue
        el caso en que sólo haya una aparición (la palabra número
        aparece en singular en estos casos)
*/

    }

