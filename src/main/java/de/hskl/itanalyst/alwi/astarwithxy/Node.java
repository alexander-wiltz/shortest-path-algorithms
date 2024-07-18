package de.hskl.itanalyst.alwi.astarwithxy;


import de.hskl.itanalyst.alwi.astarwithxy.interfaces.IGraphNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node implements IGraphNode {
    private String name;
    private Double x;
    private Double y;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}