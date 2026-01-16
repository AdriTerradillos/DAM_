package Modulo_Programacion.Primera_Evaluacion._00_javaBasico.Practicas.boletin09.general;

import java.util.Scanner;

public class boletin09 {



    /*
    Ejercicio 1 - Enunciado literal:

        Se denominan números amigos a dos números naturales diferentes relacionados de tal manera que
        la suma de los divisores propios de cada uno es igual al otro número.
        Un divisor propio es un factor positivo distinto del número.
        Escribe una función que reciba dos números y devuelva un booleano indicando si son amigos.
*/

        /*
        estructuración ejercicio 1:
            1. Crear función que calcule la suma de divisores propios de un número.
            2. Para comprobar si son amigos:
                - sumaDivisores(a) == b
                - sumaDivisores(b) == a
            3. Devolver true o false.
        */

    public static void ejercicio1() {

        System.out.println("*** Ejercicio 1 ***");
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce primer número: ");
        int primerNum = teclado.nextInt();

        System.out.print("Introduce segundo número: ");
        int segundoNum = teclado.nextInt();

        if (sonAmigos(primerNum, segundoNum))
            System.out.println("Son números amigos.");
        else
            System.out.println("No son números amigos.");


        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
    }


    // apoyo ejercicio1()

    public static boolean sonAmigos(int primerNum, int segundoNum) {
        if (primerNum == segundoNum) return false; // deben ser distintos
        return sumaDivisoresPropios(primerNum) == segundoNum && sumaDivisoresPropios(segundoNum) == primerNum;


    }

    public static int sumaDivisoresPropios(int n) {
        int suma = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) suma += i;
        }
        return suma;

    }



    /*
    Ejercicio 2:

    Un número perfecto es un entero positivo igual a la suma de sus divisores propios positivos.
    Escribe una función que reciba un número y devuelva true/false indicando si es perfecto.
    El número debe recogerse por teclado y si no es entero positivo, informar y pedir otro.
    Usa excepciones.
*/

        /*
        estructuración ejercicio 2:
        1. Pedir número dentro de un bucle.
        2. Capturar excepciones (NumberFormatException).
        3. Validar que es positivo.
        4. Llamar a la función esPerfecto(n).
        5. Mostrar resultado.
        */

    public static void ejercicio2() {

        System.out.println("*** Ejercicio 2 ***");
        Scanner teclado = new Scanner(System.in);

        int contador = -1;

        while (true) {

            try {
                System.out.print("Introduce un número entero positivo: ");
                contador = Integer.parseInt(teclado.nextLine());
                if (contador <= 0) {
                    System.out.println("Debe ser positivo.");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número entero positivo.");
            }
        }

        if (esPerfecto(contador))
            System.out.println("El número " + contador + " es perfecto.");
        else
            System.out.println("El número " + contador + " NO es perfecto.");


        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
    }


    // apoyo ejercicio2()
    public static boolean esPerfecto(int contador) {
        if (contador <= 0)
            return false;

        return sumaDivisoresPropios(contador) == contador;


    }



    /*
    Ejercicio 3: números abundantes

    Un número abundante es aquel cuya suma de divisores propios es mayor que el propio número.
    Escribe una función que reciba dos números y muestre todos los abundantes entre ellos.
    */

        /*
        estructuración ejercicio 3:
        1. Crear función esAbundante(n) -> sumaDivisoresPropios(n) > n.
        2. Recorrer desde min(a,b) hasta max(a,b).
        3. Si es abundante → imprimirlo.
        */

    public static void ejercicio3() {

        System.out.println("*** Ejercicio 3 ***");
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce primer número: ");
        int primerNum = teclado.nextInt();

        System.out.print("Introduce segundo número: ");
        int segundoNum = teclado.nextInt();

        int inicio = Math.min(primerNum, segundoNum);
        int fin = Math.max(primerNum, segundoNum);

        System.out.println("Números abundantes entre " + inicio + " y " + fin + ":");

        for (int i = inicio; i <= fin; i++) {
            if (esAbundante(i)) System.out.print(i + " ");
        }


        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
    }

    // apoyo ejercicio3()
    public static boolean esAbundante(int n) {
        return sumaDivisoresPropios(n) > n;
    }



    /*
    Ejercicio 4:

    Un número defectivo es un número para el que la suma de divisores propios es menor que el número.
    Escribe una función que reciba dos números y muestre todos los defectivos entre ellos.
    */

        /*
        estructuración ejercicio 4:
        1. Crear función esDefectivo(n) → sumaDivisoresPropios(n) < n.
        2. Recorrer intervalo.
        3. Imprimir los números defectivos.
        */


    public static void ejercicio4() {

        Scanner teclado = new Scanner(System.in);
        System.out.println("*** Ejercicio 4 ***");
        System.out.print("Introduce primer número: ");
        int a = teclado.nextInt();

        System.out.print("Introduce segundo número: ");
        int b = teclado.nextInt();

        int inicio = Math.min(a, b);
        int fin = Math.max(a, b);

        System.out.println("Números defectivos entre " + inicio + " y " + fin + ":");
        for (int i = inicio; i <= fin; i++) {
            if (esDefectivo(i)) System.out.print(i + " ");
        }

        System.out.println("\nFin del ejercicio");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

    }


    // apoyo ejercicio4()

    public static boolean esDefectivo(int n) {
        return sumaDivisoresPropios(n) < n;
    }

    public static void mostrarDefectivosEntre(int a, int b) {

        int inicio = Math.min(a, b);
        int fin = Math.max(a, b);

        System.out.println("Números defectivos entre " + inicio + " y " + fin + ":");
        for (int i = inicio; i <= fin; i++) {
            if (esDefectivo(i)) System.out.print(i + " ");
        }

        System.out.println();
    }




    // aquí llamamiento de los ejercicios a través del main()

    public static void main(String[] args) {

        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();

    }
}
