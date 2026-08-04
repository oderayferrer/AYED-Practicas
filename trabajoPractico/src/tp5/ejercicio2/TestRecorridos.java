package tp5.ejercicio2;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class TestRecorridos {
    public static void main(String[] args) {
        Graph<Integer> g = new AdjListGraph<>();   // import de tp5.ejercicio1.listaAdy
        Vertex<Integer> v1 = g.createVertex(1);
        Vertex<Integer> v2 = g.createVertex(2);
        Vertex<Integer> v3 = g.createVertex(3);
        Vertex<Integer> v4 = g.createVertex(4);
        g.connect(v2, v4);
        g.connect(v1, v2);
        g.connect(v1, v3);
        g.connect(v2, v1);
        Recorridos<Integer> r = new Recorridos<>();
        System.out.println("DFS: " + r.dfs(g));   // ¿qué esperás que imprima?
        System.out.println("BFS: " + r.bfs(g));
    }
}
