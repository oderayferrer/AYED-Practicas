package tp3.ejercicio9;

import java.util.List;

import tp3.ejercicio1y3y5.GeneralTree;

public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean res = true;
		if(arbol != null && !arbol.isEmpty()) {
			if(!arbol.isLeaf()) {
				List<GeneralTree<Integer>> children = arbol.getChildren();
				int minHijos = Integer.MAX_VALUE;
				
				for(GeneralTree<Integer> child : children) {
					if(!esDeSeleccion(child)) {
						res = false;
					}
					minHijos = Math.min(minHijos, child.getData());
				}
				
				if(res && arbol.getData() != minHijos) {
					res = false;
				}
			}
		}
		return res;
	}
	
}
