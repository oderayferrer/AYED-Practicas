package ParcialesArboles;

import java.util.List;

import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles2 {
	private List<BinaryTree<Integer>> lista;
	private int cantidadPares;
	public ParcialArboles2(List<BinaryTree<Integer>> lista, int cantidadPares) {
		super();
		this.lista = lista;
		this.cantidadPares = cantidadPares;
	}
	public List<BinaryTree<Integer>> getLista() {
		return lista;
	}
	public void setLista(List<BinaryTree<Integer>> lista) {
		this.lista = lista;
	}
	public int getCantidadPares() {
		return cantidadPares;
	}
	public void setCantidadPares(int cantidadPares) {
		this.cantidadPares = cantidadPares;
	}
	
	
	
	
}
