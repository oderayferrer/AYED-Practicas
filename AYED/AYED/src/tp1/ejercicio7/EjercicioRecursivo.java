package tp1.ejercicio7;
import java.util.*;
public class EjercicioRecursivo {
	public List<Integer> calcularSucesion(int n) {
        List<Integer> lista = new ArrayList<>();
        generarSucesionRecursiva(n, lista);
        return lista;
    }
	public void generarSucesionRecursiva(int n, List<Integer> lista) {
		lista.add(n);
		if(n == 1) {
			return;
		}
		if(n%2==0) {
			generarSucesionRecursiva(n/2,lista);
		}
		else {
			generarSucesionRecursiva(3 * n+1,lista);
		}
	}
	public void invertirArrayList(ArrayList<Integer> lista) {
		invertirRecursivo(lista,0,lista.size() -1);
	}
	public void invertirRecursivo(ArrayList<Integer> lista, int inicio, int fin) {
		if(inicio>=fin) {
			return;
		}
		Integer aux = lista.get(inicio);
		lista.set(inicio, lista.get(fin));
		lista.set(fin, aux);
		
		invertirRecursivo(lista,inicio +1, fin-1);
	}
	public int sumarLinkedList(LinkedList<Integer> lista) {
		return sumarRecursivo(lista,0);
	}
	private int sumarRecursivo(LinkedList<Integer>lista, int indice) {
		if(indice == lista.size()) {
			return 0;
		}
		return lista.get(indice) + sumarRecursivo(lista,indice +1);
	}
}
