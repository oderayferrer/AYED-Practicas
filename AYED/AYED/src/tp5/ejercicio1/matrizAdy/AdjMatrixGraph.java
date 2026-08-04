package tp5.ejercicio1.matrizAdy;
import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class AdjMatrixGraph<T> implements Graph<T>{
	private static final int EMPTY_VALUE = 0;
	private int maxVertices;
	private List<AdjMatrixVertex<T>> vertices;
	private int[][] adjMatrix;
	
	
	
	public AdjMatrixGraph(int maxVertices) {
		this.maxVertices = maxVertices;
		vertices = new ArrayList<>();
		adjMatrix = new int[maxVertices][maxVertices];
		
		for(int i=0; i<maxVertices; i++) {
			for(int j = 0; j<maxVertices; j++) {
				adjMatrix[i][j]= EMPTY_VALUE;;
			}
		}
	}

	@Override
	public Vertex<T> createVertex(T data) {
		if(vertices.size() == maxVertices) {
			return null;
		}
		AdjMatrixVertex<T> vertice = new AdjMatrixVertex<>(data,vertices.size());
		vertices.add(vertice);
		return vertice;
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
	    if (!vertices.remove(vertex)) {
	        return;                                    // no era de este grafo
	    }
	    int index = vertex.getPosition();
	    int total = vertices.size();                   // tamaño NUEVO (viejo − 1)

	    // 1) columnas a la izquierda, desde la del muerto
	    for (int fila = 0; fila <= total; fila++) {
	        for (int col = index; col < total; col++) {
	            adjMatrix[fila][col] = adjMatrix[fila][col + 1];
	        }
	    }
	    // 2) filas hacia arriba, desde la del muerto
	    for (int fila = index; fila < total; fila++) {
	        for (int col = 0; col < total; col++) {
	            adjMatrix[fila][col] = adjMatrix[fila + 1][col];
	        }
	    }
	    // 3) limpiar última fila y columna (esquina incluida)
	    for (int k = 0; k <= total; k++) {
	        adjMatrix[total][k] = EMPTY_VALUE;
	        adjMatrix[k][total] = EMPTY_VALUE;
	    }
	    // 4) corregir posiciones de los corridos
	    for (int i = index; i < total; i++) {
	        vertices.get(i).decrementPosition();
	    }
	}

	@Override
	public Vertex<T> search(T data) {
		for(Vertex<T> vertice : this.vertices) {
			if(vertice.getData().equals(data))
				return vertice;
		}
		return null;
	}
	
	public boolean belongs(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		return pos >= 0 && pos < this.vertices.size() && this.vertices.get(pos) == vertex;
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		connect(origin,destination,1);
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		if(this.belongs(origin)&&this.belongs(destination)) {
			adjMatrix[((AdjMatrixVertex<T>) origin).getPosition()]
    				[((AdjMatrixVertex<T>) destination).getPosition()] = weight;
		}
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {

		if(this.belongs(origin)) {
			this.connect(origin, destination,EMPTY_VALUE);
		}
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		return this.weight(origin, destination) != EMPTY_VALUE;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return vertices.isEmpty();
	}

	@Override
	public List<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.vertices);
	}

	@Override
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		int weight = 0;
		if(this.belongs(origin)&& this.belongs(destination)) {
			weight = adjMatrix[((AdjMatrixVertex<T>) origin).getPosition()]
    				[((AdjMatrixVertex<T>) destination).getPosition()];
		}
		return weight;
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		List<Edge<T>> ady = new ArrayList<Edge<T>>();
		int verticePos = v.getPosition();
		for(int i = 0; i< vertices.size(); i++) {
			if(adjMatrix[verticePos][i] != EMPTY_VALUE) {
				ady.add(new AdjMatrixEdge<T>(vertices.get(i), adjMatrix[verticePos][i]));
			}
		}
		return ady;
	}

	@Override
	public Vertex<T> getVertex(int position) {
		if(position < 0 || position >= this.vertices.size()) {
			return null;
		}
		return vertices.get(position);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.vertices.size();
	}
	
}
