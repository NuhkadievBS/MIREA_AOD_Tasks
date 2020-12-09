package task_5;

import java.util.Scanner;

public class GraphDriver {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        /** Граф из варианта 19 */
        g.addEdge(0, 1, 8);
        g.addEdge(0, 2, 4);

        g.addEdge(1, 3, 6);
        g.addEdge(1, 4, 3);

        g.addEdge(2, 1, 3);
        g.addEdge(2, 3, 2);
        g.addEdge(2, 5, 10);

        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 1);

        g.addEdge(4, 5, 4);
        /****************************************/

        /**
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Graph graph = new Graph(n);
        for(int i = 0; i < n; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        System.out.println(graph);
        */

        System.out.println(g);
        System.out.println(g.decisionTreeSearch(0, 4));

    }

}
