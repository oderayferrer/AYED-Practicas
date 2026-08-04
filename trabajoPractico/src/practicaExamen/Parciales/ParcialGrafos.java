package practicaExamen.Parciales;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialGrafos {
	
	public List<String> rutaConCifrado(Graph<String> red, String origen, String destino){
		List<String> camino = new ArrayList<>();
		boolean[]  visitado = new boolean[red.getSize()];
		
		Vertex<String> ori = red.search(origen);
		Vertex<String> dest = red.search(destino);
		
		if(ori != null && dest != null) {
			buscarRuta(red, ori, dest, true, visitado, camino);
		}
		
		return camino;
	}
	
	private boolean buscarRuta(Graph<String> red, Vertex<String> origen,Vertex<String> destino, boolean modoPar, boolean[] visitado, List<String> camino) {
		boolean encontre = false;
		visitado[origen.getPosition()] = true;
		camino.add(origen.getData());
		
		if(origen == destino) {
			return true;
		}
		
		for(Edge<String> e: red.getEdges(origen)) {
			Vertex<String> vecino = e.getTarget();
			if(!visitado[vecino.getPosition()]) {
				boolean aristaEsPar = (e.getWeight() % 2 == 0);
				if(aristaEsPar == modoPar){
					encontre = buscarRuta(red,vecino,destino,!modoPar,visitado,camino);
					if(encontre) {
						return true;
					}
					}
				}
			}
		if(!encontre) {
			visitado[origen.getPosition()] = false;
			camino.remove(camino.size() -1);
		}
		return encontre;
	}
}
