package de.hskl.itanalyst.alwi.general;

import de.hskl.itanalyst.alwi.dijkstra.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class GeneralGraph<N> {
    private Set<N> nodes = new HashSet<>();

    public void addNode(final N node) {
        nodes.add(node);
    }
}
