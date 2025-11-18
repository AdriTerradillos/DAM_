package Primera_Evaluacion.Practicas.boletin03;

import java.util.Scanner;

public class practica01_ {
	
	
	public static void main(String[] args) {
		
		
		/*
		 Estructura:
		 clase Scanner
		 imprimir mensaje al usuario + esperar respuesta
		 condicional if con método .equals / .compareTo
		 
		 */
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println(" Escribe tu contraseña: ");
		String password = teclado.nextLine();
		
		System.out.println(" Escribe nuevamente la contraseña: ");
		String copyPassword = teclado.nextLine();
		
//		comenzamos con el condicional if
		if (password.equals(copyPassword)) {
			System.out.println(" La contraseña es correcta. ¡Felicidades!");
			
		} else
			System.out.println(" La contraseña es incorrecta. Intentalo de nuevo.");
		}
		
		
		
	}
