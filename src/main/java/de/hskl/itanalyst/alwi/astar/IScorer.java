package de.hskl.itanalyst.alwi.astar;

public interface IScorer<T> {
    double computeCost(T from, T to);
}
