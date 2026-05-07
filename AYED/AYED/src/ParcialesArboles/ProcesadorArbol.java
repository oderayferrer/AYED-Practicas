package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio1y2.BinaryTree;

//Parcial 24 de Abril 2023 TEMA1
public class ProcesadorArbol {
	protected BinaryTree<Integer> ab;
	
	public ProcesadorArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public ParcialArboles2 procesar() {
		int cant = 0;
		List<BinaryTree<Integer>> lista = new LinkedList<BinaryTree<Integer>>();
		if(!ab.isEmpty()) {
			cant = procesar(ab,lista);
		}
		return new ParcialArboles2(lista,cant);
	}
	
	public int procesar(BinaryTree<Integer> ab, List<BinaryTree<Integer>> lista) {
		int contador =0;
		if(ab != null && !ab.isEmpty()) {
			if(ab.getData() % 2 ==0) {
				contador++;
				if(ab.hasLeftChild() && ab.hasRightChild()) {
					lista.add(ab);
				}
			}
			if(ab.hasLeftChild()) {
				contador+= procesar(ab.getLeftChild(),lista);
			}
			if(ab.hasRightChild()) {
				contador+= procesar(ab.getRightChild(),lista);
			}
		}
		return contador;	
	}
}
