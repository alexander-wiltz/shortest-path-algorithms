package de.hskl.itanalyst.alwi.astar;

public class Heuristic implements IScorer<Node> {
    @Override
    public double computeCost(Node from, Node to) {
        double distanceX = to.getX() - from.getX();
        double distanceY = to.getY() - from.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
}
