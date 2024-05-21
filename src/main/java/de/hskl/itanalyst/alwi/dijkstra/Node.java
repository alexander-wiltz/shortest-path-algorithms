package de.hskl.itanalyst.alwi.dijkstra;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Node {
    private String name;
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> neighbourNodes = new HashMap<>();

    private List<Node> shortestPath = new LinkedList<>();

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbour(Node neighbour, int distance) {
        neighbourNodes.put(neighbour, distance);
    }

    @Override
    public String toString() {
        return name;
    }
}