package de.hskl.itanalyst.alwi.astar;

import de.hskl.itanalyst.alwi.general.GeneralGraph;

import java.util.HashMap;
import java.util.Map;

public class Heuristic {

    // average Speed calculated by Euclidean distance
    // between node D and node F (distance divided by weight)
    private static final Double vMAX = 2.0258;

    /**
     * Calculate costs from current node to given target node.
     * Euclidean Distance multiplied with given maximum speed
     *
     * @param graph  Graph
     * @param target Target Node
     * @return Map with costs from all nodes in graph to target Node
     */
    public static Map<Node, Double> computeHeuristics(GeneralGraph<Node> graph, Node target) {
        Map<Node, Double> heuristics = new HashMap<>();
        Double distance = null;
        Double cost = null;

        for (Node currentNode : graph.getAllNodes()) {
            if (currentNode.equals(target)) {
                heuristics.putIfAbsent(currentNode, 0.0);
            }

            distance = computeEuclideanDistance(currentNode, target);
            cost = distance / vMAX;
            heuristics.put(currentNode, cost);
        }

        return heuristics;
    }

    /**
     * Computing the Euclidean Distance between two nodes
     *
     * @param from first node
     * @param to   second node
     * @return distance as double
     */
    private static Double computeEuclideanDistance(Node from, Node to) {
        double distanceX = to.getX() - from.getX();
        double distanceY = to.getY() - from.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
}
