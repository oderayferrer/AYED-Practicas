package tp5.ejercicio1.matrizAdy;

import tp5.ejercicio1.Vertex;

public class AdjMatrixVertex<T> implements Vertex<T> {
	T data;
	int Position;
	
	
	public AdjMatrixVertex(T data, int position) {
		super();
		this.data = data;
		Position = position;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public int getPosition() {
		return Position;
	}


	public void setPosition(int position) {
		Position = position;
	}


	public void decrementPosition() {
		Position = Position -1;
		
	}
	
	
}
