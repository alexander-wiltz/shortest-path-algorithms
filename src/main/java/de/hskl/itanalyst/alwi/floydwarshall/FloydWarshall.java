package de.hskl.itanalyst.alwi.floydwarshall;

import java.util.Optional;

public class FloydWarshall {

    private int[][] costs;
    private int[][] successors;

    public void computeWay(Graph graph) {
        int size = graph.getNodes().size();
        buildAndInitMatrices(graph);

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int costViaNodeK = addCosts(costs[i][k], costs[k][j]);
                    if (costViaNodeK < costs[i][j]) {
                        costs[i][j] = costViaNodeK;
                        successors[i][j] = successors[i][k];
                    }
                }
            }
        }

        printSolution(costs);
        printSolution(successors);
    }

    private void buildAndInitMatrices(Graph graph) {
        int size = graph.getNodes().size();
        costs = new int[size][size];
        successors = new int[size][size];

        Node[] nodes = graph.getNodes().toArray(new Node[size]);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Optional<Integer> edgeValue = graph.edgeValue(nodes[i].getName(), nodes[j].getName());
                costs[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
                successors[i][j] = edgeValue.isPresent() ? j : -1;
            }
        }
    }

    private int addCosts(int a, int b) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return a + b;
    }

    private void printSolution(int[][] dist) {
        for (int i = 0; i < dist.length; ++i) {
            for (int j = 0; j < dist.length; ++j) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
