package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1y3y5.GeneralTree;

public class ParcialArboles {
	private GeneralTree<Integer> arbol;
	public ParcialArboles(GeneralTree<Integer> arbol){
		this.arbol = arbol;
	}
	
	public List<Integer> nivel(int num){
		List<Integer> listaFinal;
		if(this.arbol != null && !this.arbol.isEmpty()) {
			listaFinal = nivelHelper(num);
		}else {
			listaFinal = new LinkedList<>();
		}
		return listaFinal;
	}
	
	private List<Integer> nivelHelper(int num){
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();//queue para ir apilando los niveles
		List<Integer> resultado = new LinkedList<>();//aca va almacenado el resultado para el retorno
		
		boolean encontre= false; // para la condicion de corte del while
		
		if(!this.arbol.isEmpty()) { // si el arbol no esta vacio meto en la cola
			queue.enqueue(this.arbol);
		}
		while(!queue.isEmpty() && !encontre) {// mientras la cola no este vacia y no haya encontrado
			int nodosEnNivel = queue.size();// la cantidad de nodos del nivel va a ser el tamanio de la cola
			
			List<Integer> listaNivel = new LinkedList<>(); //esta va a ser la lista de cada uno de los niveles para ir buscando
			boolean nivelValido = true; // el nivel sera valido si el size es >= num
			
			for(int i = 0; i< nodosEnNivel; i++) {
				GeneralTree<Integer> aux = queue.dequeue(); //el arbol lo saco de la queue
				listaNivel.add(aux.getData());// agrego el contenido del nodo del arbol a mi lista
				
				if(aux.getChildren().size() < num) {//si la cantidad de hijos es menor no cumple condicion, tiene que tener al menos (como minimo) num hijos
					nivelValido = false;
				}
				List<GeneralTree<Integer>> children = aux.getChildren();//lista con los hijos
				for(GeneralTree<Integer> child : children) {
					queue.enqueue(child);// encolo cada uno de los hijos
				}
			}
			if(nivelValido) {//si el nivel es valido la lista del nivel es el resultado
				resultado = listaNivel;
				encontre = true;
			}
			
		}
		return resultado;
	}
}