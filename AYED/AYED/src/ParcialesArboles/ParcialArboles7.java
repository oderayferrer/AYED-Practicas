package ParcialesArboles;
//Enunciado3
import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1y3y5.GeneralTree;

public class ParcialArboles7 {
	GeneralTree<Character> arbol;
	
	public ParcialArboles7(GeneralTree<Character> arbol){
		this.arbol = arbol;
	}
	
	public List<List<Character>> caminosPares(GeneralTree<Character>arbol) {
		List<List<Character>> lista =  new LinkedList<>();
		int cant = 0;
		if(arbol != null && !arbol.isEmpty()) {
			
			List<Character> caminoActual = new LinkedList<>();
			caminosParesHelper(arbol,lista,caminoActual, cant);
		}
		return lista;
		
		
	}
	
	private void caminosParesHelper(GeneralTree<Character> arbol, List<List<Character>> lista, List<Character> actual, int pasos){
		pasos++;
		actual.add(arbol.getData());
		if(arbol.isLeaf() && pasos % 2 == 0) {
			lista.add(new LinkedList<>(actual));
		}
		if(arbol.hasChildren()) {
			for(GeneralTree<Character> child: arbol.getChildren()) {
				caminosParesHelper(child,lista,actual,pasos);
			}
		}
		actual.remove(actual.size() -1);
	}
}
