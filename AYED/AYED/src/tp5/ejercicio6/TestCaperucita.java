package tp5.ejercicio6;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class TestCaperucita {
	public static void main(String[] args) {
		// Grafo del enunciado (no dirigido). Aristas = cantidad de frutales.
		// Caperucita - Claro3 (4), Caperucita - Claro1 (3), Caperucita - Claro2 (4)
		// Claro3 - Claro5 (15), Claro1 - Claro5 (3), Claro1 - Claro2 (4)
		// Claro2 - Claro4 (10), Claro5 - Abuelita (4), Claro5 - Claro4 (11), Claro4 - Abuelita (9)
		Graph<String> b = new AdjListGraph<>();
		Vertex<String> cap = b.createVertex("Casa Caperucita");
		Vertex<String> c1  = b.createVertex("Claro 1");
		Vertex<String> c2  = b.createVertex("Claro 2");
		Vertex<String> c3  = b.createVertex("Claro 3");
		Vertex<String> c4  = b.createVertex("Claro 4");
		Vertex<String> c5  = b.createVertex("Claro 5");
		Vertex<String> ab  = b.createVertex("Casa Abuelita");

		// no dirigido = conectar en ambos sentidos
		conectar(b, cap, c3, 4);
		conectar(b, cap, c1, 3);
		conectar(b, cap, c2, 4);
		conectar(b, c3, c5, 15);
		conectar(b, c1, c5, 3);
		conectar(b, c1, c2, 4);
		conectar(b, c2, c4, 10);
		conectar(b, c5, ab, 4);
		conectar(b, c5, c4, 11);
		conectar(b, c4, ab, 9);

		BuscadorDeCaminos buscador = new BuscadorDeCaminos(b);
		System.out.println("Caminos mas seguros (frutales < 5 en cada sendero):");
		for (var camino : buscador.recorridosMasSeguro()) {
			System.out.println("  " + camino);
		}
	}

	private static void conectar(Graph<String> g, Vertex<String> u, Vertex<String> v, int w) {
		g.connect(u, v, w);
		g.connect(v, u, w);
	}
}
