package tp2.ejercicio9;

import tp2.ejercicio1y2.BinaryTree;
public class ParcialArboles {

	public BinaryTree<Datos> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Datos> res = null;
		if(arbol != null && !arbol.isEmpty()) {
			res = arbolHelperSumAndDif(arbol,0,0);
		}
		return res;
	}
	
	private BinaryTree<Datos> arbolHelperSumAndDif(BinaryTree<Integer> a, int sum, int padre){
		int datoActual = a.getData();
		Datos dato = new Datos(datoActual+sum, datoActual - padre);
		BinaryTree<Datos> nuevo = new BinaryTree<Datos>(dato);
		if(a.hasLeftChild()) {
			nuevo.addLeftChild(arbolHelperSumAndDif(a.getLeftChild(),sum + datoActual, datoActual));
		}
		if(a.hasRightChild()) {
			nuevo.addRightChild(arbolHelperSumAndDif(a.getRightChild(),sum + datoActual, datoActual));
			}
		return nuevo;
	}
	
	public static void main(String args[]) {
	    System.out.println("Test Ejercicio9");
	    ParcialArboles parcialArboles = new ParcialArboles();
	    
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
		
		arbol.addLeftChild(new BinaryTree<>(5));
		arbol.addRightChild(new BinaryTree<>(12));
		
		arbol.getLeftChild().addLeftChild(new BinaryTree<>(3));
		arbol.getLeftChild().addRightChild(new BinaryTree<>(8));
		
		arbol.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(2));
		arbol.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(4));
		
		arbol.getRightChild().addLeftChild(new BinaryTree<>(11));
		arbol.getRightChild().addRightChild(new BinaryTree<>(15));
		
		System.out.println("Nuevo Arbol: ");
		parcialArboles.sumAndDif(arbol).entreNiveles(0, 4);
		
	}
}
	