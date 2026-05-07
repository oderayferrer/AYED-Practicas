package tp2.ejercicio3;

import java.util.*;

import tp2.ejercicio1y2.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> numerosParesIn(){
		List<Integer> lista = new ArrayList<Integer>();
		helperIn(lista, this.arbol);
		return lista;
		
	}
	
	private void helperIn(List<Integer> lista, BinaryTree<Integer> a) {
		if(a == null || a.isEmpty()) {
			return;
		}
		if(a.hasLeftChild()) {
			helperIn(lista, a.getLeftChild());
		}
		if(a.getData() % 2 == 0) {
			lista.add(a.getData());
		}
		if(a.hasRightChild()) {
			helperIn(lista,a.getRightChild());
		}
	}
	
	public List<Integer> numerosParesPost(){
		List<Integer> lista = new ArrayList<Integer>();
		helperPost(lista, this.arbol);
		return lista;
	}
	
	private void helperPost(List<Integer> lista, BinaryTree<Integer> a) {
		if(a == null || a.isEmpty()) {
			return;
		}
		if(a.hasLeftChild()) {
			helperPost(lista, a.getLeftChild());
		}
		if(a.hasRightChild()) {
			helperPost(lista,a.getRightChild());
		}
		if(a.getData() % 2 == 0) {
			lista.add(a.getData());
		}

		
	}
}
