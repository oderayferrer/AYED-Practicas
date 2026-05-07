package ParcialesArboles;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1y2.BinaryTree;

//Enunciado4
public class NivelArbol {
	BinaryTree<Integer> arbol;
	
	public NivelArbol(BinaryTree<Integer> arbol) {
		this.arbol= arbol;
	}
	
	public BinaryTree<Integer> minEnNivelAB(int n){
		BinaryTree<Integer> nodoMinimo = null;
		int minValor = Integer.MAX_VALUE;
		Queue<BinaryTree<Integer>> queue = new Queue<>();
		
		if(this.arbol != null && !this.arbol.isEmpty()) {
			queue.enqueue(arbol);
			int nivelActual = 0;
			
			while(!queue.isEmpty() && nivelActual<= n) {
				int cantidadEnNivel = queue.size();
				
				for(int i=0; i<cantidadEnNivel; i++) {
					BinaryTree<Integer> aux = queue.dequeue();
					
					if(nivelActual == n && aux.isLeaf() && aux.getData() <minValor) {
						minValor = aux.getData();
						nodoMinimo = aux;
					}
					if(aux.hasLeftChild()) {
						queue.enqueue(aux.getLeftChild());
					}
					if(aux.hasRightChild()) {
						queue.enqueue(aux.getRightChild());
					}
				}
				
				nivelActual++;
			}
		}
		
		return nodoMinimo;
		
	}
}
