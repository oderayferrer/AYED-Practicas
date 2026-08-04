package tp5.ejercicio3;

import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class TestMapa {
	public static void main(String[] args) {
		Graph<String> g = new AdjListGraph<>();
		Vertex<String> a = g.createVertex("A");
		Vertex<String> b = g.createVertex("B");
		Vertex<String> c = g.createVertex("C");
		Vertex<String> d = g.createVertex("D");
		g.connect(a, b, 2);    // A -> B (2)
		g.connect(b, d, 9);    // B -> D (9)
		g.connect(a, c, 5);    // A -> C (5)
		g.connect(c, b, 1);    // C -> B (1)
		g.connect(a, d, 100);  // A -> D directo, carisimo (100)

		Mapa mapa = new Mapa(g);
		System.out.println("1. devolverCamino A->D:        " + mapa.devolverCamino("A", "D"));
		System.out.println("2. devolverCamino D->A:        " + mapa.devolverCamino("D", "A"));
		System.out.println("3. devolverCamino A->Z:        " + mapa.devolverCamino("A", "Z"));
		System.out.println("4. exceptuando [B], A->D:      " + mapa.devolverCaminoExceptuando("A", "D", List.of("B")));
		System.out.println("5. caminoMasCorto A->D:        " + mapa.caminoMasCorto("A", "D"));
		System.out.println("6. sinCargar A->D, tanque 15:  " + mapa.caminoSinCargarCombustible("A", "D", 15));
		System.out.println("7. sinCargar A->D, tanque 10:  " + mapa.caminoSinCargarCombustible("A", "D", 10));
	}
}
