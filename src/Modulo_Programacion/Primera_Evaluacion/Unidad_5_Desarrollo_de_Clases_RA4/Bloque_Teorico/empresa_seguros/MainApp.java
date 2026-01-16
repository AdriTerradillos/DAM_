package empresaSeguros;

public class MainApp {

	public static void main(String[] args) {
		
		// F1
		
		Conductor fernandoAlonso = new Conductor("Fernando", "Alonso", "01010101A", 1981, 12, 1999);
		Conductor maxVerstappen = new Conductor("Max", "Verstappen", "02020202M", 1997, 12, 2015);
		Conductor landoNorrie = new Conductor("Lando", "Norrie", "03030303L", 1999, 11, 2018);
		
		// Moto GP
		
		Conductor markMarquez = new Conductor("Mark", "Márquez","04040404M", 1993, 12, 2018);
		Conductor valentinoRossi = new Conductor("Valentino", "Rossi", "05050505V", 1979, 10, 1999);
		Conductor pedroAcosta = new Conductor("Pedro", "Acosta", "06060606P", 2004, 11 , 2022);
		
		
		// Monoplaza F1
		
		Vehiculo maclaren = new Coche("F-3476LNR", 1963, landoNorrie);
		Vehiculo redBull = new Coche("F-2753MVN", 1987,  maxVerstappen);
		Vehiculo astonMartin = new Coche("F-6833FAO", 1913, fernandoAlonso);
		
		// Monoplaza Moto GP
		
		Vehiculo KTM = new Moto("M-5673PAA", 1934, pedroAcosta);
		Vehiculo Yamaha = new Moto("M-6941VRI", 1955, valentinoRossi);
		Vehiculo Ducatti = new Moto("M-2599MMZ", 1926, markMarquez);
		
		 
		// F1 (la clase Coche apunta directamente a la clase que hereda, Vehículo)
		System.out.println(maclaren);
		System.out.println(redBull);
		System.out.println(astonMartin);
		
		
		// Moto GP (la clase Moto apunta directamente a la clase que hereda, Vehiculo, igual que el caso anterior)
		System.out.println(KTM);
		System.out.println(Yamaha);
		System.out.println(Ducatti);
		
	}

}
