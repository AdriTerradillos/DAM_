package Primera_Evaluacion.UT4.Estructuras_Datos.teoria.ejemplos;

import java.util.Scanner;

public class ejemploPrueba00 {

    // public class buscaMinas {
        public static void main(String[] args) {
/*
8. EJERCICIO CON FORMATO DE EXAMEN
Vamos a hacer una implementación del juego del buscaminas y lo
primero es preparar el
tablero. Genera un array de dos dimensiones de 5 filas por 5
columnas. El tablero
tendrá 5 minas que se colocaran de forma aleatoria en cinco
posiciones del array. Las
minas se representarán con un 1 y las posiciones sin mina con un 0.
Al final dibuja el
tablero de esta forma:
0 0 0 0 0
0 0 1 0 0
0 0 1 0 1
0 0 0 0 0
1 1 0 0 0
Modifica tu programa para que le puedas decir por teclado el tamaño
del tablero de
juego (siempre será cuadrado, así que solo le dirás un número
entero) y el número de
minas. Comprueba que no se pueden poner mas minas que las
posiciones del tablero
(en un tablero de 3x3 no puede haber 10 minas, por ejemplo
*/
/*
1o- genero un array de 2 dimensiones (filas y columnas)
2o- la posición de la mina será aleatoria (math.random())
3o- en caso de que la mina se acople a un mismo resultado, no
se podrá acoplar (ya esta completa)
*/

// genero un array bidimensional con 5 filas y 5 columnas
// final static int MINA = 1;
            int lado = 3;
            int minas = 8;
            boolean correcto = false;
// mejor opción --> generar Scanner fuera de do para tenerlo
// como referencia en todo el código (sin importar las llaves)

            Scanner teclado = new Scanner(System.in);

            // generamos do-while --> comprobar que el programa
            // funcione correctamente al ingresar minas

            do {
                try {
                    System.out.println("De cuántos lados es el tablero?: ");
                    lado = teclado.nextInt();
                    System.out.println("Cuántas minas vas a poner?: ");
                    minas = teclado.nextInt();

                    // generamos condicional if
                    if (minas < lado * lado) {
                        correcto = true;
                        System.out.println("El numero de minas ingresada es correcto");

                    } else {
                        System.out.println("No puedo poner " + minas + " minas en un tablero 16 casillas");

                    }

                    // en caso de ingresar cualquier valordistinto de entero, salta el catch y vuelve a empezar
                } catch (Exception e) {
                    System.out.println("No has metido un número entero");
                }
            }

            while (correcto == false);

            int[][] tablero = new int[lado][lado];

            teclado.close();

            // creo variables nuevas y las acoplo el valor de tablero
            colocarMinas(tablero, lado,minas);// invocación (hacemos llamamiento, lo definiremos abajo)
            mostrarTablero(tablero, lado); // invocación (hacemosllamamiento, lo definiremos abajo)

        }


    // definición (tomamos el valor que hemos llamado arriba, genero una clase paralela
    // de 'mostrarTablero()')

    public static void mostrarTablero(int[][] tablero, int lado) {

            for (int j = 0; j < 5; j++) { // j --> valor de fila

                for (int i = 0; i < 5; i++) // i --> valor de la columna
                    // de esta forma los valores aleatorios se posicionan en filas y columnas dentro del tablero
                    System.out.print(tablero[j][i] + " ");


                // System.out.println(tablero[i][j] + " "); de esta forma losvalores aleatorios se posicionan
                // únicamente en las columnas del tablero

                System.out.println();
            }
        }

    // definición (tomamos el valor que hemos llamado arriba, generouna clase paralela
    // de 'colocarMinas()')

        public static void colocarMinas(int[][] tablero, int lado, int minas) {
            int numMinas = 0; // contador para conteo de posición de cadamina ingresada
            // en el tablero

            // while --> acabamos de ingresar una mina anteriormente, solo puedo ingresar
            // 4 ahora en tablero

            while (numMinas != minas) {

            // pedimos valores aleatorios dentro del while de las variables
            // fila & columna

                int fila = (int) (Math.random() * 5);
                int columna = (int) (Math.random() * 5);

            // anido condicional if para terminar de generar minas una vez
            // completamos las 4 restantes

                if (tablero[fila][columna] == 0) {
                    tablero[fila][columna] = 1;
                    numMinas++;
                }
            }
        }
    }

