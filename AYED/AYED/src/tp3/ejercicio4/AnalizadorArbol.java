package tp3.ejercicio4;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1y3y5.GeneralTree;

public class AnalizadorArbol {
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa>arbol) {
		return 0;
		
	}
	
	private double helper(GeneralTree<AreaEmpresa> arbol) {
		
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
		GeneralTree<AreaEmpresa> ab;
		double suma=0;
		int cantNodos = 0;
		double max = -1;
		queue.enqueue(arbol);
		queue.enqueue(null);
		while(!queue.isEmpty()) {
			ab = queue.dequeue();
			if(ab != null) {
				cantNodos++;
				suma+= ab.getData().getTiempo();
				for(GeneralTree<AreaEmpresa> child : arbol.getChildren()) {
					queue.enqueue(child);
				}
			}else if(!queue.isEmpty()){
				suma= suma / cantNodos;
				max = Math.max(suma, max);
				queue.enqueue(null);
				suma = 0;
				cantNodos = 0;
			}
		}
		return max;
		
	}
}
