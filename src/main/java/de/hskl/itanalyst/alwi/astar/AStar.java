package de.hskl.itanalyst.alwi.astar;

import de.hskl.itanalyst.alwi.general.GeneralEdge;
import de.hskl.itanalyst.alwi.general.GeneralGraph;

import java.util.*;

public class AStar {

    private final Map<Node, Node> predecessors = new HashMap<>();
    private final List<Node> shortestPath = new ArrayList<>();

    public void computeShortestPath(GeneralGraph<Node> graph, Node start, Node target) {
        Map<Node, Double> gScores = new HashMap<>();
        Map<Node, Double> fScores = new HashMap<>();
        PriorityQueue<NodeDistance> openSet = new PriorityQueue<>();

        for (Node node : graph.getAllNodes()) {
            gScores.put(node, Double.MAX_VALUE);
            fScores.put(node, Double.MAX_VALUE);
        }

        Map<Node, Double> heuristics = Heuristic.computeHeuristics(graph,target);
        gScores.put(start, 0.0);
        fScores.put(start, heuristics.getOrDefault(start, Double.MAX_VALUE));
        openSet.add(new NodeDistance(start, fScores.get(start)));

        while (!openSet.isEmpty()) {
            NodeDistance current = openSet.poll();
            Node currentNode = current.getNode();

            if (currentNode.equals(target)) {
                printShortestPath(target);
                return;
            }

            for (GeneralEdge<Node> edge : graph.getEdges(currentNode)) {
                Node neighbour = edge.getDestination();
                Double tentativeGScore = gScores.get(currentNode) + edge.getWeight();

                if (tentativeGScore < gScores.get(neighbour)) {
                    predecessors.put(neighbour, currentNode);
                    gScores.put(neighbour, tentativeGScore);
                    fScores.put(neighbour, tentativeGScore + heuristics.getOrDefault(neighbour, Double.MAX_VALUE));
                    openSet.add(new NodeDistance(neighbour, fScores.get(neighbour)));
                }
            }
        }

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
