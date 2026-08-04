package tp5.ejercicio8;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Vertex;

public class RedNeuronas {
	
	public int neuronasActivadas(Graph<String> grafo, String inicio,int impulso) {
		Vertex<String> origen = grafo.search(inicio);
		if(origen == null) {
			return 0;
		}
		boolean[] visitado = new boolean[grafo.getSize()];
		int[] impulsoActual = new int[grafo.getSize()];
		visitado[origen.getPosition()] = true;
		impulsoActual[origen.getPosition()]= impulso;
		int contador= -1;
		
		Queue<Vertex<String>> cola = new Queue<>();
		
		cola.enqueue(origen);
		
		while(!cola.isEmpty()) {
			Vertex<String> actual = cola.dequeue();
			int miImpulso = impulsoActual[actual.getPosition()];
			for(Edge<String> e : grafo.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				int j = vecino.getPosition();
				
				if(!visitado[j]) {
					if(e.getWeight() >= miImpulso) {
						visitado[j] = true;
						contador++;
						impulsoActual[j] = (int) (miImpulso * 0.9);
						cola.enqueue(vecino);
					}
				}
			}
		}
		
		return contador;
	}
}
