package tp5.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {
	private Graph<String> mapaCiudades;
	private int mejorCosto;
	private List<String> mejorCamino;
	
	public Mapa(Graph<String> mapaCiudades) {
	    this.mapaCiudades = mapaCiudades;
	}
	
	public List<String> devolverCamino(String ciudad1,String ciudad2){
		List<String> resultado = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if(origen!= null && destino != null) {
				devolverCamino(origen,destino,marca,resultado);
			}
		}
		return resultado;
	}
	
	private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<String> camino) {
		boolean encontre = false;
		marca[origen.getPosition()]= true;
		camino.add(origen.getData());
		if(origen == destino) {
			encontre = true;
		}else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			for(Edge<String> e: ady) {
				int j = e.getTarget().getPosition();
				if(!marca[j] && !encontre) {
					encontre= devolverCamino(e.getTarget(),destino,marca,camino);
				}
			}
		}
		if(!encontre) {
			camino.remove(camino.size()-1);
		}
		return encontre;
	}
	
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen =this.mapaCiudades.search(ciudad1);
			Vertex<String> destino =this.mapaCiudades.search(ciudad2);
			if(origen != null && destino != null) {
				for(String prohibida : ciudades) {
					Vertex<String> v = this.mapaCiudades.search(prohibida);
					if(v != null) {
						marca[v.getPosition()] = true;
					}
				}
				devolverCamino(origen,destino,marca,camino);
				
			}
		}
		return camino;
	}
	
	public List<String> caminoMasCorto(String ciudad1,String ciudad2){
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		mejorCamino = new ArrayList<>();
		List<String> caminoActual = new ArrayList<>();
		mejorCosto = Integer.MAX_VALUE;
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if(origen!= null && destino != null) {
				dfsMasCorto(origen,destino,marca,caminoActual,0);
			}
		}
		return mejorCamino;
	}
	
	private void dfsMasCorto(Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<String> caminoActual, int costo) {
		marca[origen.getPosition()]= true;
		caminoActual.add(origen.getData());
		if(origen == destino) {
			if(costo < mejorCosto) {
				mejorCosto = costo;
				mejorCamino.clear();
				mejorCamino.addAll(caminoActual);
			}
		}else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			for(Edge<String> e : ady ) {
				int j = e.getTarget().getPosition();
				if(!marca[j] && costo + e.getWeight() < mejorCosto){
					dfsMasCorto(e.getTarget(),destino,marca,caminoActual,costo+e.getWeight());
				}
			}
		}
		caminoActual.remove(caminoActual.size() - 1);
		marca[origen.getPosition()] = false;
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1,String ciudad2, int tanqueAuto){
		List<String> camino = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if( origen != null && destino != null) {
				caminoSinCargarCombustible(origen,destino,marca, camino,tanqueAuto,0);
			}
		}
		return camino;
	}
	
	private boolean caminoSinCargarCombustible(Vertex<String> origen,Vertex<String> destino,boolean[] marca,List<String> camino, int tanqueAuto, int combustibleGastado) {
		boolean encontre = false;
		marca[origen.getPosition()]= true;
		camino.add(origen.getData());
		if(origen == destino) {
				encontre = true;	
		}else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			for(Edge<String> e : ady) {
				int j = e.getTarget().getPosition();
				if(!marca[j] && !encontre && combustibleGastado + e.getWeight() <= tanqueAuto) {
					encontre = caminoSinCargarCombustible(e.getTarget(),destino,marca,camino,tanqueAuto,combustibleGastado + e.getWeight());
				}
			}
		}
		if(!encontre) {
			camino.remove(camino.size() -1);
			marca[origen.getPosition()]= false;
		}
		return encontre;
	}
	
	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		List<String> camino = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		mejorCamino = new ArrayList<>();
		mejorCosto = Integer.MAX_VALUE;
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			
			if(origen != null && destino != null) {
				// arranca con el tanque LLENO; la carga inicial no cuenta
				dfsMenorCarga(origen,destino,marca, camino,tanqueAuto,tanqueAuto,0);
			}
		}
		return mejorCamino;
	}

	private void dfsMenorCarga(Vertex<String> origen,Vertex<String> destino, boolean[] marca, List<String> camino, int tanqueAuto, int combustibleRestante, int cargas) {
		marca[origen.getPosition()]=true;
		camino.add(origen.getData());
		if(origen == destino) {
			if(cargas < mejorCosto) {
				mejorCosto = cargas;
				mejorCamino.clear();
				mejorCamino.addAll(camino);
			}
		}else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			for(Edge<String> e : ady) {
				int j = e.getTarget().getPosition();
				int w = e.getWeight();
				if(!marca[j]) {
					if(w <= combustibleRestante) {
						// CASO A: me alcanza -> cruzo SIN cargar
						dfsMenorCarga(e.getTarget(),destino,marca,camino,tanqueAuto,combustibleRestante - w,cargas);
					} else if(w <= tanqueAuto && cargas + 1 < mejorCosto) {
						// CASO B: no me alcanza pero entra en un tanque lleno -> CARGO aca y cruzo
						dfsMenorCarga(e.getTarget(),destino,marca,camino,tanqueAuto,tanqueAuto - w,cargas + 1);
					}
					// si w > tanqueAuto: ruta imposible, ni con tanque lleno
				}
			}
		}
		camino.remove(camino.size() - 1);
		marca[origen.getPosition()] = false;
	}
}
