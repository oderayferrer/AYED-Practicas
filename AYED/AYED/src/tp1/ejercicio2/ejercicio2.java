/*
Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n
con los n primeros múltiplos enteros de n mayores o iguales que 1.
Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}
Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por
teclado, mediante el uso de System.in. La clase Scanner permite leer de forma sencilla
valores de entrada.

 */
package tp1.ejercicio2;

/**
 *
 * @author Oderay
 */
public class ejercicio2 {
    public static int[] Contador(int n){
        int[] arreglo = new int[n];
        for(int i= 0; i< n; i++){
            arreglo[i] = n* (i+1);
        }
        return arreglo;
    }
    public static void Imprimir(int[] arreglo, int n){
        for(int i=0;i<n; i++){
            System.out.println(arreglo[i]);
        }
    }
}
