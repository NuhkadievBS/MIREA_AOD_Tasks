package task_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс реализует логику направленного взвешенного графа
 */
public class Graph {

    // Класс Ребра графа. Содержит значение звена, с которым связана вершина и вес связи
    class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "(" +  v +", "+ w + ")";
        }
    }

    // Массив списков, содержащий связи графа
    List<Edge> G[];


    public Graph(int n) {
        G = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            G[i] = new LinkedList<Edge>();
        }
    }

    // метод добавления связи в графа
    void addEdge(int u, int v, int w) {
        G[u].add(0, new Edge(v, w)); // добавление происходит в начало списка, чтобы обеспечить сложность О(n)
    }

    // метод проверяет, связаны ли 2 звена
    boolean isConnected(int u, int v) {
        for (Edge i : G[u]) {
            if(i.v == v)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result =  "";
        for (int i = 0; i < G.length; i++) {
            result += i + "=>" + G[i] + "\n";
        }

        return result;
    }


    ArrayList<Integer> paths;

    // метод реализует нахождение кратчайшего пути при помощи дерева решений
    int decisionTreeSearch(int start, int dest) {
        paths = new ArrayList<>();
        traverse(start, dest, 0);
        System.out.println(paths);
        return Collections.min(paths);
    }

    void traverse(int u, int v, int sum) {
        if(u == v) {
            paths.add(0, sum);
        }
        if(u == v || G[u].size() == 0) {
            return;
        }
        for(Edge i : G[u]) {
            traverse(i.v, v, sum+i.w);
        }
    }





}
