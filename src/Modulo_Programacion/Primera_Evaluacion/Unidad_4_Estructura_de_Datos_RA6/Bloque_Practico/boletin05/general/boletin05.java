package Modulo_Programacion.Primera_Evaluacion._00_javaBasico.UT4.Estructura_Datos.Estructuras_Datos.practicas.boletin05.general;

public class boletin05 {

    static void main() {
        ejercicio01();
        ejercicio02(56, 82);
        System.out.println("Palabras totales: " + ejercicio03(" Hola   mundo   cruel  "));
        System.out.println("Palabras que contengan 4 o más vocales distintas: " +
                ejercicio04("Repasar programación es desafiante a la vez que interante"));
        ejercicio05();
        ejercicio06(472904678);

        /*  Este boletín de ejercicios está orientado a practicar con todo lo visto en los
            boletines anteriores incluyendo, además vectores y/o arrays, listas o estructuras
            complejas similares
        */

        /*     1.Escribir un programa que genere seis números aleatorios entre el 1 y el 49 sin que
               ninguno de ellos esté repetido (simulando una lotería primitiva).
        */

        /* 1º- genero un array de 6 posiciones para guardar
            los números aleatorios
            2º- Uso un bucle para ir generando núm aleatorios entre [1 - 49]
            3º- Compruebo el otro bucle si el núm ya esta en el array
            4º- Si no está repetido, lo guardo; si está, repito la generación
            5º- Muestro el mesaje por pantalla
         */
    }

    public static void ejercicio01() {

        System.out.println("\nEjercicio 1");
        int[] numeros = new int[6];
        int contador = 0;

        // primer comprobante
        while (contador < 6) {
            int aleatorio = 1 + (int) (Math.random() * 49);
            boolean repetido = false;

            // entro al bucle for
            for (int i = 0; i < contador; i++) {
                if (numeros[i] == aleatorio) {
                    repetido = true;
                    break;
                }
            }
            // anido do-while para comprobar las variables creadas

            if (!repetido) {
                numeros[contador] = aleatorio;
                contador++;
            }
        }

        System.out.println("Números de la lotería generados: ");

        for (int n : numeros)
            System.out.println(n + " ");

        System.out.println("\nFin del ejercicio");
    }

    /*     2.Hacer un programa en que nos permita calcular todos los divisores comunes a dos
           números
    */

    /*
    1º- Pido dos números al usuario
    2º- Calculo cual de los dos es menor para usarlo de límite
    3º- Recorro desde 1 hasta ese límite comprobando si ambos son divisibles
    por ese número
     */
    public static void ejercicio02(int a, int b) {
        System.out.println("\n** Ejercicio 2 **");
        int limite = Math.min(a, b);
        System.out.print("Divisores comúnes: ");

        // entro en el bucle for
        for (int i = 1; i <= limite; i++) {
            if (a % i == 0 && b % i == 0)
                System.out.println(i + " ");
        }

        System.out.println("\nFin del ejercicio");
    }

    /*     3.Escribir un programa que cuenta las palabras que tiene una frase introducida
           previamente por teclado. Las palabras pueden estar separadas por más de un espacio pero
           siempre debe de haber al menos uno. No tenemos en cuenta los signos de puntuación como
           separadores.
    */

    public static int ejercicio03(String frase) {
        System.out.println("\n** Ejercicio 3 **");
        frase = frase.trim();

        // realizo las comprobaciones en caso de frase vacía
        if (frase.isEmpty()) {
            System.out.println("\nFin ejercicio");
            return 0;
        }

        String[] palabras = frase.split(" +");
        System.out.println("\nFin ejercicio");
        return palabras.length;

    }

    /*     4.Escribir un programa que nos pida una cadena por teclado y luego cuente cuantas
           palabras hay en ella con cuatro o más vocales diferentes. Por ejemplo, si introducimos
           la frase “Crisis constitucional por culpa del murcielago guineoecuatorial” Nos debería
           de decir que 3. Tendrías que tener en cuenta que las vocales pueden ir en mayúsculas o
           no y son la misma letra. Presupón que ninguna vocal va acentuada de ninguna forma.
    */
    /*
    1º- Separo la frase en palabras
    2º- Pasa cada palabra a minúsculas 'toLowerCase()'
    3º- Compruebo si contiene vocal distinta
    4º- Conteo de la palabra en caso de tener 4 o 5 vocales distintas
     */

    public static int ejercicio04(String frase) {

        System.out.println("\n** Ejercicio 4 **");
        String[] palabras = frase.split(" +");
        int contador = 0;

        // agrupo mi array dentro de palabras con las condiciones siguientes
        for (String palabra : palabras) {
            palabra = palabra.toLowerCase();
            boolean a = palabra.contains("a");
            boolean e = palabra.contains("e");
            boolean i = palabra.contains("i");
            boolean o = palabra.contains("o");
            boolean u = palabra.contains("u");

            // aplico ahora el contador para cada vocal
            int vocales = 0;

            if (a)
                vocales++;
            if (e)
                vocales++;
            if (i)
                vocales++;
            if (o)
                vocales++;
            if (u)
                vocales++;

            if (vocales >= 4) {
                contador++;
            }
        }
        System.out.println("\nFin del ejercicio");
        return contador;
    }

    /*
       5.Escribe un programa que genere 100 números aleatorios comprendidos entre el 1 y 50
       (ambos inclusive) y, posteriormente, obtenga el mayor, el menor y el que mas veces se
       repite (y nos diga cuantas veces lo hace).
    */
    /*
        1º- Genero 100 números aleatorios [1 - 50]
        2º- Guardo la cantidad de veces que aparece cada número
        3º- Busco el máximo y mínimo dentro del array (nuevo array)
        4º- Identifico el número más repetido
    */
    public static void ejercicio05() {
        System.out.println("\n** Ejercicio 5 **");
        int[] numeros = new int[100];
        int[] contadorr = new int[51];

        // bucle for para establecer parámetros
        for (int i = 0; i < 100; i++) {
            int aleatorio = 1 + (int) (Math.random() * 50);
            numeros[i] = aleatorio;
            contadorr[aleatorio]++;
        }

        // máx y mín
        int max = numeros[0];
        int min = numeros[0];

        for (int n : numeros) {
            if (n > max) max = n;
            if (n < min) min = n;
        }

        // identifico num más repetido
        int masRepetido = 1;
        for (int i = 2; i <= 50; i++) {
            if (contadorr[i] > contadorr[masRepetido])
                masRepetido = i;
        }

        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Número más repetido: " + masRepetido + " (" + contadorr[masRepetido] + " veces)");

        System.out.println("\nFin de ejercicio");
        System.out.println();
    }

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

    /* 1º- Convierto el número introducido en cadena
       2º- Bucle for --> recorro cada carácter y convierto a dígito
       3º- Conteo del número de veces que aparece cada cifra [0-9]
       4º- Muestro solo las cifras que aparecen al menos una vez
    */
    public static void ejercicio06(long numero) {
        System.out.println("** Ejercicio 6 **");
        int[] cifras = new int[10];
        String texto = String.valueOf(numero);

        // recorro el número y cuento cada cifra
        for (char c : texto.toCharArray()) {
            cifras[c - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            if (cifras[i] > 0)
                System.out.println(cifras[i] + " número" + (cifras[i] == 1 ? " " : "s ") + i);
        }

        System.out.println("\nFin del ejercicio");
    }
}
