package de.hskl.itanalyst.alwi.general;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class GeneralGraph<T extends GeneralNode<T>> {
    protected Set<T> nodes = new HashSet<>();

    public void addNode(final T node) {
        nodes.add(node);
    }
}
