package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio1y2.BinaryTree;

public class ProcesadorArbol5 {
	protected BinaryTree<Integer> ab;

	public ProcesadorArbol5(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public ParcialArboles4 procesar(BinaryTree<Integer> ab) {
		int cant = 0;
		List<Integer>lista = new LinkedList<Integer>();
		cant = procesar(ab, lista);
		return new ParcialArboles4(lista, cant);
	}
	
	public int procesar(BinaryTree<Integer> ab, List<Integer>lista) {
		int contador = 0;
		if(ab != null && !ab.isEmpty()) {

			if(ab.hasLeftChild()) contador+= procesar(ab.getLeftChild(), lista);
			if(ab.hasRightChild()) contador +=procesar(ab.getRightChild(),lista);
			if(ab.getData() % 2 == 1) {
				contador ++;
				if(ab.hasLeftChild() && !ab.hasRightChild() || !ab.hasLeftChild() && ab.hasRightChild()) {
					lista.add(ab.getData());
				}
			}
		}
		return contador;
		
	}
	
	
}
