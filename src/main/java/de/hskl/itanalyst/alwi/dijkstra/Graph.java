package de.hskl.itanalyst.alwi.dijkstra;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(final Node node) {
        nodes.add(node);
    }
}
