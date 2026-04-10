package com.ejercicio1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrafoLista {

    private ArrayList<LinkedList<Arista>> lista;
    private String[] vertices;
    private int n;

    public GrafoLista(String[] vertices) {
        this.vertices = vertices;
        this.n = vertices.length;

        lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lista.add(new LinkedList<>());
        }
    }

    // Agregar arista DIRIGIDA con peso
    public void agregarArista(int i, int j, int peso) {
        lista.get(i).add(new Arista(j, peso));
    }

    // Mostrar lista de adyacencia
    public void mostrar() {
        System.out.println("=== Lista de adyacencia ===");
        for (int i = 0; i < n; i++) {
            System.out.print(vertices[i] + " -> ");
            for (Arista a : lista.get(i)) {
                System.out.print(vertices[a.getDestino()] + "(" + a.getPeso() + ") ");
            }
            System.out.println();
        }
    }

    // BFS usando Queue — marca al encolar
    public void bfs(int inicio) {
        boolean[] visitado = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visitado[inicio] = true;
        queue.offer(inicio);

        System.out.print("BFS desde " + vertices[inicio] + ": ");

        while (!queue.isEmpty()) {
            int actual = queue.poll();
            System.out.print(vertices[actual] + " ");

            for (Arista a : lista.get(actual)) {
                if (!visitado[a.getDestino()]) {
                    visitado[a.getDestino()] = true;
                    queue.offer(a.getDestino());
                }
            }
        }
        System.out.println();
    }

    // DFS usando Stack — marca al apilar
    public void dfs(int inicio) {
        boolean[] visitado = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        visitado[inicio] = true;
        stack.push(inicio);

        System.out.print("DFS desde " + vertices[inicio] + ": ");

        while (!stack.isEmpty()) {
            int actual = stack.pop();
            System.out.print(vertices[actual] + " ");

            for (Arista a : lista.get(actual)) {
                if (!visitado[a.getDestino()]) {
                    visitado[a.getDestino()] = true;
                    stack.push(a.getDestino());
                }
            }
        }
        System.out.println();
    }

 
}