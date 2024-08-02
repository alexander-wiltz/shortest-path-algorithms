package de.hskl.itanalyst.alwi.dijkstra;

import de.hskl.itanalyst.alwi.general.GeneralNode;
import lombok.Getter;

@Getter
public class Node extends GeneralNode<Node> {

    public Node(String name) {
        super(name);
    }

    @Override
    protected void addNeighbour(Node neighbour, int distance) {

    }
}