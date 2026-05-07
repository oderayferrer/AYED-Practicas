package tp1.ejercicio9;

import java.util.*;

public class MainEj9 {

	public static void main(String[] args) {
	    TestBalanceo t = new TestBalanceo();
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Ingresá la cadena de paréntesis:");
	    String cadena = scanner.nextLine();
	    
	    if (t.estaBalanceado(cadena)) {
	        System.out.println("¡Está balanceada!");
	    } else {
	        System.out.println("No está balanceada.");
	    }
	    scanner.close();
	}
}
