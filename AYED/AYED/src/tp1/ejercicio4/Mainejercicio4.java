package tp1.ejercicio4;

public class Mainejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		SwapValores.swap1(a,b);
		SwapValores.swap2(c,d);
		System.out.println("a=" + a + " b=" + b) ;
		System.out.println("c=" + c + " d=" + d) ;

	}
	/*Stack (Pila): Es donde viven las variables locales y los parámetros de los métodos. Los intercambios ocurrieron aquí, en marcos de memoria temporales.
	Heap (Montículo): Es donde viven los objetos (como los Integer). Los objetos en el heap nunca fueron alterados porque son inmutables.*/

}
