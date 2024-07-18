package de.hskl.itanalyst.alwi.astarwithedgeweight;

import de.hskl.itanalyst.alwi.astarwithedgeweight.interfaces.IScorer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Heuristic implements IScorer<Node> {

    private Node target;
    private Double maxSpeed;

    public Heuristic(Node target) {
        this.target = target;
        this.maxSpeed = computeMaxSpeed(target);
    }

    @Override
    public Double computeEuclideanDistance(Node from, Node to) {
        double distanceX = to.getX() - from.getX();
        double distanceY = to.getY() - from.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public Double computeDistanceToTarget(Node from, Node to) {
        return 0.0;
    }

    @Override
    public Double computeSpeed(Node from, Node to) {
        return 0.0;
    }

    private Double computeMaxSpeed(Node to) {
        return 0.0;
    }
}
