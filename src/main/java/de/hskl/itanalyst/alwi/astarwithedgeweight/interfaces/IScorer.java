package de.hskl.itanalyst.alwi.astarwithedgeweight.interfaces;

public interface IScorer<T> {
    Double computeEuclideanDistance(T from, T to);
    Double computeDistanceToTarget(T from, T to);
    Double computeSpeed(T from, T to);
}
