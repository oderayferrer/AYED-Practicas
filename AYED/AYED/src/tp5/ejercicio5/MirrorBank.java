package tp5.ejercicio5;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Vertex;

public class MirrorBank {

	public List<Persona> jubiladosCercanos(Graph<Persona> red, Vertex<Persona> empleado, int distanciaMax){
		List<Persona> resultado = new ArrayList<>();
		boolean[] marca = new boolean[red.getSize()];
		Queue<Vertex<Persona>> q = new Queue<Vertex<Persona>>();
		int nodosEnNivel=0;
		marca[empleado.getPosition()]=true;
		q.enqueue(empleado);
		int distanciaActual=0;
		while(!q.isEmpty() && distanciaActual< distanciaMax && resultado.size() < 40) {
			nodosEnNivel = q.size();
			distanciaActual++;
			for(int i =0; i< nodosEnNivel; i++) {
				Vertex<Persona> w = q.dequeue();
				for(Edge<Persona> e : red.getEdges(w)) {
					Vertex<Persona> target = e.getTarget();
					int j = target.getPosition();
					if(!marca[j]) {
						marca[j]=true;
						q.enqueue(target);
						Persona p = target.getData();
	                    if(p.esJubilado() && !p.percibioJubilacion()) {
	                        
	                        // Chequeo estricto antes de agregar para no pasarnos de 40
	                        if(resultado.size() < 40) {
	                            resultado.add(p);
	                        }
	                    }
					}
				}
			}
		}
		return resultado;
	}
	
}
