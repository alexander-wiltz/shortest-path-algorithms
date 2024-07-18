package de.hskl.itanalyst.alwi.bellmannford;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Node {
    private String name;
    private Integer cost = Integer.MAX_VALUE;
    private Node predecessor = null;
    private Map<Node, Integer> neighbourNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbour(Node neighbour, int edgweight) {
        neighbourNodes.put(neighbour, edgweight);
    }

    @Override
    public String toString() {
        return name;
    }
}
