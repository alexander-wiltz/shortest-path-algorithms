package de.hskl.itanalyst.alwi.astar;

import de.hskl.itanalyst.alwi.general.GeneralNode;
import lombok.Getter;

@Getter
public class Node extends GeneralNode<Node> {
    private final Double x;
    private final Double y;

    public Node(String name, Double x, Double y) {
        super(name);
        this.x = x;
        this.y = y;
    }

    @Override
    protected void addNeighbour(Node neighbour, int distance) {

    }
}
