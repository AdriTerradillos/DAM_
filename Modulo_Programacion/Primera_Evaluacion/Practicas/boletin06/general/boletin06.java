package Primera_Evaluacion.Practicas.boletin06.general;

import java.util.Scanner;

public class boletin06 {


    public static void main(String[] args) {

        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
        ejercicio6();
        ejercicio7();
        ejercicio8();
        ejercicio9();
        ejercicio10();
    }

    /*
       1. Validar un código postal de Madrid. Cinco números, los dos primeros siempre son el 28.
       Ejemplo válido: 28032

    */

        // 1º- Pido al usuario que introduzca un código postal.
        // 2º- Defino una expresión regular que empiece con "28" seguido de tres dígitos.
        // 3º- Uso la clase Pattern y Matcher para comprobar si coincide.
        // 4º- Muestro si es válido o no.


    public static void ejercicio1() {

        System.out.println("*** Ejercicio 1 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un código postal de Madrid: ");
        String cp = teclado.nextLine();

        String regex = "^28\\d{3}$";
        boolean valido = cp.matches(regex);

        System.out.println(valido ? "Código postal válido." : "Código postal no válido.");

        System.out.println("\nFin del ejercicio");
        System.out.println();

    }

    /*
       2. Validar un número de teléfono. Ejemplo: 91345566
    */

        // 1º- Pido al usuario un número de teléfono.
        // 2º- Defino una expresión regular con exactamente 8 o 9 dígitos.
        // 3º- Compruebo si cumple la condición.
        // 4º- Muestro el resultado.


    public static void ejercicio2() {

        System.out.println("** Ejercicio 2 ***");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número de teléfono: ");
        String tel = teclado.nextLine();

        String regex = "^\\d{8,9}$";
        boolean valido = tel.matches(regex);

        System.out.println(valido ? "Teléfono válido." : "Teléfono no válido.");
    }

    /*
    // 3. Validar un número de teléfono móvil (debe de empezar por 6, 7 u 8)
    // Ejemplo: 655776655
    */

        // 1º- Pido un número de teléfono móvil.
        // 2º- Defino una expresión regular que empiece por 6, 7 u 8 y tenga 9 dígitos.
        // 3º- Valido con matches().

    public static void ejercicio3() {

        System.out.println("*** Ejercicio 3 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número de teléfono móvil: ");
        String movil = teclado.nextLine();

        String regex = "^[678]\\d{8}$";
        boolean valido = movil.matches(regex);

        System.out.println(valido ? "Teléfono móvil válido." : "Teléfono móvil no válido.");

        System.out.println("\nFin del ejercicio");
        System.out.println();

    }


    /*
    // 4. Validar un número de teléfono con prefijo internacional (+34 912233444)

    */

        // 1º- Pido un número con prefijo.
        // 2º- Defino una expresión que empiece con +, dos dígitos, un espacio y luego un número de 9 cifras.
        // 3º- Compruebo si coincide con el patrón.

    public static void ejercicio4() {

        System.out.println("*** Ejercicio 4 ***");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número con prefijo internacional (+34 912233444): ");
        String telefono = teclado.nextLine();

        String regex = "^\\+\\d{2}\\s\\d{9}$";
        boolean valido = telefono.matches(regex);

        System.out.println(valido ? "Teléfono con prefijo válido." : "Teléfono no válido.");

        System.out.println("\nFin del ejercicio");
        System.out.println();

    }

    /*
       5. Validar dos palabras de cualquier tamaño separadas por un único espacio en blanco.
       Las palabras no pueden contener números y deben empezar ambas por mayúscula.
       Ejemplo: Hola Mundo

    */

        // 1º- Pido al usuario una frase con dos palabras.
        // 2º- Defino una expresión que exija que ambas empiecen con mayúscula y sigan con letras.
        // 3º- Valido con matches().


    public static void ejercicio5() {

        System.out.println("*** Ejercicio 5 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce dos palabras (ejemplo: Hola Mundo): ");
        String texto = teclado.nextLine();

        String regex = "^[A-Z][a-zA-Z] + \\s[A-Z][a-zA-Z] + $";
        boolean valido = texto.matches(regex);

        System.out.println(valido ? "Texto válido." : "Texto no válido.");
    }

    /*
       6. Una clave con el formato XX00-xxX-00 donde:
       X = mayúscula, x = minúscula, 0 = dígito.
       Ejemplo: AB12-xyZ-75

    */

        // 1º- Pido una clave.
        // 2º- Defino la expresión regular que siga exactamente ese patrón.
        // 3º- Compruebo si es válida.

    public static void ejercicio6() {

        System.out.println("*** Ejercicio 6 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce una clave (formato XX00-xxX-00): ");
        String clave = teclado.nextLine();

        String regex = "^[A-Z]{2}\\d{2}-[a-z]{2}[A-Z]-\\d{2}$";
        boolean valido = clave.matches(regex);

        System.out.println(valido ? "Clave válida." : "Clave no válida.");

        System.out.println("\nFin del ejercicio");
        System.out.println();

    }

    /*
       7. Validar una tarjeta de crédito: cuatro grupos de cuatro números separados por espacio
       y una fecha de caducidad en formato MM/YY con mes entre 01 y 12.
       Ejemplo: 1234 5678 9012 3456 03/25

    */

        // 1º- Pido una tarjeta completa con fecha.
        // 2º- Uso una expresión con grupos de 4 dígitos y el formato MM/YY.
        // 3º- Aseguro que el mes esté entre 01 y 12.


    public static void ejercicio7() {

        System.out.println("*** Ejercicio 7 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el número de tarjeta con fecha (Ej: 1234 5678 9012 3456 03/25): ");
        String tarjeta = teclado.nextLine();

        String regex = "^(\\d{4}\\s){3}\\d{4}\\s(0[1-9]|1[0-2])/\\d{2}$";
        boolean valido = tarjeta.matches(regex);

        System.out.println(valido ? "Tarjeta válida." : "Tarjeta no válida.");

        System.out.println("\nFin del ejercicio");
        System.out.println();
    }


    /*
       8. Un IBAN bancario de España: las dos letras iniciales siempre tienen que ser ES.
       Ejemplo: ES61 1234 3456 42 0456323532

    */

        // 1º- Pido un IBAN.
        // 2º- Defino una expresión que empiece con ES y siga con números y espacios.
        // 3º- Compruebo si cumple el patrón.


    public static void ejercicio8() {

        System.out.println("*** Ejercicio 8 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un IBAN español: ");
        String iban = teclado.nextLine();

        String regex = "^ES\\d{2}(\\s?\\d{4}){4,5}$";
        boolean valido = iban.matches(regex);

        System.out.println(valido ? "IBAN válido." : "IBAN no válido.");


        System.out.println("\nFin del ejercicio");
        System.out.println();
    }


    /*
       9. Un número de 4 cifras mínimo y 8 cifras máximo.
       Ejemplo: 12345

    */

        // 1º- Pido un número.
        // 2º- Uso una expresión que acepte entre 4 y 8 dígitos.
        // 3º- Valido el número con matches().


    public static void ejercicio9() {

        System.out.println("*** Ejercicio 9 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número (4 a 8 cifras): ");
        String numero = teclado.nextLine();

        String regex = "^\\d{4,8}$";
        boolean valido = numero.matches(regex);

        System.out.println(valido ? "Número válido." : "Número no válido.");


        System.out.println("\nFin del ejercicio");
        System.out.println();
    }


    /*
       10. Una dirección IP pública de clase C.
       Cuatro bytes en formato decimal separados por puntos.


       Los dos primeros siempre 192.168.
         Ejemplo: 192.168.30.30
    */

        // 1º- Pido una dirección IP.
        // 2º- Creo una expresión regular que empiece por 192.168. y valide los dos bytes finales entre 0-255.
        // 3º- Compruebo si coincide.


    public static void ejercicio10() {

        System.out.println("*** Ejercicio 10 ***");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce una dirección IP (Ej: 192.168.30.30): ");
        String ip = teclado.nextLine();

        String regex = "^192\\.168\\.(25[0-5]|2[0-4]\\d|1?\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1?\\d{1,2})$";
        boolean valido = ip.matches(regex);

        System.out.println(valido ? "Dirección IP válida." : "Dirección IP no válida.");


        System.out.println("\nFin del ejercicio");
        System.out.println();
    }


}
