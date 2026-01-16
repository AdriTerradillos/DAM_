package empresaSeguros;

public class Conductor {
	
	// 1º- atributos de clase Conductor
	
	private String nombre;
	private String apellido;
	private String nif;
	private int anioNacimiento;
	private int puntosCarnet;
	private int anioCarnet;
	
	
	// 2º- Genero el contructor de la clase Conductor
	
	public Conductor(String nombre, String apellido, String nif, int anioNacimiento, int puntosCarnet, int anioCarnet) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nif = nif;
		this.anioNacimiento = anioNacimiento;
		this.puntosCarnet = puntosCarnet;
		this.anioCarnet = anioCarnet;
	}

	

	// 3º- genero ahora los getters y setters de la clase Conductor
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}


	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}


	public int getPuntosCarnet() {
		return puntosCarnet;
	}

	public void setPuntosCarnet(int puntosCarnet) {
		this.puntosCarnet = puntosCarnet;
	}


	public int getAnioCarnet() {
		return anioCarnet;
	}

	public void setAnioCarnet(int anioCarnet) {
		this.anioCarnet = anioCarnet;
	}

	
	// método toString()  para mostrar resultados por pantalla a través de 'mainApp'
	
	@Override
	public String toString() {
		return "Conductor [nombre=" + nombre + ", apellido=" + apellido + ", nif=" + nif + ", anioNacimiento="
				+ anioNacimiento + ", puntosCarnet=" + puntosCarnet + ", anioCarnet=" + anioCarnet + "]";
	}
	
	
	
	

}
