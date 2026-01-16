package empresaSeguros;

// clase Hija Coche (hereda de clase Vehiculo -> extends Vehiculo)

public class Coche extends Vehiculo {
	
	// Hereda atributos de la clase Vehiculo, no son necesarios de incorporar

	
	// 1º. Constructor de Clase Coche (hereda constructor de Clase Vehiculo al igual que Moto)
	
	public Coche(String matricula, int anioFabricacion, Conductor conductorAsociado) {
        super(matricula, anioFabricacion, conductorAsociado);
    }

	
	// 2º- Método toString()
	
    @Override
    public String tipoVehiculo() {
        return "Coche";
    }
}


