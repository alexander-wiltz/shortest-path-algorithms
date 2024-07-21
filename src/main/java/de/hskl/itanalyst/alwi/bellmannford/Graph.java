package de.hskl.itanalyst.alwi.bellmannford;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(final Node node) {
        nodes.add(node);
    }
}
