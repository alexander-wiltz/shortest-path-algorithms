package de.hskl.itanalyst.alwi.astar;

import lombok.Getter;

@Getter
public class NodeDistance implements Comparable<NodeDistance> {
    private final Node node;
    private final Double distance;

    public NodeDistance(Node node, Double distance) {
        this.node = node;
        this.distance = distance;
    }

   @Override
    public int compareTo(NodeDistance other) {
        return Double.compare(this.distance, other.distance);
    }
}
