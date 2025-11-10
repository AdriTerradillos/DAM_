package Primera_Evaluacion.Practicas.boletin07.general;

import java.util.Random;
import java.util.Scanner;

public class boletin07 {

    public static void main(String[] args) {

        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
    }


    /*
       1. Vamos a hacer una pequeña calculadora. Solicita dos números al usuario y luego que
       escriba la operación que quiere hacer (S para suma, R para resta, M para multiplicar y D para dividir).
       Realiza la operación con un switch.
    */

        // 1º- Pido al usuario dos números enteros.
        // 2º- Pido también una letra indicando la operación deseada.
        // 3º- Uso un switch para decidir qué operación realizar.
        // 4º- Muestro el resultado según la operación.


    public static void ejercicio1() {
        System.out.println("*** Ejercicio 1 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double num1 = teclado.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double num2 = teclado.nextDouble();

        System.out.print("Introduce la operación (S= Suma, R= Resta, M= Multiplicar, D= Dividir): ");
        char operacion = teclado.next().toUpperCase().charAt(0);

        double resultado = 0;

        switch (operacion) {
            case 'S':
                resultado = num1 + num2;
                break;
            case 'R':
                resultado = num1 - num2;
                break;
            case 'M':
                resultado = num1 * num2;
                break;
            case 'D':

                if (num2 != 0)
                    resultado = num1 / num2;
                else
                    System.out.println("Error: no se puede dividir entre cero.");
                break;
            default:
                System.out.println("Operación no válida.");
                return;
        }

        System.out.println("El resultado es: " + resultado);

        System.out.println("\nFin del ejercicio");
        System.out.println();
    }


    /*
     2. Incluye operaciones adicionales (raíz cuadrada, cuadrado, cubo, por ejemplo)
    */

        // 1º- Pido un número al usuario.
        // 2º- Pido una letra que indique la operación: R=raíz cuadrada, C=cuadrado, U=cubo.
        // 3º- Uso un switch para decidir la operación.
        // 4º- Muestro el resultado.


    public static void ejercicio2() {

        System.out.println("*** Ejercicio 2 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        double num = teclado.nextDouble();

        System.out.print("Elige operación (R=Raíz cuadrada, C=Cuadrado, U=Cubo): ");
        char op = teclado.next().toUpperCase().charAt(0);

        double resultado = 0;

        switch (op) {
            case 'R':
                resultado = Math.sqrt(num);
                break;
            case 'C':
                resultado = Math.pow(num, 2);
                break;
            case 'U':
                resultado = Math.pow(num, 3);
                break;
            default:
                System.out.println("Operación no válida.");
                return;
        }

        System.out.println("El resultado es: " + resultado);

        System.out.println("\nFin del programa");
        System.out.println();

    }


    /*
     3. Pide al usuario un número del 1 al 12 y muestra el nombre del mes correspondiente.
     Muestra un error si el número no se corresponde con ningún mes.
    */

        // 1º- Pido un número del 1 al 12.
        // 2º- Uso un switch para asociar el número con un mes.
        // 3º- Si no está entre 1 y 12, muestro mensaje de error.


    public static void ejercicio3() {

        System.out.println("*** Ejercicio 3 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número del 1 al 12: ");
        int mes = teclado.nextInt();

        String nombreMes;
        switch (mes) {
            case 1: nombreMes = "Enero"; break;
            case 2: nombreMes = "Febrero"; break;
            case 3: nombreMes = "Marzo"; break;
            case 4: nombreMes = "Abril"; break;
            case 5: nombreMes = "Mayo"; break;
            case 6: nombreMes = "Junio"; break;
            case 7: nombreMes = "Julio"; break;
            case 8: nombreMes = "Agosto"; break;
            case 9: nombreMes = "Septiembre"; break;
            case 10: nombreMes = "Octubre"; break;
            case 11: nombreMes = "Noviembre"; break;
            case 12: nombreMes = "Diciembre"; break;
            default:
                nombreMes = "Error: número fuera de rango.";
                break;
        }

        System.out.println(nombreMes);

        System.out.println("\nFin del ejercicio");
        System.out.println();

    }


    /*
      4. Solicita una nota entre el 1 y el 10 (sin decimales) y devuelve la calificación según la escala.
    */

        // 1º- Pido una nota del 1 al 10.
        // 2º- Uso un switch para asignar la calificación correspondiente.
        // 3º- Muestro la calificación en texto.

    public static void ejercicio4() {

        System.out.println("*** Ejercicio 4 ***");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce una nota (1-10): ");
        int nota = teclado.nextInt();

        String calificacion;
        switch (nota) {
            case 1: case 2:
                calificacion = "Muy deficiente"; break;
            case 3: case 4:
                calificacion = "Insuficiente"; break;
            case 5:
                calificacion = "Suficiente"; break;
            case 6:
                calificacion = "Bien"; break;
            case 7: case 8:
                calificacion = "Notable"; break;
            case 9: case 10:
                calificacion = "Sobresaliente"; break;
            default:
                calificacion = "Error: nota fuera de rango."; break;
        }

        System.out.println("Calificación: " + calificacion);

        System.out.println("\nFin del ejercicio");
        System.out.println();

    }


    /*
       5. Pide al usuario un número y crea un array de enteros de tantas posiciones como indique.
       Rellénalo con números aleatorios entre 10 y 1000 y muestra el máximo, mínimo y media.
    */

        // 1º- Pido al usuario un tamaño de array.
        // 2º- Creo un array con esa longitud.
        // 3º- Lo lleno con números aleatorios entre 10 y 1000.
        // 4º- Recorro el array para calcular máximo, mínimo y media.
        // 5º- Muestro los resultados con dos decimales.


    public static void ejercicio5() {

        System.out.println("*** Ejercicio 5 ***");

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Introduce el tamaño del array: ");
        int n = teclado.nextInt();
        int[] numeros = new int[n];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double suma = 0;

        for (int i = 0; i < n; i++) {
            numeros[i] = random.nextInt(991) + 10;

            if (numeros[i] > max) max = numeros[i];
            if (numeros[i] < min) min = numeros[i];
            suma += numeros[i];
        }

        double media = suma / n;
        System.out.printf("Máximo: %d | Mínimo: %d | Media: %.2f%n", max, min, media);

        System.out.println("\nFin del ejercicio");
        System.out.println();

    }


    /*
       6. Muestra además en qué posición del array están el máximo y el mínimo (todas si se repiten)
    */

        // 1º- Reutilizo la lógica del ejercicio 5.
        // 2º- Recorro el array otra vez para guardar las posiciones donde están max y min.
        // 3º- Muestro todas las posiciones encontradas.


    public static void ejercicio6() {

        System.out.println("*** Ejercicio 6 ***");

        Scanner teclado = new Scanner(System.in);

        Random random = new Random();

        System.out.print("Introduce el tamaño del array: ");
        int n = teclado.nextInt();
        int[] numeros = new int[n];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double suma = 0;

        for (int i = 0; i < n; i++) {
            numeros[i] = random.nextInt(991) + 10;

            if (numeros[i] > max) max = numeros[i];
            if (numeros[i] < min) min = numeros[i];
            suma += numeros[i];
        }

        double media = suma / n;

        System.out.printf("Máximo: %d | Mínimo: %d | Media: %.2f%n", max, min, media);
        System.out.print("Posiciones del máximo: ");

        for (int i = 0; i < n; i++) if (numeros[i] == max) System.out.print(i + " ");
        System.out.println();
        System.out.print("Posiciones del mínimo: ");

        for (int i = 0; i < n; i++) if (numeros[i] == min) System.out.print(i + " ");
        System.out.println();

        System.out.println("\nFin ejercicio");
        System.out.println();
    }

    /*
       7. Crea un array aleatorio y pide una posición al usuario para mostrar el valor o error si no existe.
    */

        // 1º- Pido al usuario el tamaño del array.
        // 2º- Lo relleno con números aleatorios entre 10 y 1000.
        // 3º- Pido una posición al usuario.
        // 4º- Compruebo con un if si la posición está dentro del rango.
        // 5º- Si es válida, muestro el valor; si no, muestro un error.


    public static void ejercicio7() {

        System.out.println("*** Ejercicio 7 ***");

        Scanner teclado = new Scanner(System.in);

        Random random = new Random();

        System.out.print("Introduce el tamaño del array: ");
        int n = teclado.nextInt();
        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            numeros[i] = random.nextInt(991) + 10;
        }

        System.out.print("Introduce la posición a consultar: ");
        int pos = teclado.nextInt();

        if (pos >= 0 && pos < n) {
            System.out.println("El valor en la posición " + pos + " es: " + numeros[pos]);

        } else {
            System.out.println("Error: posición fuera del rango del array.");
        }

        System.out.println("\nFin del ejercicio");
        System.out.println();
    }

    /*
       8. Implementa el tablero del juego del buscaminas (5x5 con 5 minas aleatorias).
    */

        // 1º- Creo un array bidimensional de 5x5.
        // 2º- Coloco 5 minas (representadas con 1) en posiciones aleatorias.
        // 3º- Me aseguro de que no se repitan posiciones de mina.
        // 4º- Recorro el array y dibujo el tablero.


    public static void ejercicio8() {

        System.out.println("*** Ejercicio 8 ***");

        int[][] tablero = new int[5][5];
        Random random = new Random();

        int minasColocadas = 0;

        while (minasColocadas < 5) {
            int fila = random.nextInt(5);
            int col = random.nextInt(5);

            if (tablero[fila][col] == 0) {
                tablero[fila][col] = 1;
                minasColocadas++;
            }
        }

        System.out.println("Tablero del buscaminas:");
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + " ");
            }

            System.out.println();
        }


        System.out.println("\nFin del ejercicio");
        System.out.println();
    }


}
