package de.hskl.itanalyst.alwi.general;

import de.hskl.itanalyst.alwi.dijkstra.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public abstract class GeneralNode {
    protected String name;
    protected Integer distance = Integer.MAX_VALUE;
    protected Map<Node, Integer> neighbourNodes = new HashMap<>();

    protected GeneralNode(String name) {
        this.name = name;
    }

    protected abstract void addNeighbour(Node neighbour, int distance);

}
