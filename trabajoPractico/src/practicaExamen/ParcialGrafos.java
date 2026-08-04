package practicaExamen;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialGrafos {
	
	public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo, String aldea, int maxPociones){
		List<String> mejorRuta = new ArrayList<>();
		boolean[] visitado = new boolean[reino.getSize()];
		
		Vertex<String> origen = reino.search(castillo);
		Vertex<String> destino = reino.search(aldea);
		if(origen != null && destino != null) {
			List<String> camino = new ArrayList<>();
			rutaOptimaDistribucion(reino,mejorRuta,camino,origen,destino,visitado,maxPociones);
		}
		
		return mejorRuta;
	}
	private void rutaOptimaDistribucion(Graph<String> reino,List<String> mejorRuta,List<String> rutaActual, Vertex<String> actual,Vertex<String> destino,boolean[] visitado,int pocionesRestantes) {
		visitado[actual.getPosition()]=true;
		rutaActual.add(actual.getData());
		if(actual == destino) {
			if(rutaActual.size() > mejorRuta.size()) {
				mejorRuta.clear();
				mejorRuta.addAll(rutaActual);
			}
		}else {
			for(Edge<String> e : reino.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				if(!visitado[vecino.getPosition()] && e.getWeight()<= pocionesRestantes) {
					rutaOptimaDistribucion(reino,mejorRuta,rutaActual,actual,destino,visitado,pocionesRestantes - e.getWeight());
				}
			}
		}
		visitado[actual.getPosition()] = false;
		rutaActual.remove(rutaActual.size() -1);
	}
}
