package com.ejercicio1;

import com.ejercicio1.GrafoLista;

public class Main {
    public static void main(String[] args) {
          String[] vertices = {"A", "B", "C", "D", "E", "F"};
        GrafoLista g = new GrafoLista(vertices);
 
        // Aristas dirigidas según el grafo de la imagen
        g.agregarArista(0, 1, 20); // A -> B
        g.agregarArista(0, 3, 45); // A -> D
        g.agregarArista(2, 0, 25); // C -> A
        g.agregarArista(2, 3, 30); // C -> D
        g.agregarArista(3, 2, 30); // D -> C  (bidireccional D-C con peso 30)
        g.agregarArista(3, 4, 10); // D -> E
        g.agregarArista(3, 5, 25); // D -> F
        g.agregarArista(4, 5, 5);  // E -> F
        g.agregarArista(5, 0, 30); // F -> A
        g.agregarArista(5, 2, 50); // F -> C  (peso 50 en la diagonal)
        g.agregarArista(1, 2, 10); // B -> C
 
        g.mostrar();
 
        System.out.println();
        g.bfs(0); // Desde A
        g.dfs(0); // Desde A

    }
}