package ParcialesArboles;

import java.util.List;

import tp2.ejercicio1y2.BinaryTree;

/*24 de abril 2023 tema 2*/
public class ParcialArboles4 {
	private List<Integer> lista;
	private int cantidadImpar;
	
	
	
	public ParcialArboles4(List<Integer> lista2, int cantidadImpar) {
		this.lista = lista2;
		this.cantidadImpar = cantidadImpar;
	}
	public List<Integer> getLista() {
		return lista;
	}
	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}
	public int getCantidadImpar() {
		return cantidadImpar;
	}
	public void setCantidadImpar(int cantidadImpar) {
		this.cantidadImpar = cantidadImpar;
	}
	
	
	
}
