
public class boletin05 {


    /*
        1. Escribir un programa que genere seis números aleatorios entre el 1 y el 49 sin que
         ninguno de ellos esté repetido (simulando una lotería primitiva).
     */

        // 1º- Creo un array de 6 posiciones para guardar los números.
        // 2º- Uso un bucle para ir generando números aleatorios entre 1 y 49.
        // 3º- Compruebo en otro bucle si el número ya está en el array.
        // 4º- Si no está repetido, lo guardo; si está, repito la generación.
        // 5º- Al final, muestro el array completo.


    public static void ejercicio1() {

        System.out.println("*** Ejercicio 1 ***");

        int[] numeros = new int[6];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            int nuevo;
            boolean repetido;

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

        System.out.print("Números de la lotería: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println("Fin del ejercicio");
        System.out.println();
    }


/*
       2. Hacer un programa en que nos permita calcular todos los divisores comunes a dos números
 */

    //  1º- Pido dos números al usuario.
    //  2º- Calculo el menor de los dos para saber hasta dónde debo buscar divisores.
    //  3º- Recorro con un for desde 1 hasta ese menor.
    //  4º- Compruebo si el número actual divide a ambos.
    //  5º- 5º- Si lo hace, lo guardo en un array auxiliar y lo muestro.

    public static void ejercicio2() {

        System.out.println("*** Ejercicio 2 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduce el segundo número: ");
        int num2 = sc.nextInt();

        int menor = (num1 < num2) ? num1 : num2;
        int[] divisores = new int[menor];
        int contador = 0;

        for (int i = 1; i <= menor; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                divisores[contador] = i;
                contador++;
            }
        }

        System.out.print("Divisores comunes: ");
        for (int i = 0; i < contador; i++) {
            System.out.print(divisores[i] + " ");
        }
        System.out.println("Fin del ejercicio");
        System.out.println();
    }


    /*
        3. Escribir un programa que cuenta las palabras que tiene una frase introducida
         previamente por teclado. Las palabras pueden estar separadas por más de un espacio.
     */

        // 1º- Pido una frase al usuario.
        // 2º- Recorro la frase carácter a carácter.
        // 3º- Cuando detecto una letra después de un espacio, cuento una nueva palabra.
        // 4º- Cuento la primera palabra si la frase no empieza con espacio.
        // 5º- Muestro el número total de palabras.

    public static void ejercicio3() {

        System.out.println("*** Ejercicio 3 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = teclado.nextLine();

        int contador = 0;
        boolean dentroPalabra = false;

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (c != ' ' && !dentroPalabra) {
                dentroPalabra = true;
                contador++;

            } else if (c == ' ') {
                dentroPalabra = false;
            }
        }

        System.out.println("Número de palabras: " + contador);

        System.out.println("Fin del ejercicio");
        System.out.println();

    }


    /*
        4. Escribir un programa que nos pida una cadena por teclado y luego cuente cuantas
        palabras hay en ella con cuatro o más vocales diferentes.
    */

        // 1º- Pido la frase al usuario y la paso a minúsculas.
        //  2º- Divido la frase en palabras usando split.
        // 3º- Para cada palabra, creo un array de 5 posiciones para marcar si aparece cada vocal.
        // 4º- Recorro la palabra y marco las vocales que aparecen.
        // 5º- Cuento cuántas vocales diferentes tiene y si son 4 o más, aumento el contador.


    public static void ejercicio4() {

        System.out.println("*** Ejercicio 4 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = teclado.nextLine().toLowerCase();

        String[] palabras = frase.split("\\s+");
        int contadorPalabras = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < palabras.length; i++) {
            boolean[] tieneVocal = new boolean[5];
            int diferentes = 0;

            for (int j = 0; j < palabras[i].length(); j++) {
                char c = palabras[i].charAt(j);

                for (int v = 0; v < vocales.length; v++) {

                    if (c == vocales[v] && !tieneVocal[v]) {
                        tieneVocal[v] = true;
                        diferentes++;
                    }
                }
            }

            if (diferentes >= 4) {
                contadorPalabras++;
            }
        }

        System.out.println("Palabras con 4 o más vocales diferentes: " + contadorPalabras);

        System.out.println("Fin del ejercicio");
        System.out.println();
    }


    /*
        5. Escribe un programa que genere 100 números aleatorios comprendidos entre el 1 y
       50 (ambos inclusive) y, posteriormente, obtenga el mayor, el menor y el que más veces
       se repite (y nos diga cuántas veces lo hace).
     */

        // 1º- Creo un array de 100 elementos.
        // 2º- Lo lleno con números aleatorios del 1 al 50.
        // 3º- Busco el mayor y el menor usando un bucle for.
        // 4º- Uso otro array de 51 posiciones para contar cuántas veces aparece cada número.
        // 5º- Encuentro el que más se repite mirando ese array de frecuencias.


    public static void ejercicio5() {

        System.out.println("*** Ejercicio 5 ***");

        int[] numeros = new int[100];
        int[] frecuencia = new int[51];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(50) + 1;
        }

        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > mayor) mayor = numeros[i];
            if (numeros[i] < menor) menor = numeros[i];
            frecuencia[numeros[i]]++;
        }

        int masRepetido = 0;
        int maxRepeticiones = 0;

        for (int i = 1; i < frecuencia.length; i++) {
            if (frecuencia[i] > maxRepeticiones) {
                maxRepeticiones = frecuencia[i];
                masRepetido = i;
            }
        }

        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Número más repetido: " + masRepetido + " (" + maxRepeticiones + " veces)");

        System.out.println("Fin del ejercicio");
        System.out.println();
    }


    /*
        6. Escribe un programa que nos permita contar el número de veces que se repite cada
        cifra en un número. Ejemplo: 885210003 tiene tres 0, un 1, un 2, un 5 y dos 8.
     */

        // 1º- Pido al usuario un número entero largo (String para conservar los ceros).
        // 2º- Creo un array de 10 posiciones para contar las repeticiones de las cifras 0–9.
        // 3º- Recorro la cadena y aumento el contador correspondiente en el array.
        // 4º- Al final, muestro las cifras que aparecen con su cantidad.

    public static void ejercicio6() {

        System.out.println("*** Ejercicio 6 ***");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        String numero = teclado.nextLine();

        int[] contador = new int[10];

        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);

            if (Character.isDigit(c)) {
                int digito = c - '0';
                contador[digito]++;
            }
        }

        for (int i = 0; i < contador.length; i++) {
            if (contador[i] > 0) {
                System.out.println("El dígito " + i + " aparece " + contador[i] + " veces.");

                System.out.println("Fin ejercicio");
                System.out.println();
            }
        }
    }
}














}