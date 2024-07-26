package de.hskl.itanalyst.alwi.general;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class GeneralGraph<T extends GeneralNode<T>> {
    private Set<T> nodes = new HashSet<>();

    public void addNode(final T node) {
        nodes.add(node);
    }

    public Optional<Integer> edgeValue(String i, String j) {
        Integer value = Integer.MAX_VALUE;

        T node = nodes.stream().filter(t -> t.getName().equals(i)).findFirst().orElse(null);
        if (node != null) {
            for (Map.Entry<T, Integer> neighbour : node.getNeighbourNodes().entrySet()) {
                if (neighbour.getKey().getName().equals(j)) {
                    value = neighbour.getValue();
                }
            }
        }

        return value.describeConstable();
    }
}
