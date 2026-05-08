package tp3.ejercicio7;
import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1y3y5.GeneralTree;

public class Caminos {
	protected GeneralTree<Integer> arbol;
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> lista = new LinkedList<>();
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> listaActual = new LinkedList<>();
			caminoHelper(arbol,lista,listaActual,0);
		}
		return lista;
	}
	
	private void caminoHelper(GeneralTree<Integer> arbol, List<Integer> lista, List<Integer> actual, int cantMax){
		actual.add(arbol.getData());
		int cantActual = actual.size();
		if(arbol.isLeaf()) {
			if (actual.size() > cantMax) {
				lista.clear();
				lista.addAll(actual);
				cantMax =actual.size();
			}
		}
		for(GeneralTree<Integer> child : arbol.getChildren()) {
			caminoHelper(child,lista,actual,cantActual);
		}
		actual.remove(actual.size()-1);
	}
	
}
