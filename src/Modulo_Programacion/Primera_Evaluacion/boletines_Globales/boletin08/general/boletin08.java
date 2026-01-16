package Modulo_Programacion.Primera_Evaluacion._00_javaBasico.Practicas.boletin08.general;

import java.util.Random;
import java.util.Scanner;

public class boletin08 {


        /*
        Ejercicio 1: Matriz transpuesta

        Una matriz transpuesta es aquella en la que se intercambian filas por columnas.
        Realiza un programa que dada una matriz almacenada en un array te calcule su transpuesta y la almacene en otro diferente.
        Tu programa debería, ademas, dibujar en consola las matrices de la siguiente forma:

       */

        /*

            estructura ejercicio 1:
            1º- crear un array bidimensional con la matriz original.
            2º- crear otro array bidimensional para almacenar la transpuesta.
            3º- recorrer la matriz original y copiar los elementos intercambiando filas.
            por columnas.
            4º- Mostrar ambas matrices por consola.

        */


    public static void ejercicio1() {

        System.out.println("*** Ejercicio 1 ***");

        int[][] matriz = {{1, 2}, {3, 4}};
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];


        //calculo de la transpuesta
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        // muestro matriz original
        System.out.println("··· Matriz Original: ···");
        for (int i = 0; i < filas; i++) {
            System.out.println("| ");

            for (int j = 0; j < columnas; j++) {
                System.out.println(matriz[i][j] + " ");
            }

            System.out.println("|");


        }

        // muestro ahora la transpuesta
        System.out.println("··· Matriz Transpuesta: ···");
        for (int i = 0; i < columnas; i++) {
            System.out.println("| ");

            for (int j = 0; j < filas; j++) {
                System.out.println(transpuesta[i][j] + " ");

            }
            System.out.println("|");

            System.out.println("\nFin del ejercicio");
            System.out.println();
            System.out.println("-----------------------");
            System.out.println();

        }

    }

        /* Ejercicio 2: Comprobando la contraseña...

        Pide al usuario una contraseña y comprueba que cumple:

        a) 8-20 caracteres
        b) Al menos una mayúscula y una minúscula
        c) Al menos un número
        d) Al menos un símbolo entre _, -, !, ?, *
        Si es incorrecta se pide otra vez. Luego se pide repetirla y se compara.
       */

        /* estructuración ejercicio 2:
            1. Pedir contraseña en bucle hasta que cumpla las condiciones.
            2. Comprobar longitud, mayúscula, minúscula, número y símbolo.
            3. Una vez válida, pedir confirmación y verificar coincidencia.
        */


    public static void ejercicio2(String password, String confirm) {

        System.out.println("*** Ejercicio 2 ***");
        Scanner teclado = new Scanner(System.in);

        boolean valida;

        do {
            System.out.print("Introduce la contraseña: ");
            password = teclado.nextLine();

            valida = password.length() >= 8 && password.length() <= 20 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*[a-z].*") &&
                    password.matches(".*\\d.*") &&
                    password.matches(".*[_\\-!?*].*");

            if (!valida) {
                System.out.println("Contraseña no válida. Intenta de nuevo.");
            }

        } while (!valida);

        do {
            System.out.print("Repite la contraseña: ");
            confirm = teclado.nextLine();

            if (!password.equals(confirm)) {
                System.out.println("No coincide. Empezamos de nuevo.");

                do {
                    System.out.print("Introduce la contraseña: ");
                    password = teclado.nextLine();
                    valida = password.length() >= 8 && password.length() <= 20 &&
                            password.matches(".*[A-Z].*") &&
                            password.matches(".*[a-z].*") &&
                            password.matches(".*\\d.*") &&
                            password.matches(".*[_\\-!?*].*");

                } while (!valida);
            }
        } while (!password.equals(confirm));

        System.out.println("Contraseña correcta y confirmada.");

        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

    }

    /*  Ejercicio 3: cifrado alternando caracteres

       Mezcle los caracteres alternando entre los del principio y los del final del mensaje empezando por el final.
        Ejemplo: "12345" -> "51432"
     */

        /* estructuración ejercicio 3:
            1. Leer mensaje del usuario.
            2. Crear un nuevo array para el mensaje cifrado.
            3. Intercalar caracteres desde el final y el principio.
        */


    public static void ejercicio3() {

        System.out.println("*** Ejercicio 3 ***");
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el mensaje a cifrar: ");
        String mensaje = teclado.nextLine();
        StringBuilder cifrado = new StringBuilder();

        int inicio = 0;
        int fin = mensaje.length() - 1; // última cifra

        while (inicio <= fin) {
            cifrado.append(mensaje.charAt(fin));
            fin--; // contador en autodecremento

            if (inicio <= fin) {
                cifrado.append(mensaje.charAt(inicio));
                inicio++; // contador autoincremento (última letra primera posición)

            }
        }
        System.out.println("Mensaje cifrado: " + cifrado);

        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

    }


    /*  Ejercicio 4: cifrado con cambio aleatorio de mayúsculas

        Modifica el cifrado anterior cambiando aleatoriamente algunas letras
        de mayúsculas a minúsculas.
   */

        /* estructuración ejercicio 4
            1. Recorrer el mensaje cifrado anterior.
            2. Para cada carácter, aleatoriamente decidir si cambiar a mayúscula o minúscula.
            3. Mostrar el resultado.
        */


    public static void ejercicio4() {

        System.out.println("*** Ejercicio 4 ***");
        Random random = new Random();
        StringBuilder cifradoAleatorio = new StringBuilder();

        for (int i = 0; i < cifradoAleatorio.length(); i++) {
            char c = cifradoAleatorio.charAt(i);

            if (Character.isLetter(c)) {

                if (random.nextBoolean()) {
                    c = Character.toUpperCase(c);

                } else {
                    c = Character.toLowerCase(c);
                }
            }

            cifradoAleatorio.append(c);

        }

        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

    }


    /* Ejercicio 5: Descifrado del mensaje

    Desencriptar el mensaje cifrado. Como no se sabe la mayúscula original,
    poner todas en mayúsculas.

    */

        /* estructuración ejercicio 5:
            1. Recorrer el mensaje cifrado alternando posiciones para reconstruir el original.
            2. Convertir todo a mayúsculas
        */


    public static void ejercicio5() {

        System.out.println("*** Ejercicio 5 ***");

        StringBuilder descifrado = new StringBuilder();
        StringBuilder cifradoAleatorio = new StringBuilder();

        int inicio = 0;
        int fin = descifrado.length() - 1;

        char[] desc = new char[cifradoAleatorio.length()];
        int contador = 0;

        while (inicio <= fin) {
            desc[contador++] = cifradoAleatorio.charAt(fin--);

            if (inicio <= fin) {
                desc[contador++] = cifradoAleatorio.charAt(inicio++);

            }
        }

        for (char c : desc) {
            descifrado.append(Character.toUpperCase(c));
        }

        System.out.println("Mensaje descifrado [en mayúsculas]: " + descifrado);


        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

    }

    /* Ejercicio 6: Palíndromo

         Leer una frase y decir si es palíndromo (ignorar espacios y
         mayúsculas).
    */

        /* estructuración ejercicio 6:
            1. Leer frase.
            2. Quitar espacios y pasar a minúsculas.
            3. Comparar con la misma frase invertida.
        */


    public static void ejercicio6() {

        System.out.println("*** Ejercicio 6 ***");
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una cadena de texto para comprobar políndromo: ");
        String cadena = teclado.nextLine();

        cadena = cadena.replaceAll("\\s+", "").toLowerCase();
        String cadenaInvertida = new StringBuilder(cadena).reverse().toString();

        if (cadena.equals(cadenaInvertida)) {
            System.out.println("La cadena introducida es un políndromo.");

        } else {
            System.out.println("La cadena introducida NO es un políndromo.");

        }

        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

    }

        /* Ejercicio 7: Número Armstrong

          Un número es Armstrong si la suma de sus dígitos elevados al número de dígitos es igual
          al propio número.

         */

            /* estructuración ejercicio 7:
            1. Leer número por scanner
            2. Calcular cantidad de dígitos.
            3. Sumar cada dígito elevado al número de dígitos.
            4. Comparar con número original.
            */

    public static void ejercicio7() {

        System.out.println("*** Ejercicio 7 ***");
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número para comprobar si es Armstrong: ");
        int num = teclado.nextInt();

        int numOriginal = num;
        int suma = 0;
        int digitos = String.valueOf(num).length();  // calculo cantidad de dígitos

        while (num > 0) {
            int dig = num % 10;
            suma += Math.pow(dig, digitos);
            num /= 10;
        }

        if (suma == numOriginal) {
            System.out.println("El número " + numOriginal + "es narcisista");

        } else {
            System.out.println("El número " + numOriginal + "no es narcisista");
        }


        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

        teclado.close();


    }

    // Main para llamar a los ejercicios

    public static void main(String[] args) {

        ejercicio1();
        // ejercicio2(String password, String confirm)
        ejercicio3();
        ejercicio4();
        ejercicio5();
        ejercicio6();
        ejercicio7();

    }


}


