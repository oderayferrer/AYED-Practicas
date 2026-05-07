package tp1.ejercicio7;

import java.util.List;

public class Estudiante {

	String nombre;

	public Estudiante(String string) {
		// TODO Auto-generated constructor stub
		this.nombre = string;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + "]";
	}
	

}
