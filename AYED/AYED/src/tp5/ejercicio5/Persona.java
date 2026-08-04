package tp5.ejercicio5;

public class Persona {
	private String nombre;
	private String domicilio;
	private boolean esJubilado;          // true = jubilado, false = empleado del banco
	private boolean percibioJubilacion;  // solo tiene sentido si esJubilado

	public Persona(String nombre, String domicilio, boolean esJubilado, boolean percibioJubilacion) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.esJubilado = esJubilado;
		this.percibioJubilacion = percibioJubilacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public boolean esJubilado() {
		return esJubilado;
	}

	public boolean percibioJubilacion() {
		return percibioJubilacion;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
