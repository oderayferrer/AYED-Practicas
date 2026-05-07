package tp2.ejercicio5;

import java.util.LinkedList;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1y2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol= arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		return (!arbol.isEmpty() ? helperProfundidadRecursivo(p,arbol,0): 0);
		
	}
	
	public int helperProfundidadRecursivo(int p, BinaryTree<Integer> a, int nivelActual) {
		if(nivelActual == p) {
			return a.getData();
		}else {
			int suma=0;
			if(a.hasLeftChild()) suma+=helperProfundidadRecursivo(p,a.getLeftChild(),nivelActual+1);
			if(a.hasRightChild()) suma+=helperProfundidadRecursivo(p,a.getRightChild(),nivelActual+1);
			return suma;
		}
		
	}
	
	public int helperProfundidadCola(int p, BinaryTree<Integer> a) {
		Queue<BinaryTree<Integer>> cola = new Queue<>();
		cola.enqueue(this.arbol);
		int nivelActual =0;
		int suma = 0;
		while(!cola.isEmpty() && nivelActual<=p){
			int nodosEnNivel = cola.size();
			for(int i = 0; i< nodosEnNivel; i++) {
				BinaryTree<Integer> aux = cola.dequeue();
				if(nivelActual == p) {
					suma+= aux.getData();
				}
				if(aux.hasLeftChild()) cola.enqueue(aux.getLeftChild());
				if(aux.hasRightChild()) cola.enqueue(aux.getRightChild());
			}
			nivelActual++;
		}
		return suma;
	}
	
	public static void main (String[] args) {
	    // Armamos el árbol del ejemplo
	    BinaryTree<Integer> ab = new BinaryTree<>(4);
	    ab.addLeftChild(new BinaryTree<>(2));
	    ab.addRightChild(new BinaryTree<>(6));
	    
	    ab.getLeftChild().addLeftChild(new BinaryTree<>(1));
	    ab.getLeftChild().addRightChild(new BinaryTree<>(3));
	    
	    ab.getRightChild().addLeftChild(new BinaryTree<>(5));
	    ab.getRightChild().addRightChild(new BinaryTree<>(8));
	    
	    ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
	    
	    int nivelABuscar = 1;
	    
	    System.out.println("--- Testeando Nivel " + nivelABuscar + " ---");
	    
	    // Probamos la recursiva
	    int resultadoRec = prof.sumaElementosProfundidad(nivelABuscar);
	    System.out.println("Resultado Recursivo: " + resultadoRec);
	    
	    // Probamos la de la cola
	    int resultadoCola = prof.helperProfundidadCola(nivelABuscar, ab);
	    System.out.println("Resultado con Cola: " + resultadoCola);
	    
	    if(resultadoRec == resultadoCola) {
	        System.out.println("¡Éxito! Ambos métodos coinciden.");
	    } else {
	        System.out.println("Algo salió mal, los resultados son distintos.");
	    }
	}
}