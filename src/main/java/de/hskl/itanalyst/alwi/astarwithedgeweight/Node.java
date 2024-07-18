package de.hskl.itanalyst.alwi.astarwithedgeweight;

import de.hskl.itanalyst.alwi.astarwithedgeweight.interfaces.IGraphNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Node implements IGraphNode {
    private String name;
    private Double x;
    private Double y;
    private Map<Node, Double> neighbours = new HashMap<>();

    public void addNeighbour(Node node, Double weight) {
        this.neighbours.put(node, weight);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
