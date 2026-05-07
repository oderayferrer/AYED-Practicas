/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Oderay
 */
public class Mainejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero ");
        int n = scanner.nextInt();
        
        int[] a = ejercicio2.Contador(n);;
        
        ejercicio2.Imprimir(a, n);
    }
    
}
