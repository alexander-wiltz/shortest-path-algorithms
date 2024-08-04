package de.hskl.itanalyst.alwi.bellmannford;

import de.hskl.itanalyst.alwi.general.GeneralEdge;
import de.hskl.itanalyst.alwi.general.GeneralGraph;

import java.util.*;

public class BellmanFord {

    private Map<Node, Node> predecessors = new HashMap<>();
    private List<Node> shortestPath = new ArrayList<>();

    public void computeShortestPath(GeneralGraph<Node> graph, Node start, Node target) {
        Map<Node, Integer> distances = new HashMap<>();

        for (Node node : graph.getAllNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        List<GeneralEdge<Node>> edges = graph.getAllEdges();

        for (int i = 1; i < graph.getAllNodes().size(); i++) {
            for (GeneralEdge<Node> edge : edges) {
                Node u = getSourceNode(edge, graph);
                Node v = edge.getDestination();
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + edge.getWeight() < distances.get(v)) {
                    distances.put(v, distances.get(u) + edge.getWeight());
                    predecessors.put(v, u);
                }
            }
        }

        // Negative cycle detection
        for (GeneralEdge<Node> edge : edges) {
            Node u = getSourceNode(edge, graph);
            Node v = edge.getDestination();
            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + edge.getWeight() < distances.get(v)) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        printShortestPath(target);
    }

    private Node getSourceNode(GeneralEdge<Node> edge, GeneralGraph<Node> graph) {
        for (Node node : graph.getAllNodes()) {
            for (GeneralEdge<Node> e : graph.getEdgesByNode(node)) {
                if (e == edge) {
                    return node;
                }
            }
        }

        return null;
    }

    private void printShortestPath(Node currentNode) {
        while (currentNode != null) {
            shortestPath.add(currentNode);
            currentNode = predecessors.get(currentNode);
        }

        Collections.reverse(shortestPath);
    }

    public void showPath() {
        System.out.println(shortestPath);
    }
}
