package tp3.ejercicio10;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1y3y5.GeneralTree;

public class ParcialArboles {
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> lista = new LinkedList<>();
		Maximo max = new Maximo(-1);
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> listaActual = new LinkedList<>();
			helper(arbol, lista, listaActual, max,0,0);
		}
		return lista;
		
	}
	
	private static void helper(GeneralTree<Integer> arbol, List<Integer> lista, List<Integer> actual, Maximo max, int nivel, int puntajeAcumulado){
		int nuevoPuntaje = puntajeAcumulado + (arbol.getData() * nivel);
		boolean ok = false;
		if(arbol.getData() == 1) {
			actual.add(arbol.getData());
			ok = true;
		}
		if(!arbol.isLeaf()) {
			for(GeneralTree<Integer> child : arbol.getChildren()) {
				helper(child,lista,actual,max, nivel + 1 ,puntajeAcumulado);
			}
		}else if(puntajeAcumulado > max.getMax()) {
			max.setMax(puntajeAcumulado);
			puntajeAcumulado = 0;
			lista.removeAll(lista);
			lista.addAll(actual);
		}
		if(ok) actual.remove(actual.size() - 1);
	}
}
