package de.hskl.itanalyst.alwi.astarwithxy;


import de.hskl.itanalyst.alwi.astarwithxy.interfaces.IGraphNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Graph<T extends IGraphNode> {
    private final Set<T> nodes;
    private final Map<String, Set<String>> edges;

    public T getNode(String name) {
        return nodes.stream()
                .filter(node -> node.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Node " + name + " not found"));
    }

    public Set<T> getConnectedNodes(T node) {
        return edges
                .get(node.getName())
                .stream()
                .map(this::getNode)
                .collect(Collectors.toSet());
    }
}
