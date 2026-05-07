package tp1.ejercicio7;

import java.util.*;

public class EjercicioCombinar {
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> resultado = new ArrayList<>();
		int i=0;
		int j=0;
		
		while(i<lista1.size() && j<lista2.size()) {
			if(lista1.get(i)<= lista2.get(j)) {
				resultado.add(lista1.get(i));
				i++;
			}else {
				resultado.add(lista2.get(j));
				j++;
			}
		}
		while(i<lista1.size()) {
			resultado.add(lista1.get(i));
			i++;
		}
		while(j<lista2.size()) {
			resultado.add(lista2.get(j));
		}
		return resultado;
	}
}
