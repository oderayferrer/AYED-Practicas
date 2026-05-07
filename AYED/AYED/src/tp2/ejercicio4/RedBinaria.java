package tp2.ejercicio4;

import tp2.ejercicio1y2.BinaryTree;

public class RedBinaria {
	BinaryTree<Integer> arbol;
	
	public RedBinaria(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		int res=0;
		if(this.arbol != null && !this.arbol.isEmpty()) {
			res = helperRetardo(this.arbol);
		}
		return res;
	}
	
	private int helperRetardo(BinaryTree<Integer> arbol) {
		int maxTotal;
		if(arbol.isLeaf()) {
			maxTotal= arbol.getData();
		}else {
			int izq = 0;
			int der = 0;
			
			if(arbol.hasLeftChild()) {
				izq = helperRetardo(arbol.getLeftChild());
			}
			if(arbol.hasRightChild()) {
				der = helperRetardo(arbol.getRightChild());
			}
			maxTotal = Math.max(izq, der)+ arbol.getData();
		}
		return maxTotal;
		
	}
}
