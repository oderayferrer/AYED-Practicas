package tp2.ejercicio7;

import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isLeftTree( int num ) {
		BinaryTree<Integer> a =encontrarNum(num,this.arbol);
		boolean resultado=false;
		if(a != null) {
			int hijoIzq = -1;
			int hijoDer = -1;
			if(a.hasLeftChild()) {
				hijoIzq = hijoUnico(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				hijoDer= hijoUnico(a.getRightChild());
			}
			resultado =(hijoIzq > hijoDer);
		}
		return resultado;
	}
	
	public BinaryTree<Integer> encontrarNum(int num, BinaryTree<Integer> arbol){
		BinaryTree<Integer> res = null;
		if(!this.arbol.isEmpty()) {
			if(arbol.getData() == num) {
				res = arbol;
			}
			else {
				if(arbol.hasLeftChild()) {
					res =encontrarNum(num, arbol.getLeftChild());
				}
				if(res == null && arbol.hasRightChild()) {
					res =encontrarNum(num, arbol.getRightChild());
				}
			}
		}
		return res;
	}
	
	public int hijoUnico(BinaryTree<Integer> a) {
		int contador = 0;
		if(a.hasLeftChild() ^ a.hasRightChild()) {
			contador+=1;
		}
		if(a.hasLeftChild()) {
			contador += hijoUnico(a.getLeftChild());
		}
		if(a.hasRightChild()) {
			contador+= hijoUnico(a.getRightChild());
		}
		return contador;
	}
	
}
