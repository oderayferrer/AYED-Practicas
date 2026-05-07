package ParcialesArboles;

import tp2.ejercicio1y2.BinaryTree;

/*Parcial 6 de mayo de 2023*/
public class ParcialArboles1 {
	protected BinaryTree<Integer> arbol;
	
	
	
	public boolean isTwoTree(int num) {
		boolean res = false;
		BinaryTree<Integer> ab = null;
		if(this.arbol != null && !this.arbol.isEmpty()) {
			ab =buscar(this.arbol, num);
		}
		if(ab != null) {
			int cantIzq = -1;
			int cantDer = -1;
			
			if(ab.hasLeftChild()) {
				cantIzq= contar(ab.getLeftChild());
			}
			if(ab.hasRightChild()) {
				cantDer = contar(ab.getRightChild());
			}
			res = cantIzq == cantDer;
		}
		return res;
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> arbol, int n){
		BinaryTree<Integer> res=null;
		if(arbol.getData() == n) {
			res = arbol; 
		}else{
			if (arbol.hasLeftChild()){
				res = buscar(arbol.getLeftChild(), n);
			}
			if(res == null && arbol.hasRightChild()) {
				res = buscar(arbol.getRightChild(), n);
			}
	    }
		return res;
	}
	
	private int contar(BinaryTree<Integer> a) {
		int total = 0;
		if(a != null && !a.isLeaf()) {
			int cantHijoIzq = 0;
			int cantHijoDer = 0;
			
			if(a.hasLeftChild()) {
				cantHijoIzq = contar(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				cantHijoDer = contar(a.getRightChild());
			}
			
			int soyDoble = 0;
			if(a.hasLeftChild() && a.hasRightChild()) {
				soyDoble = 1;
			}
			
			total = cantHijoIzq + cantHijoDer + soyDoble;
		}
		
		return total;
		
		
	}
}
