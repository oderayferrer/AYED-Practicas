package tp2.ejercicio6;

import tp2.ejercicio1y2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma() {
		if(!this.arbol.isEmpty()) {
			helperSuma(this.arbol);
		}
		return this.arbol;
	}
	
	private int helperSuma(BinaryTree<Integer> a) {
		int totalRama=0;
		if(a.isLeaf()) {
			int aux = a.getData();
			a.setData(0);
			totalRama = aux;
		}else {
			int sumaIzq=0;
			int sumaDer=0;
			
			if(a.hasLeftChild()) {
				sumaIzq = helperSuma(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				sumaDer = helperSuma(a.getRightChild());
			}
			int miDatoViejo = a.getData();
			a.setData(sumaIzq + sumaDer);
			
			totalRama = miDatoViejo + sumaIzq + sumaDer;
		}
		return totalRama;
	}
}
