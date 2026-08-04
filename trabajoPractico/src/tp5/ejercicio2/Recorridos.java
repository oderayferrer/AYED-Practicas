package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Vertex;

public class Recorridos<T> {

	public List<T> dfs(Graph<T> grafo){
		boolean[] marca = new boolean[grafo.getSize()];
		List<T> resultado = new LinkedList<>();
		for(int i=0; i<grafo.getSize();i++) {
			if(!marca[i])
				dfs(i,grafo,marca,resultado);
		}
		return resultado;
	}
	
	private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> resultado) {
		marca[i]= true;
		Vertex<T> v = grafo.getVertex(i);
		resultado.add(v.getData());
		for(Edge<T> e: grafo.getEdges(v)) {
			int j= e.getTarget().getPosition();
			if(!marca[j])
				dfs(j,grafo,marca,resultado);
		}
	}
	
	public List<T> bfs(Graph<T> grafo){
		boolean[] marca = new boolean[grafo.getSize()];
		List<T> resultado = new LinkedList<>();
		for(int i=0; i< grafo.getSize(); i++) {
			if(!marca[i])
				bfs(i,grafo,marca,resultado);
		}
		
		return resultado;
	}
	
	private void bfs(int i, Graph<T> grafo, boolean[] marca, List<T> resultado) {
		Queue<Vertex<T>> q = new Queue<Vertex<T>>();
		q.enqueue(grafo.getVertex(i));
		marca[i] = true;
		while(!q.isEmpty()) {
			Vertex<T> w = q.dequeue();
			resultado.add(w.getData());
			for(Edge<T> e: grafo.getEdges(w)) {
				int j = e.getTarget().getPosition();
				if(!marca[j]) {
					marca[j]=true;
					q.enqueue(e.getTarget());
				}
			}
		}
	}
	
}
