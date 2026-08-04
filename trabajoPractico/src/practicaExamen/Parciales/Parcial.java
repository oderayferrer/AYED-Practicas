package practicaExamen.Parciales;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Parcial {
	public class Camino{
		private List<String> sitios;
		private int distancia;
		public Camino(List<String> sitios, int distancia) {
			this.sitios = sitios;
			this.distancia = distancia;
		}
		public List<String> getSitios() {
			return sitios;
		}

		public int getDistancia() {
			return distancia;
		}		
		
	}
	
	public List<Camino> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor){
		List<Camino> resultado= new ArrayList<>();
		
		Vertex<String> ori = sitios.search(origen);
		Vertex<String> dest =  sitios.search(destino);
		
		if(ori!= null && dest != null) {
			boolean[] visitado = new boolean[sitios.getSize()];
			List<String> caminoActual = new ArrayList<>();
			buscar(sitios,ori,dest,evitarPasarPor,visitado,caminoActual,0,resultado);
		}
		
		return resultado;
	}
	
	private void buscar(Graph<String> g, Vertex<String> actual, Vertex<String> destino, List<String> evitar,
            boolean[] visitado, List<String> camino, int distancia, List<Camino> resultado) {
		visitado[actual.getPosition()] = true;
		camino.add(actual.getData());
		
		if(actual == destino) {
			List<String> copia = new ArrayList<>();
			copia.addAll(camino);
			resultado.add(new Camino(copia,distancia));
		}else {
			for(Edge<String> e : g.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				if(!visitado[vecino.getPosition()] && !evitar.contains(vecino.getData())) {
					buscar(g, vecino, destino, evitar, visitado, camino, distancia + e.getWeight(), resultado);
				}
			}
		}
		visitado[actual.getPosition()]=false;
		camino.remove(camino.size() -1);
	}
}
