package de.hskl.itanalyst.alwi.general;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralEdge<T> {
    protected T destination;
    protected Integer weight;
}
