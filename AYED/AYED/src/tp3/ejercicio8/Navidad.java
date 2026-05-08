package tp3.ejercicio8;

import tp3.ejercicio1y3y5.GeneralTree;

public class Navidad {
	protected GeneralTree<Integer> ab;
	
	public Navidad(GeneralTree<Integer> ab) {
		this.ab=ab;
	}
	
	public String isAbetoNavidenio() {
		boolean res = false;
		
		if(ab != null && !ab.isEmpty()) {
			res= isAbeto(ab);
		}
		return res ? "Es abeto navidenio" : "No es abeto navidenio";
	}
	
	private boolean isAbeto(GeneralTree<Integer> ab) {
		boolean res = true;
		int nodosHoja = 0;
		for(GeneralTree<Integer> child : ab.getChildren()) {
			if(child.isLeaf()) nodosHoja++;
			else if(!isAbeto(child)) res = false;
		}
		return res && (nodosHoja >=3);
	}
}
