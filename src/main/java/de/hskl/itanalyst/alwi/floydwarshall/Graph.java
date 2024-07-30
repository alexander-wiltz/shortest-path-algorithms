package de.hskl.itanalyst.alwi.floydwarshall;

import de.hskl.itanalyst.alwi.general.GeneralGraph;

import java.util.Map;
import java.util.Optional;

public class Graph extends GeneralGraph<Node> {

    public Graph() {
        super();
    }

    public Optional<Integer> edgeValue(String i, String j) {
        Integer value = Integer.MAX_VALUE;

        Node node = nodes.stream().filter(t -> t.getName().equals(i)).findFirst().orElse(null);
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
