package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1y3y5.GeneralTree;

public class ParcialArboles10 {
	public List<Integer> caminoMasLargo(GeneralTree<Integer> arbol){
		List<Integer> lista = new LinkedList<>();
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> caminoActual = new LinkedList<>();	
			helper(arbol, lista, caminoActual);
		}
		return lista;
		
	}
	
	public void helper(GeneralTree<Integer> ab, List<Integer> lista, List<Integer> actual){
		
		if(ab != null && !ab.isEmpty()) {
			actual.add(ab.getData());
			if(ab.isLeaf()) {
				if(actual.size() > lista.size()) {
					lista.clear();
					lista.addAll(actual);
				}
			}
			if(ab.hasChildren()) {
				for(GeneralTree<Integer> child: ab.getChildren()) {
					helper(child,lista,actual);
				}
			}
			
			actual.remove(actual.size()-1);
		}
	}
	
	
}
