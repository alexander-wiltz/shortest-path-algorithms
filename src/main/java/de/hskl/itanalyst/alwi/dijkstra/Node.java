package de.hskl.itanalyst.alwi.dijkstra;

import de.hskl.itanalyst.alwi.general.GeneralNode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
public class Node extends GeneralNode<Node> {
    private List<Node> shortestPath = new LinkedList<>();

    public Node(String name) {
        super(name);
    }

    @Override
    public void addNeighbour(Node neighbour, int distance) {
        this.neighbourNodes.put(neighbour, distance);
    }
}