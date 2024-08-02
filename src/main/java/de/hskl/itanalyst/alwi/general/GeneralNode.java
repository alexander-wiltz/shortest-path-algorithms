package de.hskl.itanalyst.alwi.general;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public abstract class GeneralNode<T> {
    protected String name;

    @Deprecated
    protected Integer distance = Integer.MAX_VALUE;
    @Deprecated
    protected Map<T, Integer> neighbourNodes = new HashMap<>();

    protected GeneralNode(String name) {
        this.name = name;
    }

    @Deprecated
    protected abstract void addNeighbour(T neighbour, int distance);

    @Override
    public String toString() {
        return this.name;
    }
}
