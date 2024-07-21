package de.hskl.itanalyst.alwi.floydwarshall;

import lombok.Getter;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Getter
public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(final Node node) {
        nodes.add(node);
    }

    public Optional<Integer> edgeValue(String i, String j) {
        Integer value = Integer.MAX_VALUE;

        Node node = nodes.stream().filter(n -> n.getName().equals(i)).findFirst().orElse(null);
        if (node != null) {
            for (Map.Entry<Node, Integer> neighbour : node.getNeighbourNodes().entrySet()) {
                if (neighbour.getKey().getName().equals(j)) {
                    value = neighbour.getValue();
                }
            }
        }

        return value.describeConstable();
    }
}
