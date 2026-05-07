package ParcialesArboles;

import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles9 {
	BinaryTree<Integer> arbol;
	
	public ParcialArboles9(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaImparesPostOrdenMayorA(BinaryTree<Integer> arbol, int limite) {
		int suma = helperSuma(arbol,limite);
		return suma;
	}
	
	private int helperSuma(BinaryTree<Integer> arbol, int limite) {
		int sumaLocal=0;
		if(arbol != null && !arbol.isEmpty()) {
			if(arbol.hasLeftChild()) {
				sumaLocal+= helperSuma(arbol.getLeftChild(),limite);
			}
			if(arbol.hasRightChild()) {
				sumaLocal+= helperSuma(arbol.getRightChild(),limite);
			}
			int miDato = arbol.getData();
			if(miDato % 2 == 1 && miDato > limite) {
				sumaLocal+= miDato;
			}
		}
		
		return sumaLocal;
	}

}
