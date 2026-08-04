package tp5.ejercicio4;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class TestOslo {
	public static void main(String[] args) {
		// El mini-mapa "traicionero": el primer adyacente encuentra el destino,
		// y el segundo (C, callejon sin salida) intentaba pisar el exito.
		Graph<String> g = new AdjListGraph<>();
		Vertex<String> ayun = g.createVertex("Ayuntamiento");
		Vertex<String> b = g.createVertex("B");
		Vertex<String> c = g.createVertex("C");
		Vertex<String> museo = g.createVertex("MuseoVikingo");
		g.connect(ayun, b, 1);     // Ayuntamiento -> B (1 min)
		g.connect(ayun, c, 1);     // Ayuntamiento -> C (1 min)
		g.connect(b, museo, 1);    // B -> MuseoVikingo (1 min)
		g.connect(c, museo, 5);    // C -> MuseoVikingo (5 min)

		VisitaOslo visita = new VisitaOslo();
		List<String> sinRestricciones = new ArrayList<>();
		List<String> sinB = List.of("B");

		System.out.println("1. sin restricciones, 10 min:  "
				+ visita.paseoEnBici(g, "MuseoVikingo", 10, sinRestricciones));
		System.out.println("2. sin pasar por B, 10 min:    "
				+ visita.paseoEnBici(g, "MuseoVikingo", 10, sinB));
		System.out.println("3. sin pasar por B, 3 min:     "
				+ visita.paseoEnBici(g, "MuseoVikingo", 3, sinB));
		System.out.println("4. destino inexistente:        "
				+ visita.paseoEnBici(g, "Narnia", 10, sinRestricciones));
	}
}
