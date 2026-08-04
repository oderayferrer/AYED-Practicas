package tp5.ejercicio6;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCaminos {

	Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> bosque) {
		this.bosque = bosque;
	}
	
	public List<List<String>> recorridosMasSeguro(){
		List<List<String>> caminos= new ArrayList<List<String>>();
		boolean[] marca = new boolean[this.bosque.getSize()];
		List<String> caminoActual = new ArrayList<String>();
		if(!this.bosque.isEmpty()) {
			Vertex<String> origen = this.bosque.search("Casa Caperucita");
			Vertex<String> destino = this.bosque.search("Casa Abuelita");
			if( origen != null && destino != null) {
				recorridosMasSeguro(origen,destino,marca,caminos,caminoActual);
			}
		}
		
		return caminos;
		
	}
	
	private void recorridosMasSeguro(Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<List<String>> caminos, List<String> caminoActual) {
		marca[origen.getPosition()]=true;
		caminoActual.add(origen.getData());
		if(origen == destino) {
			caminos.add(new ArrayList<String>(caminoActual));
		}else {
			List<Edge<String>> ady = this.bosque.getEdges(origen);
			for(Edge<String> e : ady) {
				int j = e.getTarget().getPosition();
				if(!marca[j] && e.getWeight() < 5) {
					recorridosMasSeguro(e.getTarget(),destino,marca,caminos,caminoActual);
				}
			}
		}
		caminoActual.remove(caminoActual.size() - 1);
		marca[origen.getPosition()]= false;
	}
}
