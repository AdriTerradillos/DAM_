package Primera_Evaluacion.Practicas.boletin02.general;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.text.DecimalFormat;
import java.util.Random;


public class boletin02__ {

    /*
    Ejercicio 1:
    Escribir un programa que nos pida tres palabras por teclado en cualquier orden
    y nos las muestre en pantalla ordenadas alfabéticamente en orden ascendente.
    */

    public static void ejercicio1() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Hoy voy a pedir tres palabras y mostrarlas en orden alfabético ascendente:");
        String[] palabras = new String[3];

        for(int i=0; i<3; i++) {
            palabras[i] = teclado.nextLine();
        }

        Arrays.sort(palabras);
        System.out.println("Palabras ordenadas ascendentemente:");

        for(String palabra : palabras) {
            System.out.println(palabra);
        }
    }

    /*
    Ejercicio 2:
    Idem al anterior pero ordenando ahora en orden descendente.
    */

    public static void ejercicio2() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Hoy voy a pedir tres palabras y mostrarlas en orden alfabético descendente:");
        String[] palabras = new String[3];

        for(int i=0; i<3; i++) {
            palabras[i] = teclado.nextLine();
        }

        Arrays.sort(palabras, Collections.reverseOrder());

        System.out.println("Palabras ordenadas descendentemente:");

        for(String palabra : palabras) {
            System.out.println(palabra);
        }
    }

    /*
    Ejercicio 3:
    Escribir un programa que pida un número por teclado al usuario que simule ser
    el precio de un artículo y escriba el resultado de aplicarle el IVA del 21%.
    El resultado debe de estar redondeado a dos decimales.
    */

    public static void ejercicio3() {

        Scanner teclado = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.print("Introduce el precio del artículo: ");

        double precio = teclado.nextDouble();
        double precioConIVA = precio * 1.21;

        System.out.println("Precio con IVA: " + df.format(precioConIVA));
    }

    /*
    Ejercicio 4:
    Escribir un programa que nos pida por teclado dos calificaciones numéricas
    de un alumno y nos muestre la media aritmética resultante redondeada sin decimales.
    Las notas introducidas deben de estar entre 0 y 10 y admiten decimales.
    Caso de que una entrada sea errónea debería de advertirnos de ello y no hacer el cálculo.
    */

    public static void ejercicio4() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce la primera calificación (0-10): ");
        double nota1 = teclado.nextDouble();

        System.out.print("Introduce la segunda calificación (0-10): ");
        double nota2 = teclado.nextDouble();

        if(nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            System.out.println("Entrada errónea. Las notas deben estar entre 0 y 10.");

        } else {
            int media = (int)Math.round((nota1 + nota2) / 2);
            System.out.println("La media redondeada es: " + media);
        }
    }

    /*
    Ejercicio 5:
    Escribir un programa que nos pida las notas obtenidas en un trimestre y nos muestre
    la media ponderada sabiendo que;

/*
    1. La primera nota corresponde al trabajo en clase y cuenta como un 5% del total
    2. La segunda corresponde a los ejercicios prácticos: 15%
    3. La tercera la nota del examen: 80%
    El resultado debería de mostrarse de dos formas: redondeado con dos decimales
    (nota real) y sin redondear sin decimales (nota de boletín).
*/

    public static void ejercicio5() {

        Scanner teclado = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.print("Nota trabajo en clase (5%): ");

        double trabajo = teclado.nextDouble();
        System.out.print("Nota ejercicios prácticos (15%): ");

        double ejercicios = teclado.nextDouble();
        System.out.print("Nota examen (80%): ");

        double examen = teclado.nextDouble();
        double media = trabajo * 0.05 + ejercicios * 0.15 + examen * 0.80;

        int mediaBoletin = (int)media;
        System.out.println("Media real: " + df.format(media));
        System.out.println("Media boletín: " + mediaBoletin);
    }


    /*
    Ejercicio 6:
    Modifica el ejercicio anterior para que la nota del boletín se redondee
    matemáticamente si es superior a 5 pero se trunquen los decimales si es inferior a 5.
    */

    public static void ejercicio6() {

        Scanner teclado = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.print("Nota trabajo en clase (5%): ");

        double trabajo = teclado.nextDouble();
        System.out.print("Nota ejercicios prácticos (15%): ");

        double ejercicios = teclado.nextDouble();
        System.out.print("Nota examen (80%): ");

        double examen = teclado.nextDouble();
        double media = trabajo * 0.05 + ejercicios * 0.15 + examen * 0.80;

        int mediaBoletin = (media >= 5) ? (int)Math.round(media) : (int)media;
        System.out.println("Media real: " + df.format(media));
        System.out.println("Media boletín: " + mediaBoletin);
    }

    /*
    Ejercicio 7:
    Escribir un programa que pida un número por teclado y nos imprima la tabla de
    multiplicar de dicho número del 1 al 10.
    */

    public static void ejercicio7() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int n = teclado.nextInt();

        for(int i=1; i<=10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    /*
    Ejercicio 8:
    Escribe un programa que pida un número por teclado y escriba todos sus divisores
    separados por comas (sin coma final).
    */

    public static void ejercicio8() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int n = teclado.nextInt();

        System.out.print("Divisores del número " + n + ": ");
        for(int i=1; i<=n; i++) {

            if(n % i == 0) {

                if (i < n) {
                    System.out.print(i + ", ");

                } else {
                    System.out.print(i);
                }
            }
        }
        System.out.println();
    }

    /*
    Ejercicio 9:
    Escribir un programa que pida números entre el 1 y el 100 por teclado hasta que
    escribamos la palabra FIN (con mayúsculas). Se mostrará un mensaje de error
    para entradas inválidas y al finalizar se mostrará el número de entradas válidas.
    */

    public static void ejercicio9() {

        Scanner teclado = new Scanner(System.in);
        int contador = 0;

        while(true) {
            System.out.print("Introduce un número (1-100) o FIN: ");
            String entrada = teclado.next();

            if(entrada.equals("FIN")) {
                break;
            }

            try {
                int n = Integer.parseInt(entrada);

                if(n >= 1 && n <= 100) {
                    contador++;
                }

                else {
                    System.out.println("Número fuera de rango");
                }

            } catch(Exception e) {
                System.out.println("Entrada no válida");
            }
        }
        System.out.println("Número de entradas válidas: " + contador);
    }

    /*
    Ejercicio 10:
    Modificar el programa anterior para que nos muestre al final la media aritmética
    de las entradas válidas.
    */

    public static void ejercicio10() {

        Scanner teclado = new Scanner(System.in);

        int contador=0;
        int suma=0;

        while(true){
            System.out.print("Introduce un número (1-100) o FIN: ");
            String entrada = teclado.next();

            if(entrada.equals("FIN")) {
                break;
            }

            try {
                int n = Integer.parseInt(entrada);
                if(n >= 1 && n <= 100) {
                    contador++;
                    suma += n;

                } else {
                    System.out.println("Número fuera de rango");
                }
            } catch(Exception e) {
                System.out.println("Entrada no válida");
            }
        }
        if(contador > 0) {
            System.out.println("Media: " + (double)suma/contador);
        }

        else {
            System.out.println("No se introdujeron números válidos");
        }
    }

    /*
    Ejercicio 11:
    Modificar el programa anterior para que, además, nos diga al final cuál ha sido
    el número mayor y el menor que has introducido.
    */

    public static void ejercicio11() {

        Scanner teclado = new Scanner(System.in);

        int contador = 0;
        int suma = 0;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        while(true) {
            System.out.print("Introduce un número (1-100) o FIN: ");
            String entrada = teclado.next();

            if(entrada.equals("FIN")) {
                break;
            }

            try {
                int n = Integer.parseInt(entrada);
                if(n >= 1 && n <= 100){
                    contador++;
                    suma += n;

                    if(n > mayor) mayor = n;
                    if(n < menor) menor = n;

                } else {
                    System.out.println("Número fuera de rango");
                }

            } catch(Exception e) {
                System.out.println("Entrada no válida");
            }
        }
        if(contador > 0) {
            System.out.println("Media: " + (double)suma / contador);
            System.out.println("Mayor: " + mayor);
            System.out.println("Menor: " + menor);

        } else {
            System.out.println("No se introdujeron números válidos");
        }
    }


    /*
    Ejercicio 12:
    Realiza un juego en el que debes de acertar un número entre el 1 y el 50 que
    el ordenador ha elegido de forma aleatoria. El programa te indicará si has acertado,
    si te has pasado o si te has quedado corto. El programa finaliza cuando se acierta
    o cuando se superan 5 intentos.
    */

    public static void ejercicio12() {

        Scanner teclado = new Scanner(System.in);
        Random rnd = new Random();

        int secreto = rnd.nextInt(50)+1;
        int intentos = 0;
        boolean acertado = false;

        while(intentos < 5 && !acertado) {
            System.out.print("Adivina el número (1-50): ");

            int n = teclado.nextInt();
            intentos++;

            if(n == secreto) {
                System.out.println("¡Acertaste!");
                acertado=true;
            } else if(n > secreto) {
                System.out.println("Te pasaste");
            }
            else {
                System.out.println("Te quedaste corto");
            }
        }

        if(!acertado) {
            System.out.println("Se acabaron los intentos. El número era " + secreto);
        }
    }


    /*
    Ejercicio 13:
    Modifica el programa anterior para que el programa te de todos los intentos
    que necesites pero que cuando aciertes te informe de cuántas veces has fallado
    antes de lograrlo.
    */

    public static void ejercicio13() {

        Scanner teclado = new Scanner(System.in);
        Random rnd = new Random();

        int secreto = rnd.nextInt(50)+1;
        int intentos = 0;
        boolean acertado = false;

        while(!acertado) {
            System.out.print("Adivina el número (1-50): ");

            int n = teclado.nextInt();
            intentos++;

            if(n == secreto) {
                System.out.println("¡Acertaste! Fallaste " + (intentos-1) + " veces antes de acertar.");
                acertado = true;

            } else if(n > secreto) {
                System.out.println("Te pasaste");
            }

            else {
                System.out.println("Te quedaste corto");
            }
        }
    }


    /*
    Ejercicio 14:
    Modifica el programa anterior para que al final del programa te pida si quieres
    volver a jugar y en caso afirmativo comience una nueva partida.
    */

    public static void ejercicio14() {

        Scanner teclado = new Scanner(System.in);
        Random rnd = new Random();

        boolean jugar = true;

        while(jugar) {
            int secreto = rnd.nextInt(50)+1;
            int intentos = 0;
            boolean acertado = false;

            while(!acertado) {
                System.out.print("Adivina el número (1-50): ");

                int n = teclado.nextInt();
                intentos++;

                if(n == secreto) {
                    System.out.println("¡Acertaste! Fallaste " + (intentos-1) + " veces antes de acertar.");
                    acertado = true;

                } else if(n > secreto) {
                    System.out.println("Te pasaste");

                } else {
                    System.out.println("Te quedaste corto");
                }
            }
            System.out.print("¿Quieres volver a jugar? (s/n): ");
            String resp = teclado.next();

            if(!resp.equalsIgnoreCase("s")) {
                jugar = false;
            }
        }
    }

    /*
    Ejercicio 15:
    Modifica el programa anterior para que al iniciar el juego te pida dos parámetros
    con objeto de cambiar la dificultad del juego: el número máximo o el número de intentos posibles.
    */

    public static void ejercicio15() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Número máximo a adivinar: ");
        int max = teclado.nextInt();

        System.out.print("Número máximo de intentos: ");
        int maxIntentos = teclado.nextInt();

        Random rnd = new Random();
        boolean jugar = true;

        while(jugar) {
            int secreto = rnd.nextInt(max) + 1;
            int intentos = 0;
            boolean acertado = false;

            while(intentos < maxIntentos && !acertado) {
                System.out.print("Adivina el número (1-" + max + "): ");
                int n = teclado.nextInt();
                intentos++;

                if(n == secreto) {
                    System.out.println("¡Acertaste! Fallaste " + (intentos - 1) + " veces antes de acertar.");
                    acertado = true;

                } else if(n > secreto) {
                    System.out.println("Te pasaste");
                }

                else {
                    System.out.println("Te quedaste corto");
                }
            }

            if(!acertado) {
                System.out.println("Se acabaron los intentos. El número era " + secreto);
            }

            System.out.print("¿Quieres volver a jugar? (s/n): ");
            String resp = teclado.next();

            if(!resp.equalsIgnoreCase("s")) {
                jugar = false;
            }
        }
    }

    /*
    Ejercicio 16:
    Escribe un programa que pida por teclado el radio de una circunferencia, admitiendo
    valores con decimales y calcule la longitud y el área de la circunferencia (redondeando a cinco decimales).
    */

    public static void ejercicio16() {

        Scanner teclado = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.print("Introduce el radio: ");
        double r = teclado.nextDouble();

        double longitud = 2 * 3.14159 * r;
        double area = 3.14159 * r * r;
        System.out.println("Longitud: " + df.format(longitud));
        System.out.println("Área: " + df.format(area));
    }

    /*
    Ejercicio 17:
    Escribir un programa que reciba por teclado una temperatura en cualquiera de las
    tres unidades básicas (C, F, K) y la devuelva en las otras dos, con dos decimales.
    */

    public static void ejercicio17() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce temperatura con unidad (Ej: 12C, 280K, 98.6F): ");
        String entrada = teclado.next();

        double valor = Double.parseDouble(entrada.substring(0, entrada.length()-1));
        char unidad = entrada.charAt(entrada.length() - 1);

        DecimalFormat df = new DecimalFormat("#.00");
        double C = 0;
        double F = 0;
        double K= 0;

        switch(unidad) {

            case 'C':
                C = valor;
                F = C * 1.8 + 32;
                K = C + 273.15;
                break;

            case 'F':
                F = valor;
                C = (F - 32)/1.8;
                K = C + 273.15;
                break;

            case 'K':
                K = valor;
                C = K - 273.15;
                F = 1.8 * (K - 273.15) +32;
                break;

        }
        System.out.println("Celsius: " + df.format(C));
        System.out.println("Fahrenheit: " + df.format(F));
        System.out.println("Kelvin: " + df.format(K));
    }

    /*
    Ejercicio 18:
    La tabla de tarifas impositivas en España para 2022: Escribe un programa que
    le pida al usuario su sueldo anual y le informe el porcentaje de retención,
    el importe de la misma y el importe neto restante que cobrará.
    */

    public static void ejercicio18() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce sueldo anual: ");
        double sueldo = teclado.nextDouble();

        double porcentaje=0;

        if(sueldo <= 12450) {
            porcentaje = 19;

        } else if(sueldo <= 20200) {
            porcentaje = 24;

        } else if(sueldo <= 35200) {
            porcentaje = 30;

        } else if(sueldo <= 60000) {
            porcentaje = 37;

        } else if(sueldo <= 300000) {
            porcentaje = 45;

        } else {
            porcentaje = 47;
        }

        double retencion = sueldo * porcentaje/100;
        double neto = sueldo - retencion;

        System.out.println("Porcentaje de retención: " + porcentaje + "%");
        System.out.println("Importe retenido: " + retencion);
        System.out.println("Sueldo neto: " + neto);
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
        // ejercicio16();
        // ejercicio17();
        // ejercicio18();
    }
}
