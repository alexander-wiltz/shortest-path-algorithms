package de.hskl.itanalyst.alwi.astarwithxy.interfaces;

public interface IScorer<T> {
    double computeCost(T from, T to);
}
