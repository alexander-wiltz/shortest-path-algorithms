package de.hskl.itanalyst.alwi.astar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
public class RouteNode<T extends IGraphNode> implements Comparable<RouteNode> {
    private final T currentNode;
    private T previousNode;
    private double routeScore;
    private double estimatedScore;

    public RouteNode(final T currentNode) {
        this.currentNode = currentNode;
        this.previousNode = null;
        this.routeScore = Double.POSITIVE_INFINITY;
        this.estimatedScore = Double.POSITIVE_INFINITY;
    }

    @Override
    public int compareTo(RouteNode other) {
        return Double.compare(this.estimatedScore, other.estimatedScore);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RouteNode.class.getSimpleName() + "[", "]")
                .add("current=" + currentNode)
                .add("previous=" + previousNode)
                .add("routeScore=" + routeScore)
                .add("estimatedScore=" + estimatedScore)
                .toString();
    }
}
