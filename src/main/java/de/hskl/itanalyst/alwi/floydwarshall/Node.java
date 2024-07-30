package de.hskl.itanalyst.alwi.floydwarshall;

import de.hskl.itanalyst.alwi.general.GeneralNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node extends GeneralNode<Node> {
    public Node(String name) {
        super(name);
    }

    public void addNeighbour(Node neighbour, int edgweight) {
        neighbourNodes.put(neighbour, edgweight);
    }
}
