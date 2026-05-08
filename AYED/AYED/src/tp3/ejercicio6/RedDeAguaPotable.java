package tp3.ejercicio6;

import tp3.ejercicio1y3y5.GeneralTree;

public class RedDeAguaPotable {

	GeneralTree<Character> arbol;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		double resultado;
		if(arbol.isEmpty()) {
			resultado = 0;
		}
		if(!arbol.isLeaf()) {
			resultado = minimoCaudal(arbol,caudal);
		}else resultado = caudal;
		
		return resultado;
	}
	
	private double minimoCaudal(GeneralTree<Character> arbol, double caudal) {
		double resultado = 0;
		if(arbol.isLeaf()) {
			resultado = caudal;
		}
		double cantPorCaudal = caudal / arbol.getChildren().size();
		double caudalMin = Double.MAX_VALUE;
		for(GeneralTree<Character> child : arbol.getChildren()) {
			double caudalHijo = minimoCaudal(child,cantPorCaudal);
			caudalMin = Math.min(caudalMin, caudalHijo);
			resultado = caudalMin;
		}
		return resultado;
	}
	
	
	
}
