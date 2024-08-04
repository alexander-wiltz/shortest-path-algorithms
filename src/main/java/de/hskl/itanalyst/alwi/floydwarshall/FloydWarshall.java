package de.hskl.itanalyst.alwi.floydwarshall;


import de.hskl.itanalyst.alwi.general.GeneralEdge;
import de.hskl.itanalyst.alwi.general.GeneralGraph;

import java.util.*;

public class FloydWarshall {

    private final Map<Node, Map<Node, Integer>> distances = new HashMap<>();
    private final Map<Node, Map<Node, Node>> matrix = new HashMap<>();
    private final List<Node> shortestPath = new ArrayList<>();

    public void computeShortestPath(GeneralGraph<Node> graph, Node start, Node target) {
        Set<Node> nodes = graph.getAllNodes();
        for (Node u : nodes) {
            distances.put(u, new HashMap<>());
            matrix.put(u, new HashMap<>());
            for (Node v : nodes) {
                if (u.equals(v)) {
                    distances.get(u).put(v, 0);
                } else {
                    distances.get(u).put(v, Integer.MAX_VALUE);
                }
                matrix.get(u).put(v, null);
            }
        }

        for (Node u : nodes) {
            for (GeneralEdge<Node> edge : graph.getEdgesByNode(u)) {
                distances.get(u).put(edge.getDestination(), edge.getWeight());
                matrix.get(u).put(edge.getDestination(), edge.getDestination());
            }
        }

        for (Node k : nodes) {
            for (Node i : nodes) {
                for (Node j : nodes) {
                    if (distances.get(i).get(k) != Integer.MAX_VALUE && distances.get(k).get(j) != Integer.MAX_VALUE) {
                        int newDist = distances.get(i).get(k) + distances.get(k).get(j);
                        if (newDist < distances.get(i).get(j)) {
                            distances.get(i).put(j, newDist);
                            matrix.get(i).put(j, matrix.get(i).get(k));
                        }
                    }
                }
            }
        }

        Node current = start;
        while (current != null) {
            shortestPath.add(current);
            if (current.equals(target)) {
                break;
            }
            current = matrix.get(current).get(target);
        }
    }

    public void printDistanceMatrix() {
        Set<Node> nodes = distances.keySet();
        System.out.print(" | ");
        for (Node node : nodes) {
            System.out.print(node + "   | ");
        }
        System.out.println();

        for (Node u : nodes) {
            System.out.print(u + "| ");
            for (Node v : nodes) {
                if (distances.get(u).get(v) == Integer.MAX_VALUE) {
                    System.out.print("INF | ");
                } else {
                    StringBuilder value = new StringBuilder();
                    value.append(distances.get(u).get(v).toString());
                    value.append(" ".repeat(Math.max(0, 3 - value.length())));
                    value.append(" | ");
                    System.out.print(value);
                }
            }

            System.out.println();
        }
    }

    public void showPath() {
        System.out.println(shortestPath);
    }
}
