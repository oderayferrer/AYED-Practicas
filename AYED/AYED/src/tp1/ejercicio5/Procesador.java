package tp1.ejercicio5;
/*Para lograr esto, el método debe interactuar directamente con atributos de clase 
 * (variables estáticas). Es la forma menos recomendada en programación limpia 
 * (porque genera efectos secundarios), 
 * pero cumple con la restricción.*/
public class Procesador {
	// Atributos de clase para guardar los resultados
    static int[] entrada; 
    static double max, min, promedio;

    public static void calcularSinNada() {
        max = entrada[0];
        min = entrada[0];
        double suma = 0;

        for (int n : entrada) {
            if (n > max) max = n;
            if (n < min) min = n;
            suma += n;
        }
        promedio = suma / entrada.length;
    }
}
