package tp2.ejercicio1y2;

import java.util.*;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
    public BinaryTree() {
        super();
    }
	
	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public BinaryTree<T> getLeftChild(){
		return leftChild;
	}
	
	public BinaryTree<T> getRightChild(){
		return rightChild;
	}
	
	public void addLeftChild(BinaryTree<T> lc){
		this.leftChild = lc;
	}
	
	public void addRightChild(BinaryTree<T> rc){
		this.rightChild = rc;
	}
	
	public void removeLeftChild() {
		this.leftChild= null;
	}
	
	public void removeRightChild() {
		this.rightChild= null;
	}
	
	public boolean hasLeftChild() {
		return getLeftChild() != null;
	}
	
	public boolean hasRightChild() {
		return getRightChild() != null;
		}
	
	public boolean isEmpty() {
		return this.isLeaf() && this.getData() == null;
	}
	
	
	public boolean isLeaf() {
		return !this.hasLeftChild() && !this.hasRightChild();
	}
	
	public int contarHojas() {
		int cantLeftChild=0;
		int cantRightChild=0;
		if(isEmpty()) return 0;
		else if(isLeaf()) {
			return 1;
		}
		else {
			if(this.hasLeftChild()) {
				cantLeftChild = this.getLeftChild().contarHojas();
			}
			if(this.hasRightChild()) {
				cantRightChild=this.getRightChild().contarHojas();
			}
		}
		return cantLeftChild + cantRightChild;
	}
	
	public BinaryTree<T> espejo(){
		BinaryTree<T> arbolEspejo = new BinaryTree<>(this.getData());
		if(this.hasLeftChild()) {
			arbolEspejo.addRightChild(this.getLeftChild().espejo());
		}
		if(this.hasRightChild()) {
			arbolEspejo.addLeftChild(this.getRightChild().espejo());
		}
		return arbolEspejo;
	}
	
	public void entreNiveles(int n, int m) {
		Queue<BinaryTree<T>> cola = new LinkedList<BinaryTree<T>>();
		cola.add(this);
		int nivelActual = 0;
		
		while(!cola.isEmpty() && nivelActual <= m) {
			int nivelNodo = cola.size();
			for(int i=0;i<nivelNodo; i++) {
				BinaryTree<T> nodo = cola.remove();
				if(nivelActual >= n && nivelActual <+ m) {
					System.out.println(nodo.getData() + " | ");
				}
				if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
				if(nodo.hasRightChild()) cola.add(nodo.getRightChild());
			}
			if(nivelActual>= n && nivelActual<= m) {
				System.out.println();
			}
			
			nivelActual++;
		}
	}
	
	 public void imprimirArbol() {
	        if(this.hasLeftChild()) this.getLeftChild().imprimirArbol();
	        System.out.print(this.getData() + " ");
	        if(this.hasRightChild()) this.getRightChild().imprimirArbol();
	    }
	    
	    public static void main (String[] args) {
	        System.out.println("Test arboles");
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
	        ab.addLeftChild(new BinaryTree<Integer>(2));
	        ab.addRightChild(new BinaryTree<Integer>(6));
	        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
	        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
	        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
	        //ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
	        
	        System.out.println(ab.contarHojas());
	        System.out.println("Arbol original: ");
	        ab.imprimirArbol();
	        System.out.println("Arbol espejo: ");
	        BinaryTree<Integer> abEspejo = ab.espejo();
	        abEspejo.imprimirArbol();
	        System.out.println("Impresion Arbol por niveles 0 y 1");
	        ab.entreNiveles(0, 2);
	    }
	
}
	

