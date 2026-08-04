package tp5.ejercicio5;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class TestMirrorBank {
	public static void main(String[] args) {
		Graph<Persona> red = new AdjListGraph<>();

		// Personas: (nombre, domicilio, esJubilado, percibioJubilacion)
		Vertex<Persona> emp  = red.createVertex(new Persona("Empleado Ana", "Calle 1", false, false));
		Vertex<Persona> j1   = red.createVertex(new Persona("Jubilado Juan", "Calle 2", true, false));  // dist 1, no cobro
		Vertex<Persona> j2   = red.createVertex(new Persona("Jubilada Rosa", "Calle 3", true, true));   // dist 1, YA cobro
		Vertex<Persona> emp2 = red.createVertex(new Persona("Empleado Beto", "Calle 4", false, false)); // dist 1, no es jubilado
		Vertex<Persona> j3   = red.createVertex(new Persona("Jubilada Alma", "Calle 5", true, false));  // dist 2, no cobro
		Vertex<Persona> j4   = red.createVertex(new Persona("Jubilado Leo", "Calle 6", true, false));   // dist 3, no cobro

		// Red de conocidos (desde el empleado hacia afuera)
		red.connect(emp, j1);    // Ana - Juan   (dist 1)
		red.connect(emp, j2);    // Ana - Rosa   (dist 1)
		red.connect(emp, emp2);  // Ana - Beto   (dist 1)
		red.connect(j1, j3);     // Juan - Alma  (dist 2)
		red.connect(j3, j4);     // Alma - Leo   (dist 3)

		MirrorBank banco = new MirrorBank();
		System.out.println("1. hasta dist 2: " + banco.jubiladosCercanos(red, emp, 2));
		System.out.println("2. hasta dist 1: " + banco.jubiladosCercanos(red, emp, 1));
		System.out.println("3. hasta dist 0: " + banco.jubiladosCercanos(red, emp, 0));
	}
}
