package Modulo_Programacion.Primera_Evaluacion._00_javaBasico.UT3.practicas.boletin01.ejercicios_inidividuales;

public class practica23 {
	
// 		23. Escribir un programa que te escriba todos los números 
//		primos que hay entre el 1 y el 100
	
	
	public static void main(String[] args) {
		
		for (int numero = 2; numero <= 100; numero++ ) {
			boolean isPrimo = true;
			
			
			for(int i = 2; i <= Math.sqrt(numero); i++) {
				if (numero % i == 0) {
					isPrimo = false;
					break;
					
				}
			}
			
			
			if(isPrimo) {
				System.out.println(numero + " ");
			}
			
		}
		
	}
	
}