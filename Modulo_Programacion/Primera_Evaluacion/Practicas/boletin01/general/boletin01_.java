package Primera_Evaluacion.Practicas.boletin01.general;

import java.util.Random;
import java.util.Scanner;

public class boletin01_ {

    /*
        Ejercicio 1:
        Escribir un programa donde se muestren los 10 primeros números enteros.
        */
    // 1º- Muestro los números del 1 al 10 usando un bucle for.
    public static void ejercicio1() {
        for ( int i = 1 ; i <= 10 ; i++ ) {
            System.out.println(i);
        }
    }

    /*
    Ejercicio 2:
    Escribir un programa donde se muestren los 50 primeros números pares.
    */
    // 1º- Recorro los primeros 50 números y los multiplico por 2 para obtener pares.
    // 2º- Imprimo cada número dentro del bucle.
    public static void ejercicio2() {
        for ( int i = 1 ; i <= 50 ; i++ ) {
            System.out.println(i * 2);
        }
    }

    /*
    Ejercicio 3:
    Escribir un programa donde se muestren los 5 primeros números múltiplos de uno dado por el usuario.
    */
    // 1º- Pido al usuario un número.
    // 2º- Recorro del 1 al 5 multiplicando por el número introducido.
    // 3º- Imprimo cada múltiplo.
    public static void ejercicio3() {
        Scanner teclado = new Scanner(System.in);
        int numero;
        System.out.print("Introduce un número: ");
        numero = teclado.nextInt();
        for ( int i = 1 ; i <= 5 ; i++ ) {
            System.out.println(i * numero);
        }
    }

    /*
    Ejercicio 4:
    Escribir un programa donde se muestren todos los números divisibles por 7 menores a 10000.
    */
    // 1º- Recorro desde 7 hasta 9999 con incremento de 7.
    // 2º- Imprimo cada número divisible por 7.
    public static void ejercicio4() {
        for ( int i = 7 ; i < 10000 ; i += 7 ) {
            System.out.println(i);
        }
    }

    /*
    Ejercicio 5:
    Escribir un programa que pida por teclado un número al usuario y diga si es par o impar.
    */
    // 1º- Pido un número al usuario.
    // 2º- Compruebo si es divisible por 2.
    // 3º- Imprimo "par" o "impar" según corresponda.
    public static void ejercicio5() {
        Scanner teclado = new Scanner(System.in);
        int numero;
        System.out.print("Introduce un número: ");
        numero = teclado.nextInt();
        if ( numero % 2 == 0 ) {
            System.out.println("El número es par");
        } else {
            System.out.println("El número es impar");
        }
    }

    /*
    Ejercicio 6:
    Escribir un programa que pida por teclado un número al usuario y diga si es divisible por 3 o no.
    */
    // 1º- Pido un número al usuario.
    // 2º- Compruebo si es divisible entre 3.
    // 3º- Imprimo el resultado.
    public static void ejercicio6() {
        Scanner teclado = new Scanner(System.in);
        int numero;
        System.out.print("Introduce un número: ");
        numero = teclado.nextInt();
        if ( numero % 3 == 0 ) {
            System.out.println("El número es divisible por 3");
        } else {
            System.out.println("El número no es divisible por 3");
        }
    }

    /*
    Ejercicio 7:
    Escribir un programa que pida un número por teclado que simule ser el precio de un artículo y escriba el resultado de aplicarle el IVA del 21%.
    */
    // 1º- Pido al usuario el precio del artículo.
    // 2º- Calculo el precio con IVA multiplicando por 1.21.
    // 3º- Imprimo el precio final con dos decimales.
    public static void ejercicio7() {
        Scanner teclado = new Scanner(System.in);
        double precio;
        System.out.print("Introduce el precio del artículo: ");
        precio = teclado.nextDouble();
        double precioIVA;
        precioIVA = precio * 1.21;
        System.out.println("Precio con IVA (21%): " + String.format("%.2f", precioIVA));
    }

    /*
    Ejercicio 8:
    Escribir un programa que reciba por teclado el importe de una cantidad a pagar en euros (puede tener decimales) y el número de meses que contamos para pagarla (número entero) y nos devuelva el dinero que tendríamos que pagar cada mes.
    */
    // 1º- Pido al usuario el importe y el número de meses.
    // 2º- Calculo el pago mensual dividiendo el importe entre meses.
    // 3º- Imprimo el resultado con dos decimales.
    public static void ejercicio8() {
        Scanner teclado = new Scanner(System.in);
        double importe;
        int meses;
        System.out.print("Introduce el importe a pagar: ");
        importe = teclado.nextDouble();
        System.out.print("Introduce el número de meses: ");
        meses = teclado.nextInt();
        double pagoMensual;
        pagoMensual = importe / meses;
        System.out.println("Pago mensual: " + String.format("%.2f", pagoMensual));
    }

    /*
    Ejercicio 9:
    Escribir un programa que genere un número aleatorio entre 0 y 50 y lo muestre.
    */
    // 1º- Genero un número aleatorio entre 0 y 50.
    // 2º- Imprimo el número generado.
    public static void ejercicio9() {
        Random rand = new Random();
        int numero;
        numero = rand.nextInt(51);
        System.out.println("Número aleatorio entre 0 y 50: " + numero);
    }

    /*
    Ejercicio 10:
    Escribir un programa que genere dos números aleatorios simultáneamente entre 1 y 6 (simulando dos dados) y los muestre.
    */
    // 1º- Genero dos números aleatorios entre 1 y 6.
    // 2º- Imprimo los resultados.
    public static void ejercicio10() {
        Random rand = new Random();
        int dado1;
        int dado2;
        dado1 = rand.nextInt(6) + 1;
        dado2 = rand.nextInt(6) + 1;
        System.out.println("Dado 1: " + dado1 + ", Dado 2: " + dado2);
    }

    /*
    Ejercicio 11:
    Modificar el ejercicio anterior para que los dados se tiren continuamente hasta que ambos tengan el mismo valor.
    */
    // 1º- Inicializo un contador de tiradas.
    // 2º- Genero los dos dados en un bucle hasta que sean iguales.
    // 3º- Imprimo el número de tiradas necesarias.
    public static void ejercicio11() {
        Random rand = new Random();
        int dado1;
        int dado2;
        int tiradas;
        tiradas = 0;
        do {
            dado1 = rand.nextInt(6) + 1;
            dado2 = rand.nextInt(6) + 1;
            tiradas++;
        } while ( dado1 != dado2 );
        System.out.println("Se necesitó " + tiradas + " tiradas hasta que ambos dados coincidieron");
    }

    /*
    Ejercicio 12:
    Escribir un programa que sirva como asistente para un juego de rol. Pedir el número de dados y el número de caras, y mostrar cada tirada.
    */
    // 1º- Pido el número de dados y de caras.
    // 2º- Genero cada tirada con un bucle y muestro los resultados.
    public static void ejercicio12() {
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();
        int numDados;
        int numCaras;
        System.out.print("Número de dados: ");
        numDados = teclado.nextInt();
        System.out.print("Número de caras de los dados: ");
        numCaras = teclado.nextInt();
        for ( int i = 1 ; i <= numDados ; i++ ) {
            int tirada;
            tirada = rand.nextInt(numCaras) + 1;
            System.out.println("Dado " + i + ": " + tirada);
        }
    }

    /*
    Ejercicio 13:
    Modificar el programa anterior para que no admita dados con un número de caras impares.
    */
    // 1º- Pido el número de dados.
    // 2º- Pido el número de caras y verifico que sea par, repitiendo si es impar.
    // 3º- Muestro los resultados de cada tirada.
    public static void ejercicio13() {
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();
        int numDados;
        int numCaras;
        System.out.print("Número de dados: ");
        numDados = teclado.nextInt();
        do {
            System.out.print("Número de caras (debe ser par): ");
            numCaras = teclado.nextInt();
            if ( numCaras % 2 != 0 ) {
                System.out.println("Número de caras inválido. Debe ser par.");
            }
        } while ( numCaras % 2 != 0 );
        for ( int i = 1 ; i <= numDados ; i++ ) {
            int tirada;
            tirada = rand.nextInt(numCaras) + 1;
            System.out.println("Dado " + i + ": " + tirada);
        }
    }

    /*
    Ejercicio 14:
    Escribir un programa que pida dos números y genere un número aleatorio comprendido entre ambos.
    */
    // 1º- Pido los dos números.
    // 2º- Calculo el mínimo y máximo.
    // 3º- Genero un número aleatorio entre ellos.
    public static void ejercicio14() {
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();
        int num1;
        int num2;
        System.out.print("Introduce el primer número: ");
        num1 = teclado.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = teclado.nextInt();
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        int aleatorio;
        aleatorio = rand.nextInt(max - min + 1) + min;
        System.out.println("Número aleatorio entre " + min + " y " + max + ": " + aleatorio);
    }

    /*
    Ejercicio 15:
    Modificar el ejercicio anterior para que funcione aunque el primer número sea mayor que el segundo.
    */
    // 1º- Determino cuál es el mínimo y cuál el máximo.
    // 2º- Genero un número aleatorio entre el mínimo y el máximo.
    public static void ejercicio15() {
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();
        int num1;
        int num2;
        System.out.print("Introduce el primer número: ");
        num1 = teclado.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = teclado.nextInt();
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        int aleatorio;
        aleatorio = rand.nextInt(max - min + 1) + min;
        System.out.println("Número aleatorio entre " + min + " y " + max + ": " + aleatorio);
    }

    /*
    Ejercicio 16:
    Escribir un programa que genere seis números aleatorios entre 1 y 49.
    */
    // 1º- Genero seis números aleatorios entre 1 y 49.
    // 2º- Imprimo cada número.
    public static void ejercicio16() {
        Random rand = new Random();
        for ( int i = 1 ; i <= 6 ; i++ ) {
            int numero;
            numero = rand.nextInt(49) + 1;
            System.out.println("Número " + i + ": " + numero);
        }
    }

    /*
    Ejercicio 17:
    Escribir un programa que genere una quiniela (15 resultados aleatorios: 1, X o 2).
    */
    // 1º- Genero 15 números aleatorios entre 1 y 3.
    // 2º- Si sale 3, lo muestro como "X".
    public static void ejercicio17() {
        Random rand = new Random();
        for ( int i = 1 ; i <= 15 ; i++ ) {
            int resultado;
            resultado = rand.nextInt(3) + 1;
            if ( resultado == 3 ) {
                System.out.println("Resultado " + i + ": X");
            } else {
                System.out.println("Resultado " + i + ": " + resultado);
            }
        }
    }

    /*
    Ejercicio 18:
    Escribir un programa que genere números aleatorios entre 1 y 1000 hasta que salga 666.
    */
    // 1º- Genero números aleatorios entre 1 y 1000.
    // 2º- Cuento cuántos números se generan hasta que salga 666.
    // 3º- Imprimo el total de números generados.
    public static void ejercicio18() {
        Random rand = new Random();
        int numero;
        int contador;
        contador = 0;
        do {
            numero = rand.nextInt(1000) + 1;
            contador++;
        } while ( numero != 666 );
        System.out.println("Se generaron " + contador + " números hasta que apareció el 666.");
    }

    /*
    Ejercicio 19:
    Escribir un programa que pida un número y muestre sus divisores.
    */

    // 1º- Pido un número al usuario.
    // 2º- Recorro desde 1 hasta el número y muestro los divisores.

    public static void ejercicio19() {

        Scanner teclado = new Scanner(System.in);

        int numero;
        System.out.print("Introduce un número: ");
        numero = teclado.nextInt();
        System.out.println("Divisores de " + numero + ":");
        for ( int i = 1 ; i <= numero ; i++ ) {
            if ( numero % i == 0 ) {
                System.out.println(i);
            }
        }
    }


    /*
    Ejercicio 20:
    Escribir un programa que pida tres números y los muestre ordenados de menor a mayor.
    */

    // 1º- Pido tres números al usuario.
    // 2º- Comparo y ordeno los números.
    // 3º- Imprimo los números ordenados.

    public static void ejercicio20() {

        Scanner teclado = new Scanner(System.in);

        int n1;
        int n2;
        int n3;

        System.out.print("Introduce el primer número: ");
        n1 = teclado.nextInt();

        System.out.print("Introduce el segundo número: ");
        n2 = teclado.nextInt();

        System.out.print("Introduce el tercer número: ");
        n3 = teclado.nextInt();

        int temp;
        if ( n1 > n2 ) {
            temp = n1;
            n1 = n2;
            n2 = temp;

        } if ( n1 > n3 ) {
            temp = n1;
            n1 = n3;
            n3 = temp;

        } if ( n2 > n3 ) {
            temp = n2;
            n2 = n3;
            n3 = temp;
        }

        System.out.println("Números ordenados: " + n1 + ", " + n2 + ", " + n3);
    }


    /*
    Ejercicio 21:
    Escribir un programa que pida un número y calcule si es primo o no.
    */

    // 1º- Pido un número al usuario.
    // 2º- Compruebo si es divisible entre algún número entre 2 y su raíz cuadrada.
    // 3º- Imprimo si es primo o no.

    public static void ejercicio21() {

        Scanner teclado = new Scanner(System.in);

        int numero;
        System.out.print("Introduce un número: ");
        numero = teclado.nextInt();
        boolean esPrimo;
        esPrimo = true;

        if ( numero < 2 ) {
            esPrimo = false;

        } else {

            for ( int i = 2 ; i <= Math.sqrt(numero) ; i++ ) {

                if ( numero % i == 0 ) {
                    esPrimo = false;
                    break;
                }
            }
        }

        if ( esPrimo ) {
            System.out.println(numero + " es primo");

        } else {
            System.out.println(numero + " no es primo");
        }
    }


    /*
    Ejercicio 22:
    Escribir un programa que genere un número primo aleatorio entre 10.000.000 y 50.000.000.
    */
    // 1º- Genero números aleatorios dentro del rango.
    // 2º- Compruebo si son primos.
    // 3º- Repito hasta encontrar uno primo.

    public static void ejercicio22() {

        Random rand = new Random();
        int numero;
        boolean esPrimo;

        do {
            numero = rand.nextInt(50_000_000 - 10_000_000 + 1) + 10_000_000;
            esPrimo = true;

            for ( int i = 2 ; i <= Math.sqrt(numero) ; i++ ) {

                if ( numero % i == 0 ) {
                    esPrimo = false;
                    break;
                }
            }

        } while ( ! esPrimo );
        System.out.println("Número primo aleatorio entre 10.000.000 y 50.000.000: " + numero);
    }


    /*
    Ejercicio 23:
    Escribir un programa que te escriba todos los números primos que hay entre 1 y 100.
    */

    // 1º- Recorro del 2 al 100.
    // 2º- Compruebo si cada número es primo.
    // 3º- Imprimo los números primos.

    public static void ejercicio23() {

        for ( int n = 2 ; n <= 100 ; n++ ) {
            boolean esPrimo = true;

            for ( int i = 2 ; i <= Math.sqrt(n) ; i++ ) {
                if ( n % i == 0 ) {
                    esPrimo = false;
                    break;
                }
            }

            if ( esPrimo ) {
                System.out.println(n);
            }
        }
    }


    /*
    Ejercicio 24:
    Modificar el programa anterior para que el usuario introduzca dos números y se muestren los primos entre ellos.
    */

    // 1º- Pido dos números al usuario.
    // 2º- Recorro el rango entre ambos números.
    // 3º- Imprimo los números primos.

    public static void ejercicio24() {

        Scanner teclado = new Scanner(System.in);

        int inicio;
        int fin;

        System.out.print("Introduce el número inicial: ");
        inicio = teclado.nextInt();

        System.out.print("Introduce el número final: ");
        fin = teclado.nextInt();

        int min = Math.min(inicio, fin);
        int max = Math.max(inicio, fin);

        for ( int n = min ; n <= max ; n++ ) {
            boolean esPrimo = true;

            if ( n < 2 ) {
                esPrimo = false;

            } else {

                for ( int i = 2 ; i <= Math.sqrt(n) ; i++ ) {
                    if ( n % i == 0 ) {
                        esPrimo = false;

                        break;
                    }
                }
            }

            if ( esPrimo ) {
                System.out.println(n);
            }
        }
    }


    /*
    Ejercicio 25:
    Escribir un programa que reciba un número y muestre sucesivamente el resultado de dividirlo por dos hasta llegar a un número menor o igual a 1.
    */

    // 1º- Pido un número al usuario.
    // 2º- Divido sucesivamente entre 2 hasta que sea menor o igual a 1.
    // 3º- Imprimo cada resultado con dos decimales.

    public static void ejercicio25() {

        Scanner teclado = new Scanner(System.in);

        double numero;

        System.out.print("Introduce un número: ");
        numero = teclado.nextDouble();

        System.out.println("Haz introducido el número " + numero);

        while ( numero > 1 ) {
            numero = numero / 2;

            System.out.println(String.format("%.2f", numero));
        }
    }

    /*
    Main para llamar a los ejercicios
    */

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
        // ejercicio16();
        // ejercicio17();
        // ejercicio18();
        // ejercicio19();
        // ejercicio20();
        // ejercicio21();
        // ejercicio22();
        // ejercicio23();
        // ejercicio24();
        // ejercicio25();

    }

}
