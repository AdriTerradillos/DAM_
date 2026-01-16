package empresaSeguros;

// clase Hija Moto (hereda de clase Vehiculo -> extends Vehiculo)

public class Moto extends Vehiculo {
	
	// Hereda atributos de la clase Vehiculo, no son necesarios de incorporar
	
	
	
	// 1º- Constructor de clase Moto hereda el constructor de Clase Vehiculo)
	
	  public Moto(String matricula, int anioFabricacion, Conductor conductorAsociado) {
	        super(matricula, anioFabricacion, conductorAsociado);
	    }
	  
	  
	  
	  // 2º- Genero método String()

	    @Override
	    public String tipoVehiculo() {
	        return "Moto";
	    }

	    
}
