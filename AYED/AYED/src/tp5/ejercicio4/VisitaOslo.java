package tp5.ejercicio4;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		List<String> camino = new ArrayList<>();
		boolean[] marca = new boolean[lugares.getSize()];
		if(!lugares.isEmpty()) {
			Vertex<String> origen = lugares.search("Ayuntamiento");
			Vertex<String> dest = lugares.search(destino);
			if(origen != null && dest != null) {
				for(String prohibida : lugaresRestringidos) {
					Vertex<String> v = lugares.search(prohibida);
					if(v != null) {
						marca[v.getPosition()]=true;
					}
				}
				paseoEnBici(lugares,origen,dest,marca,camino,maxTiempo,0);
			}
		}
		return camino;
	}
	
	private boolean paseoEnBici(Graph<String> lugares,Vertex<String> origen, Vertex<String> destino, boolean[] marca,List<String> camino, int maxTiempo,int tiempoAct){
		boolean encontre = false;
		marca[origen.getPosition()] = true;
		camino.add(origen.getData());
		if(origen == destino) {
			encontre = true;
		}else {
			List<Edge<String>> ady = lugares.getEdges(origen);
			for(Edge<String> e : ady) {
				int j = e.getTarget().getPosition();
				if(!marca[j] && !encontre && tiempoAct + e.getWeight() <= maxTiempo) {
					encontre = paseoEnBici(lugares, e.getTarget(), destino, marca,camino,maxTiempo,tiempoAct + e.getWeight());
				}
			}
		}
		if(!encontre) {
			camino.remove(camino.size() - 1);
			marca[origen.getPosition()]=false;
		}
		return encontre;
	}
}
