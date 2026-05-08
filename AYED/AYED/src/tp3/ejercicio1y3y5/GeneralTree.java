package tp3.ejercicio1y3y5;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;

public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>> children= new LinkedList<GeneralTree<T>>();
	
	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}
	
	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this.data= data;
		this.children= children;
	}
	
	public T getData(){
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<GeneralTree<T>> getChildren(){
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if(children != null) {
			this.children = children;
		}
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}
	
	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean isEmpty() {
		return data == null && !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}
	
	public void removeChild(GeneralTree<T> child) {
		if(this.hasChildren()) {
			children.remove(child);
		}
	}
	
	/* Ejercicio 3
	Implemente en la clase GeneralTree los siguientes métodos
	a) public int altura(): int devuelve la altura del árbol, es decir, la longitud del camino más largo
	desde el nodo raíz hasta una hoja.
	b) public int nivel(T dato) devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo
	es la longitud del único camino de la raíz al nodo.
	c) public int ancho(): int la amplitud (ancho) de un árbol se define como la cantidad de nodos que
	se encuentran en el nivel que posee la mayor cantidad de nodos. */    
	
	public int altura() {
		return (!this.isEmpty() ? alturaHelper() : -1);
	}
	
	public int alturaHelper() {
		int aux =0;
		if(!this.isLeaf()) {
			int alturaMax = -1;
			List<GeneralTree<T>> children = this.getChildren();
			for(GeneralTree<T> child:children) {
				alturaMax = Math.max(alturaMax, child.alturaHelper());
			}
			aux = alturaMax + 1;
		}
		return aux;
	}
	
	public int nivel(T dato) {
		return (!this.isEmpty() ? nivelHelper(dato) : -1);
	}
	
	public int nivelHelper(T dato) {
		int nivelAct = 0;
		int res = -1;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		
		queue.enqueue(this);
		queue.enqueue(null);
		
		while(!queue.isEmpty() && res == -1) {
			aux = queue.dequeue();
			
			if(aux != null) {
				if(aux.getData().equals(dato)) {
					res = nivelAct;
				}else {
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> child: children) {
						queue.enqueue(child);
					}
				}
			}
			else {
				if(!queue.isEmpty()) {
					nivelAct++;
					queue.enqueue(null);
				}
			}
		}
		return res;
	}
	
	public int ancho() {
		int maxAncho = -1;
		int nodosNivelActual = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		if(!this.isEmpty()) {
			queue.enqueue(this);
			queue.enqueue(null);
			maxAncho = 0;
			
			while(!queue.isEmpty()) {
				aux = queue.dequeue();
				
				if(aux != null) {
					nodosNivelActual++;
					
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> child : children) {
						queue.enqueue(child);
					}
				}else {
					if(nodosNivelActual > maxAncho) {
						maxAncho = nodosNivelActual;
					}
					
					nodosNivelActual = 0;
					
					if(!queue.isEmpty()) {
						queue.enqueue(null);
					}
				}
			}
		}
		return maxAncho;
	}
	
	public boolean esAncestro(T a, T b) {
		if(this.isEmpty()) return false;
		else return isAncestro(a,b);
	}
	
	public boolean isAncestro(T a, T b) {
		boolean res = false;
		
		GeneralTree<T> raiz = null;
		GeneralTree<T> ab;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this);
		while(!queue.isEmpty()) {
			ab= queue.dequeue();
			if(ab.getData().equals(b) && (!res)) return false;
			if(ab.getData().equals(a)) {
				res = true;
				raiz = ab;
			}
			if(!res) {
				for(GeneralTree<T> child: ab.getChildren()) {
					queue.enqueue(child);
				}
			}
		}
		return res ? esAncestroHelper(raiz,b):false;
	}
	
	private boolean esAncestroHelper(GeneralTree<T> ab, T b) {
		boolean res= false;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this);
		while(!queue.isEmpty()) {
			aux = queue.dequeue();
			if(aux.getData().equals(b)) {
				res = true;
			}else {
				for(GeneralTree<T> child : ab.getChildren()) {
					queue.enqueue(child);
				}
			}
		}
		return res;
	}
}
