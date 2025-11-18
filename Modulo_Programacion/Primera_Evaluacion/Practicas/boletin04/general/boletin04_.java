package Primera_Evaluacion.Practicas.boletin04.general;

import java.util.Scanner;

public class boletin04_ {


    public class BoletinFactorialFibonacci {

        /*
        Ejercicio 1:
        Escribir un programa que pida un número por teclado y calcule su factorial.
        */

        // 1º- Pido un número al usuario.
        // 2º- Inicializo factorial a 1 y recorro desde 1 hasta el número multiplicando sucesivamente.
        // 3º- Imprimo el factorial.

        public static void ejercicio1() {

            Scanner teclado = new Scanner(System.in);

            int numero;
            long factorial;

            System.out.print("Introduce un número: ");
            numero = teclado.nextInt();
            factorial = 1;

            for ( int i = 1 ; i <= numero ; i++ ) {
                factorial *= i;
            }

            System.out.println("El factorial de " + numero + " es: " + factorial);
        }


        /*
        Ejercicio 2:
        Recibir un número por teclado y calcular los primeros números de la sucesión de Fibonacci según ese número.
        */

        // 1º- Pido un número n al usuario.
        // 2º- Inicializo los dos primeros números de Fibonacci.
        // 3º- Imprimo los n números de la sucesión.

        public static void ejercicio2() {

            Scanner teclado = new Scanner(System.in);

            int n;
            System.out.print("Introduce la cantidad de números de Fibonacci: ");
            n = teclado.nextInt();

            int a = 0;
            int b = 1;

            if ( n >= 1 ) {
                System.out.print(a);
            }

            if ( n >= 2 ) {
                System.out.print("," + b);
            }

            for ( int i = 3 ; i <= n ; i++ ) {
                int c = a + b;
                System.out.print("," + c);
                a = b;
                b = c;
            }

            System.out.println();
        }


        /*
        Ejercicio 3:
        Mostrar todos los números de la sucesión de Fibonacci menores o iguales al número introducido.
        */

        // 1º- Pido un número al usuario.
        // 2º- Inicializo los dos primeros números.
        // 3º- Genero la sucesión mientras sea menor o igual al número.

        public static void ejercicio3() {

            Scanner teclado = new Scanner(System.in);

            int limite;
            System.out.print("Introduce un número límite: ");
            limite = teclado.nextInt();

            int a = 0;
            int b = 1;

            System.out.print(a);

            if ( b <= limite ) {
                System.out.print("," + b);
            }

            int c = a + b;

            while ( c <= limite ) {
                System.out.print("," + c);
                a = b;
                b = c;
                c = a + b;
            }

            System.out.println();
        }


        /*
        Ejercicio 4:
        Contar el número de cifras de un número.
        */

        // 1º- Pido un número al usuario.
        // 2º- Inicializo contador a 0.
        // 3º- Divido sucesivamente entre 10 hasta que sea 0 incrementando contador.

        public static void ejercicio4() {

            Scanner teclado = new Scanner(System.in);

            int numero;
            int contador;

            System.out.print("Introduce un número: ");
            numero = teclado.nextInt();

            contador = 0;
            int n = numero;

            do {
                n = n / 10;
                contador++;

            } while ( n != 0 );
            System.out.println("El número " + numero + " tiene " + contador + " cifras.");
        }

        /*
        Ejercicio 5:
        Determinar si un número es capicúa.
        */

        // 1º- Pido un número al usuario.
        // 2º- Invierto el número y comparo con el original.

        public static void ejercicio5() {

            Scanner teclado = new Scanner(System.in);

            int numero;
            System.out.print("Introduce un número: ");
            numero = teclado.nextInt();

            int original = numero;
            int invertido = 0;

            while ( numero != 0 ) {
                int digito = numero % 10;

                invertido = invertido * 10 + digito;
                numero = numero / 10;
            }

            if ( original == invertido ) {
                System.out.println("El número " + original + " es capicúa.");

            } else {
                System.out.println("El número " + original + " no es capicúa.");
            }
        }


        /*
        Ejercicio 6:
        Mostrar los 50 primeros números primos, sus raíces cuadradas, cuadrados y cubos.
        */

        // 1º- Inicializo contador de primos encontrados.
        // 2º- Recorro números naturales verificando si son primos.
        // 3º- Para cada primo calculo raíz, cuadrado y cubo y lo muestro.

        public static void ejercicio6() {

            int contador = 0;
            int numero = 2;

            while ( contador < 50 ) {
                boolean esPrimo = true;

                for ( int i = 2 ; i <= Math.sqrt(numero) ; i++ ) {

                    if ( numero % i == 0 ) {
                        esPrimo = false;
                        break;
                    }
                }

                if ( esPrimo ) {
                    System.out.println("Primo: " + numero + ", Raíz: " + String.format("%.2f", Math.sqrt(numero)) + ", Cuadrado: " + (numero*numero) + ", Cubo: " + (numero*numero*numero));
                    contador++;
                }

                numero++;
            }
        }


        /*
        Ejercicio 7:
        Calcular la primera pareja de primos gemelos por encima del 50.
        */

        // 1º- Recorro números a partir de 51.
        // 2º- Verifico si un número y el siguiente primo forman una pareja gemela.

        public static void ejercicio7() {

            int n = 51;

            while ( true ) {
                boolean esPrimoN = true;

                for ( int i = 2 ; i <= Math.sqrt(n) ; i++ ) {

                    if ( n % i == 0 ) {
                        esPrimoN = false;
                        break;
                    }
                }

                boolean esPrimoN2 = true;
                int siguiente = n + 2;

                for ( int i = 2 ; i <= Math.sqrt(siguiente) ; i++ ) {

                    if ( siguiente % i == 0 ) {
                        esPrimoN2 = false;
                        break;
                    }
                }

                if ( esPrimoN && esPrimoN2 ) {
                    System.out.println("Primera pareja de primos gemelos >50: " + n + " y " + siguiente);
                    break;
                }

                n++;
            }
        }


        /*
        Ejercicio 8:
        Sumar cifras pares e impares de un número y mostrar ambos resultados.
        */

        // 1º- Pido un número al usuario.
        // 2º- Recorro cada cifra, sumando según sea par o impar.

        public static void ejercicio8() {

            Scanner teclado = new Scanner(System.in);

            int numero;
            System.out.print("Introduce un número: ");
            numero = teclado.nextInt();

            int sumaPares = 0;
            int sumaImpares = 0;
            int n = numero;

            while ( n != 0 ) {
                int digito = n % 10;

                if ( digito % 2 == 0 ) {
                    sumaPares += digito;

                } else {
                    sumaImpares += digito;
                }

                n = n / 10;
            }

            System.out.println("Suma cifras pares: " + sumaPares + ", Suma cifras impares: " + sumaImpares);
        }


        /*
        Ejercicio 9:
        Contar cuántas veces aparece un carácter en una cadena y en qué posiciones.
        */

        // 1º- Pido la cadena y el carácter.
        // 2º- Recorro la cadena y cuento coincidencias, almacenando posiciones.

        public static void ejercicio9() {

            Scanner teclado = new Scanner(System.in);

            System.out.print("Introduce una cadena: ");
            String cadena = teclado.nextLine();

            System.out.print("Introduce un carácter: ");
            char c = teclado.next().charAt(0);

            int contador = 0;
            String posiciones = "";

            for ( int i = 0 ; i < cadena.length() ; i++ ) {

                if ( cadena.charAt(i) == c ) {
                    contador++;
                    posiciones += i + ",";
                }
            }

            if ( posiciones.length() > 0 ) {
                posiciones = posiciones.substring(0, posiciones.length()-1);
            }

            System.out.println("El carácter " + c + " aparece " + contador + " veces en las posiciones: " + posiciones);
        }


        /*
        Ejercicio 10:
        Imprimir sólo las cifras que aparecen en una cadena.
        */

        // 1º- Pido la cadena.
        // 2º- Recorro la cadena y muestro los caracteres que sean dígitos.

        public static void ejercicio10() {

            Scanner teclado = new Scanner(System.in);

            System.out.print("Introduce una cadena: ");
            String cadena = teclado.nextLine();
            String resultado = "";

            for ( int i = 0 ; i < cadena.length() ; i++ ) {

                if ( Character.isDigit(cadena.charAt(i)) ) {
                    resultado += cadena.charAt(i);
                }
            }

            System.out.println("Cifras encontradas: " + resultado);
        }


        /*
        Ejercicio 11:
        Imprimir una frase separando cada carácter de las palabras con guiones.
        */

        // 1º- Pido la frase.
        // 2º- Recorro la frase y agrego guiones entre caracteres excepto espacios.

        public static void ejercicio11() {

            Scanner teclado = new Scanner(System.in);

            System.out.print("Introduce una frase: ");
            String frase = teclado.nextLine();
            String salida = "";

            for ( int i = 0 ; i < frase.length() ; i++ ) {
                char c = frase.charAt(i);

                if ( c != ' ' ) {
                    salida += c + "-";

                } else {
                    salida = salida.substring(0, salida.length()-1);
                    salida += " ";
                }
            }

            if ( salida.endsWith("-") ) {
                salida = salida.substring(0, salida.length()-1);
            }

            System.out.println(salida);
        }

        /*
        Ejercicio 12:
        Comprobar si un año es bisiesto.
        */
        // 1º- Pido un año al usuario.
        // 2º- Compruebo divisibilidad por 4 y 100 y 400 según la regla de años bisiestos.
        public static void ejercicio12() {
            Scanner teclado = new Scanner(System.in);
            int anio;
            System.out.print("Introduce un año: ");
            anio = teclado.nextInt();
            boolean bisiesto = false;
            if ( anio % 4 == 0 ) {
                bisiesto = true;

                if ( anio % 100 == 0 && anio % 400 != 0 ) {
                    bisiesto = false;
                }
            }
            if ( bisiesto ) {
                System.out.println(anio + " es bisiesto.");

            } else {
                System.out.println(anio + " no es bisiesto.");
            }
        }


        /*
        Ejercicio 13:
        Crear una matriz compacta repitiendo un carácter en filas y columnas.
        */

        // 1º- Pido un número y un carácter al usuario.
        // 2º- Recorro filas y columnas mostrando el carácter.

        public static void ejercicio13() {

            Scanner teclado = new Scanner(System.in);

            int n;
            char c;

            System.out.print("Introduce un número: ");
            n = teclado.nextInt();

            System.out.print("Introduce un carácter: ");
            c = teclado.next().charAt(0);

            for ( int i = 1 ; i <= n ; i++ ) {

                for ( int j = 1 ; j <= n ; j++ ) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }


        /*
        Ejercicio 14:
        Leer una hora en formato 24h y determinar si corresponde a mañana, tarde, noche o madrugada.
        */

        // 1º- Pido hora y minutos al usuario.
        // 2º- Compruebo si la hora y minuto son válidos.
        // 3º- Determino el periodo del día.

        public static void ejercicio14() {

            Scanner teclado = new Scanner(System.in);

            int hora;
            int min;
            System.out.print("Introduce la hora (HH MM): ");

            hora = teclado.nextInt();
            min = teclado.nextInt();

            if ( hora < 0 || hora > 23 || min < 0 || min > 59 ) {
                System.out.println("Hora no válida.");

            } else if ( hora >= 6 && hora <= 11 ) {
                System.out.println("Es de la mañana.");

            } else if ( hora >= 12 && hora <= 19 ) {
                System.out.println("Es de la tarde.");

            } else if ( hora >= 20 && hora <= 23 ) {
                System.out.println("Es de la noche.");

            } else {
                System.out.println("Es de la madrugada.");
            }
        }



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
        }
    }




}
