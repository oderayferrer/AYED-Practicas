package tp3.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1y3y5.GeneralTree;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,Integer n){
		List<Integer> nuevaLista = new LinkedList<Integer>();
		if(!a.isEmpty()) this.numerosImparesMayoresQuePreOrden(a, n,nuevaLista);
		return nuevaLista;
		
	}
	
	public void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,Integer n, List<Integer> l){
		int dato = a.getData();
		if(dato%2 !=0 && dato > n) l.add(dato);
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child :children) {
			numerosImparesMayoresQuePreOrden(child,n,l);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> nuevaLista = new LinkedList<Integer>();
		if(!a.isEmpty()) this.numerosImparesMayoresQueInOrden(a, n,nuevaLista);
		return nuevaLista;
	}
	
	public void numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n, List<Integer> l) {
		List<GeneralTree<Integer>> children = a.getChildren();
		if(a.hasChildren()) {
			numerosImparesMayoresQueInOrden(children.get(0),n, l);
		}
		int dato = a.getData();
		if(dato%2 != 0 && dato > n) l.add(dato);
		for(int i=1;i<children.size();i++) {
			numerosImparesMayoresQueInOrden(children.get(i),n,l);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> nuevaLista = new LinkedList<Integer>();
		if(!a.isEmpty()) this.numerosImparesMayoresQuePostOrden(a, n,nuevaLista);
		return nuevaLista;
	}
	
	public void numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n, List<Integer> l){
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child: children) {
			numerosImparesMayoresQuePostOrden(child,n,l);
		}
		int dato = a.getData();
		if(dato % 2 != 0 && dato > n) {
			l.add(dato);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
		List<Integer> result = new LinkedList<Integer>();
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		
		queue.enqueue(a);
		while(!queue.isEmpty()) {
			aux=queue.dequeue();
			if(!aux.isEmpty()) {
				int dato = a.getData();
				if(dato % 2 != 0 && dato > n) result.add(dato);
			}
			List<GeneralTree<Integer>> children = aux.getChildren();
			for(GeneralTree<Integer> child : children) {
				queue.enqueue(child);
			}
		}
		return result;
	}
		
}

