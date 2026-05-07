package tp3teorico.ejercicio4;

import tp2.ejercicio1y2.BinaryTree;

public class PruebaEjercicio4 {
	
	public void traverse(BinaryTree<Character> a) {
		if(!a.isEmpty()) {
			System.out.println(a.getData());
			if(a.hasLeftChild()) traverse(a.getLeftChild());
			if(a.hasRightChild()) traverse(a.getRightChild());
			System.out.println(a.getData());
		}
	}
	
	public static void main(String[] args) {
		PruebaEjercicio4 prueba = new PruebaEjercicio4();
		BinaryTree<Character> a = new BinaryTree<Character>('C');
		
		a.addLeftChild(new BinaryTree<>('A'));
		a.getLeftChild().addRightChild(new BinaryTree<>('B'));
		
		a.addRightChild(new BinaryTree<>('E'));
		
		a.getRightChild().addLeftChild(new BinaryTree<>('D'));
		a.getRightChild().addRightChild(new BinaryTree<>('F'));
		prueba.traverse(a);
	}
}
