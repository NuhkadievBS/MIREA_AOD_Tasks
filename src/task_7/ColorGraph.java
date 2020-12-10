package task_7;

import java.util.ArrayList;
import java.util.Scanner;

public class ColorGraph {
    static int n; // кол-во вершин в графе
    static ArrayList<Integer>[] matrix; // массив списков, хранящий связи графа
    static int[] ans; // массив "цветов", которыми окрашиваются вершины графа

/*
5
0 1 1 0 0
1 0 1 0 0
1 1 0 1 1
0 0 1 0 0
0 0 1 0 0
 */
    static void solve() {
        Scanner sc = new Scanner(System.in);
        //Считывание данных, инициализация
        n = sc.nextInt();
        matrix = new ArrayList[n];
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    matrix[i].add(j); // добавление связи
                }
            }
        }
        System.out.println(matrix[0]);
        System.out.println(matrix[1]);
        System.out.println(matrix[2]);
        System.out.println(matrix[3]);
        System.out.println(matrix[4]);

        //Запуск закрашивания из каждой, еще не закрашенной вершины
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                dfs(i);
            }
        }
        //Вывод цветов закраски
        for (int h : ans) {
            System.out.println(h + " ");
        }
    }

    //Поиск в глубину с просмотром всех смежных вершин и взятием минимально доступного цвета
    static void dfs(int index) {
        boolean[] m = new boolean[n + 1];

        for (int t : matrix[index]) {
            m[ans[t]] = true; // запоминаем цвета, в которые окрашены соседи
        }

        // пока вершина - не окрашена, перебираем цвета, в которые можно окрасить вершину
        for (int i = 1; ans[index] == 0; i++) {
            if (!m[i]) { // если цвет не занят соседями
                ans[index] = i; // присваиваем вершине цвет
                break;
            }
        }

        // Проходим далее по связям вершины
        for (int t : matrix[index]) {
            if (ans[t] == 0) { // если вершина - не окрашена, то заходим в нее
                dfs(t);
            }
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
