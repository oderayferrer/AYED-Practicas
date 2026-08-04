package tp5.ejercicio1.matrizAdy;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;

public class AdjMatrixEdge<T> implements Edge<T> {
	Vertex<T> target;
	int weight;
	
	public AdjMatrixEdge(Vertex<T> target, int weight) {
		super();
		this.target = target;
		this.weight = weight;
	}
	
	

	public void setTarget(Vertex<T> target) {
		this.target = target;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	@Override
	public Vertex<T> getTarget() {
		// TODO Auto-generated method stub
		return this.target;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}
	
	
	
}
