package ParcialesArboles;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1y3y5.GeneralTree;

//enunciado2
public class Parcial {
	protected GeneralTree<Integer> arbol;
	
	
	
	public Parcial(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		boolean ok = true;
		if(!arbol.isEmpty()) {
			queue.enqueue(arbol);
			while(!queue.isEmpty()) {
				GeneralTree<Integer> aux = queue.dequeue();
				int min = Integer.MAX_VALUE;
				for(GeneralTree<Integer> child : aux.getChildren()) {
					queue.enqueue(child);
					min = Math.min(min, child.getData());
				}
				if(!aux.isLeaf() && aux.getData() != min) ok = false;
			}
		}
		return ok;
	}
	
	
}
