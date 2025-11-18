package Primera_Evaluacion.Practicas.boletin03.general;

import java.util.Scanner;

public class boletin03_ {


    /*
        Ejercicio 1:
        Escribir un programa que pida una contraseña por teclado (dos veces) y si no
        coinciden nos lo vuelva a pedir hasta que lo hagan.
        */

    public static void ejercicio1() {

        Scanner teclado = new Scanner(System.in);

        String pass1;
        String pass2;

        System.out.println("Voy a pedir dos veces la contraseña y comprobar que coinciden:");

        do {
            System.out.print("Introduce la contraseña: ");
            pass1 = teclado.nextLine();

            System.out.print("Vuelve a introducir la contraseña: ");
            pass2 = teclado.nextLine();

        } while ( ! pass1.equals(pass2) );

        System.out.println("¡Contraseña confirmada correctamente!");
    }


    /*
    Ejercicio 2:
    Modifica el programa anterior para que cuando coincidan ambas contraseñas
    nos informe del número de intentos inválidos.
    */

    public static void ejercicio2() {

        Scanner teclado = new Scanner(System.in);

        String pass1;
        String pass2;

        int intentos;
        intentos = 0;

        System.out.println("Voy a pedir dos veces la contraseña y contar los intentos inválidos:");

        do {
            System.out.print("Introduce la contraseña: ");
            pass1 = teclado.nextLine();

            System.out.print("Vuelve a introducir la contraseña: ");
            pass2 = teclado.nextLine();

            if ( ! pass1.equals(pass2) ) {
                intentos++;
            }

        } while ( ! pass1.equals(pass2) );

        System.out.println("¡Contraseña confirmada correctamente!");
        System.out.println("Número de intentos inválidos: " + intentos);
    }

    /*
    Ejercicio 3:
    Escribir un programa que nos pida nuestro nombre y apellidos (dos peticiones
    diferentes hechas en ese orden) y nos lo escriba formateado.
    */

    public static void ejercicio3() {

        Scanner teclado = new Scanner(System.in);

        String nombre;
        String apellidos;

        System.out.print("Introduce tu nombre: ");
        nombre = teclado.nextLine();

        System.out.print("Introduce tus apellidos: ");
        apellidos = teclado.nextLine();

        System.out.println("Mi nombre completo es: " + nombre + " " + apellidos);
    }


    /*
    Ejercicio 4:
    Escribir un programa que pida por teclado una cadena de texto y la escriba sin
    espacios en blanco. Además, nos debe decir el número de espacios eliminados.
    */

    public static void ejercicio4() {

        Scanner teclado = new Scanner(System.in);

        String texto;
        int espacios;
        espacios = 0;

        System.out.print("Introduce una cadena de texto: ");
        texto = teclado.nextLine();

        for ( char c : texto.toCharArray() ) {

            if ( c == ' ' ) {
                espacios++;
            }
        }

        String textoSinEspacios;
        textoSinEspacios = texto.replace(" ", "");

        System.out.println("Texto sin espacios: " + textoSinEspacios);
        System.out.println("Número de espacios eliminados: " + espacios);
    }

    /*
    Ejercicio 5:
    Escribir un programa que pida por teclado una cadena de texto y la imprima escrita al revés.
    */

    public static void ejercicio5() {
        Scanner teclado = new Scanner(System.in);

        String texto;
        System.out.print("Introduce una cadena de texto: ");
        texto = teclado.nextLine();

        String invertido;
        invertido = new StringBuilder(texto).reverse().toString();

        System.out.println("Texto invertido: " + invertido);
    }


    /*
    Ejercicio 6:
    Escribir un programa que pida por teclado una cadena de texto y la separe en dos
    distintas: letras en posiciones pares y letras en posiciones impares.
    */

    public static void ejercicio6() {

        Scanner teclado = new Scanner(System.in);

        String texto;
        System.out.print("Introduce una cadena de texto: ");
        texto = teclado.nextLine();

        String pares;
        String impares;
        pares = "";
        impares = "";

        for ( int i = 0 ; i < texto.length() ; i++ ) {
            if ( i % 2 == 0 ) {
                pares += texto.charAt(i);

            } else {
                impares += texto.charAt(i);
            }
        }

        System.out.println("Letras en posiciones pares: " + pares);
        System.out.println("Letras en posiciones impares: " + impares);
    }


    /*
    Ejercicio 7:
    Escribir un programa que pida por teclado una cadena de texto y la escriba con el
    alfabeto típico de los hackers: a->4, e->3, i->1, o->0.
    */
    public static void ejercicio7() {

        Scanner teclado = new Scanner(System.in);

        String texto;
        System.out.print("Introduce una cadena de texto: ");
        texto = teclado.nextLine();

        texto = texto.replaceAll("(?i)a","4");
        texto = texto.replaceAll("(?i)e","3");
        texto = texto.replaceAll("(?i)i","1");
        texto = texto.replaceAll("(?i)o","0");

        System.out.println("Texto al estilo hacker: " + texto);
    }


    /*
    Ejercicio 8:
    Escribir un programa que reciba una cadena de texto y la muestre sin vocales.
    */

    public static void ejercicio8() {

        Scanner teclado = new Scanner(System.in);

        String texto;
        System.out.print("Introduce una cadena de texto: ");
        texto = teclado.nextLine();

        texto = texto.replaceAll("(?i)[aeiou]", "");

        System.out.println("Texto sin vocales: " + texto);
    }


    /*
    Ejercicio 9:
    Escribir un programa que nos pida elegir entre cuatro destinos turísticos
    (Francia, Italia, Chile o Japón) y dependiendo de nuestra respuesta nos diga
    cuál es la capital de nuestro destino.
    */

    public static void ejercicio9() {

        Scanner teclado = new Scanner(System.in);

        String destino;
        System.out.print("Elige un destino (Francia, Italia, Chile, Japón): ");
        destino = teclado.nextLine().toLowerCase();

        switch ( destino ) {

            case "francia":
                System.out.println("Capital: París");
                break;

            case "italia":
                System.out.println("Capital: Roma");
                break;

            case "chile":
                System.out.println("Capital: Santiago de Chile");
                break;

            case "japón":
            case "japon":
                System.out.println("Capital: Tokio");
                break;

            default:
                System.out.println("Destino no reconocido");
        }
    }

    /*
    Ejercicio 10:
    Escribe un programa que valide si un NIF español introducido por teclado es correcto.
    La longitud exacta de la cadena ha de ser de 9 caracteres, los 8 primeros números y la última letra.
    */

    public static void ejercicio10() {

        Scanner teclado = new Scanner(System.in);

        String nif;
        System.out.print("Introduce un NIF: ");
        nif = teclado.nextLine();

        if ( nif.length() != 9 ) {
            System.out.println("NIF inválido: longitud incorrecta");
            return;
        }

        String numeros;
        char letra;
        numeros = nif.substring(0, 8);
        letra = nif.charAt(8);

        if ( numeros.matches("\\d{8}") && Character.isLetter(letra) ) {
            System.out.println("NIF válido");

        } else {
            System.out.println("NIF inválido");
        }
    }

    /*
    Ejercicio 11:
    Mejorar el programa anterior para que detecte si se trata de un NIF o un NIE
    y nos comunique, además de si es válido, de qué tipo es.
    */

    public static void ejercicio11() {

        Scanner teclado = new Scanner(System.in);

        String entrada;
        System.out.print("Introduce NIF/NIE: ");
        entrada = teclado.nextLine().toUpperCase();

        if ( entrada.matches("\\d{8}[A-Z]") ) {
            System.out.println("Es un NIF válido");

        } else if ( entrada.matches("[XYZ]\\d{7}[A-Z]") ) {
            System.out.println("Es un NIE válido");

        } else {
            System.out.println("No es un NIF ni NIE válido");
        }
    }


    /*
    Ejercicio 12:
    Validar matrículas españolas: 4 dígitos + 3 letras (mayúsculas, sin vocales, Ñ, Q)
    */

    public static void ejercicio12() {

        Scanner teclado = new Scanner(System.in);

        String mat;
        System.out.print("Introduce matrícula: ");
        mat = teclado.nextLine().replaceAll("[- ]", "");

        if ( mat.matches("\\d{4}[B-DF-HJ-NP-TV-Z]{3}") ) {
            System.out.println("Matrícula válida");
        } else {
            System.out.println("Matrícula inválida");
        }
    }

    /*
    Ejercicio 13:
    Modificar el programa anterior para permitir un espacio o guión entre números y letras.
    */
    public static void ejercicio13() {
        Scanner teclado = new Scanner(System.in);

        String mat;
        System.out.print("Introduce matrícula: ");
        mat = teclado.nextLine().replaceAll("[- ]", "");

        if ( mat.matches("\\d{4}[B-DF-HJ-NP-TV-Z]{3}") ) {
            System.out.println("Matrícula válida");
        } else {
            System.out.println("Matrícula inválida");
        }
    }

    /*
    Ejercicio 14:
    Modifica el programa que validaba NIF comprobando si la letra es correcta
    */
    public static void ejercicio14() {
        Scanner teclado = new Scanner(System.in);

        String nif;
        System.out.print("Introduce un NIF: ");
        nif = teclado.nextLine().toUpperCase();

        System.out.println("Validación de letra del NIF: pendiente de implementar la lógica completa");
    }

    /*
    Ejercicio 15:
    Escribe un programa que reciba por teclado una fecha en el formato DD/MM/YYYY.
    El programa debe comprobar si la fecha es correcta, teniendo en cuenta:
    formato correcto y años bisiestos.
    */
    public static void ejercicio15() {
        Scanner teclado = new Scanner(System.in);

        String fecha;
        System.out.print("Introduce una fecha (DD/MM/YYYY): ");
        fecha = teclado.nextLine();

        String[] partes;
        partes = fecha.split("/");

        if ( partes.length != 3 ) {
            System.out.println("Formato de fecha incorrecto");
            return;
        }

        int dia;
        int mes;
        int anio;
        dia = Integer.parseInt(partes[0]);
        mes = Integer.parseInt(partes[1]);
        anio = Integer.parseInt(partes[2]);

        boolean fechaValida;
        fechaValida = false;

        if ( mes >= 1 && mes <= 12 ) {
            int diasMax;
            switch ( mes ) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    diasMax = 31;
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    diasMax = 30;
                    break;

                case 2:
                    if ( ( anio % 4 == 0 && anio % 100 != 0 ) || ( anio % 400 == 0 ) ) {
                        diasMax = 29;

                    } else {
                        diasMax = 28;
                    }

                    break;

                default:
                    diasMax = 0;
            }

            if ( dia >= 1 && dia <= diasMax ) {
                fechaValida = true;
            }
        }

        if ( fechaValida ) {
            System.out.println("La fecha introducida es válida");

        } else {
            System.out.println("La fecha introducida es inválida");
        }
    }


// aquí descomento el ejercicio que quiera ver por pantalla

public static void main(String[] args) {

    // ejercicio1();
    // ejercicio2();
    // ejercicio3();
    // ejercicio4();
    // ejercicio5();
    // ejercicio6();
    // ejercicio7();
    // ejercicio8();
    // ejercicio9();
    // ejercicio10();
    // ejercicio11();
    // ejercicio12();
    // ejercicio13();
    // ejercicio14();
    // ejercicio15();

    }
}

