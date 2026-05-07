package tp1.ejercicio7;

import java.util.*;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lista = new ArrayList();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingresa números enteros (escribe una letra para finalizar):");
		
		while(scanner.hasNextInt()) {
			int num = scanner.nextInt();
			lista.add(num);
		}
		System.out.println("\nContenido de la lista (iterando sobre cada elemento):");
		
		for(Integer n : lista) {
			System.out.println(n);
		}
		
		scanner.close();
		
		// 1. Crear lista con 3 estudiantes
        List<Estudiante> listaOriginal = new ArrayList<>();
        listaOriginal.add(new Estudiante("Ana"));
        listaOriginal.add(new Estudiante("Juan"));
        listaOriginal.add(new Estudiante("Pedro"));

        // 2. Generar una copia de la lista (Copia superficial / Shallow Copy)
        List<Estudiante> listaCopia = new ArrayList<>(listaOriginal);

        // 3. Imprimir ambas listas
        System.out.println("--- Antes de la modificación ---");
        System.out.println("Original: " + listaOriginal);
        System.out.println("Copia:    " + listaCopia);

        // 4. Modificar un dato de un estudiante en la lista original
        listaOriginal.get(0).setNombre("Mariana");

        // 5. Volver a imprimir
        System.out.println("\n--- Después de modificar el primer estudiante ---");
        System.out.println("Original: " + listaOriginal);
        System.out.println("Copia:    " + listaCopia);
        
     // Creamos un estudiante que NO está
        Estudiante e4 = new Estudiante("Lucía");
        agregarSiNoExiste(listaOriginal, e4);

        // Intentamos agregar uno que SÍ está (Juan)
        Estudiante eRepetido = new Estudiante("Juan");
        agregarSiNoExiste(listaOriginal, eRepetido);
        
        boolean resultado = esCapicua(lista);
        System.out.print(resultado);
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        
        EjercicioRecursivo ej = new EjercicioRecursivo();
        System.out.println("Original: " + numeros);
        
        ej.invertirArrayList(numeros);
        System.out.println("Invertida: " + numeros);
        
        EjercicioCombinar eje = new EjercicioCombinar();
        
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1); l1.add(3); l1.add(5); l1.add(10);
        
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2); l2.add(4); l2.add(6);

        System.out.println("Lista combinada: " + eje.combinarOrdenado(l1, l2));
        // Resultado esperado: [1, 2, 3, 4, 5, 6, 10]
	}
	
    public static boolean esCapicua(ArrayList<Integer> lista) {
    	int izquierda = 0;
    	int derecha = lista.size() -1;
    	
    	while(izquierda < derecha) {
    		if(!lista.get(izquierda).equals(lista.get(derecha))) {
    			return false;
    		}
    		izquierda++;
    		derecha--;
    	}
    	
    	return true;
    }
	
    public static void agregarSiNoExiste(List<Estudiante> lista, Estudiante nuevo) {
        boolean existe = false;

        // 1. Buscamos (solo lectura, no modificamos nada aquí)
        for (Estudiante e : lista) {
            if (e.getNombre().equals(nuevo.getNombre())) {
                existe = true;
                break; 
            }
        }

        // 2. Modificamos (afuera del bucle for)
        if (!existe) {
            lista.add(nuevo);
            System.out.println("Estudiante " + nuevo.getNombre() + " agregado con éxito.");
        } else {
            System.out.println("El estudiante " + nuevo.getNombre() + " ya existe.");
        }
    }
    
	
}
