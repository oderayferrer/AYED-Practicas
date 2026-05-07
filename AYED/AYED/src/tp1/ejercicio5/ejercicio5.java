package tp1.ejercicio5;
/*Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único método. Escriba tres métodos de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".*/
public class ejercicio5 {
	public static double[] CalcularConReturn(int[] numeros) {
		int min = numeros[0];
		int max = numeros[0];
		double suma = 0;
		
		for(int n: numeros) {
			if(n > max) {
				max = n;
			}
			if(n<min) {
				min = n;
			}
			suma += n;
		}
		return new double[] {max,min,suma/numeros.length};
	}
	public static void retornoConParametro(int[] numeros, Resultados res) {
		res.setMax(numeros[0]);
		res.setMin(numeros[0]);
		int suma=0;
		for(int n: numeros) {
			if(n>res.getMax()) {
				res.setMax(n);
			}
			if(n<res.getMin()) {
				res.setMin(n);
			}
			suma+= n;
		}
		res.promedio= suma / numeros.length;
	}
	
	

}
