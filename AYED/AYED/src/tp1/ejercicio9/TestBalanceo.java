package tp1.ejercicio9;

import java.util.*;

public class TestBalanceo {
	public boolean estaBalanceado(String cadena) {
		LinkedList<Character> apertura = new LinkedList<>();
		apertura.add('(');
		apertura.add('{');
		apertura.add('[');
		
		LinkedList<Character> cierre = new LinkedList<>();
		cierre.add(')');
		cierre.add('}');
		cierre.add(']');
		
		Stack<Character> pila = new Stack<>();
		
		for(int i=0; i< cadena.length(); i++) {
			char actual = cadena.charAt(i);
			
			if(apertura.contains(actual)) {
				pila.push(actual);
				
			}
			else if(cierre.contains(actual)) {
				if(pila.isEmpty()) {
					return false;
				}
				else {
					char elemento =pila.pop();
					int indiceApertura = apertura.indexOf(elemento);
					int indiceCierre = cierre.indexOf(actual);
					if(indiceApertura != indiceCierre) {
						return false;
					}
				}
			}
		}
		
		return pila.isEmpty();
		
	}
	
}
