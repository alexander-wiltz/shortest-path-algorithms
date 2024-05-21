package de.hskl.itanalyst.alwi.astar;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class RouteFinder<T extends IGraphNode> {
    private final Graph<T> graph;
    private final IScorer<T> nextNodeScorer;
    private final IScorer<T> targetScorer;

    public List<T> findRoute(T from, T to) {
        Map<T, RouteNode<T>> allNodes = new HashMap<>();
        Queue<RouteNode> openSet = new PriorityQueue<>();

        RouteNode<T> start = new RouteNode<>(from, null, 0d, targetScorer.computeCost(from, to));
        allNodes.put(from, start);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            RouteNode<T> next = openSet.poll();
            if (next.getCurrentNode().equals(to)) {
                List<T> route = new ArrayList<>();
                RouteNode<T> current = next;
                do {
                    route.add(0, current.getCurrentNode());
                    current = allNodes.get(current.getPreviousNode());
                } while (current != null);

                return route;
            }

            graph.getConnectedNodes(next.getCurrentNode()).forEach(connection -> {
                double newScore = next.getRouteScore() + nextNodeScorer.computeCost(next.getCurrentNode(), connection);
                RouteNode<T> nextNode = allNodes.getOrDefault(connection, new RouteNode<>(connection));
                allNodes.put(connection, nextNode);

                if (nextNode.getRouteScore() > newScore) {
                    nextNode.setPreviousNode(next.getCurrentNode());
                    nextNode.setRouteScore(newScore);
                    nextNode.setEstimatedScore(newScore + targetScorer.computeCost(connection, to));
                    openSet.add(nextNode);
                }
            });
        }

        throw new IllegalStateException("No route found");
    }
}
