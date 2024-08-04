package de.hskl.itanalyst.alwi.general;

import lombok.Getter;
import lombok.Setter;

@Setter
public abstract class GeneralNode<T> {
    protected String name;

    protected GeneralNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
