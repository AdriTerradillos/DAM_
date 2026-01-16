package empresaSeguros;

public abstract class Vehiculo {
	
	
	// 1º- atributos propios de clases Moto y Coche (protected para poder ser llamadas en dichas clases)
	
	protected String matricula;
    protected int anioFabricacion;
    protected Conductor conductorAsociado;

    
    // 2º- Constructor de la Clase Vehiculo (utilizado por Clase Coche y Moto)
    
    public Vehiculo(String matricula, int anioFabricacion, Conductor conductorAsociado) {
        this.matricula = matricula;
        this.anioFabricacion = anioFabricacion;
        this.conductorAsociado = conductorAsociado;
    }

    
    // getter y setter de atributo indispensable, 'conductorAsociado'
    
    public Conductor getConductorAsociado() {
		return conductorAsociado;
	}
    
	public void setConductorAsociado(Conductor conductorAsociado) {
		this.conductorAsociado = conductorAsociado;
	}
    
    
	
	// genero una clase Abstracta en clase Vehiculo para ser empleada por sus clses Heredadas (Coche y Moto) en MainApp
    
	public abstract String tipoVehiculo();


    // Método toString() para mostrar resultados por pantalla a través de 'mainApp'
    
    @Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", anioFabricacion=" + anioFabricacion + ", conductorAsociado="
				+ conductorAsociado + "]";
	}
    
    
    
}


