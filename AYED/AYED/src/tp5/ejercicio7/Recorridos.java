package tp5.ejercicio7;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Recorridos {
	
	private Graph<String> mapaCiudades;
	
	public List<String> caminoMasCorto(Graph<String> grafo,String ciudad1, String ciudad2){
		List<String> camino = new ArrayList<>();		
		Vertex<String> origen = this.mapaCiudades.search(ciudad1);
		Vertex<String> destino = this.mapaCiudades.search(ciudad2);
		if(origen != null && destino != null) {
			return camino;
		}
		int n = grafo.getSize();
		int[] D = new int[n];
		int[] P = new int[n];
		boolean[] conocido = new boolean[n];
		
		for(int i = 0; i< n; i++) {
			D[i] = Integer.MAX_VALUE;
		}
		D[origen.getPosition()]=0;
		
		for(int veces = 0; veces < n; veces ++) {
			int actual = -1;
			for(int i = 0; i< n;i++) {
				if(!conocido[i] && actual == -1) {
					actual = i;
				}
			}
			conocido[actual] = true;
			Vertex<String> v = grafo.getVertex(actual);
			for(Edge<String> e : grafo.getEdges(v)) {
				int w = e.getTarget().getPosition();
				int nuevaDistancia = D[actual] + e.getWeight();
				if(nuevaDistancia < D[w]) {
					D[w] = nuevaDistancia;
					P[w] = actual;
				}
			}
		}
		return camino;
	}
}
