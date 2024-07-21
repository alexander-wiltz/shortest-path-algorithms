import de.hskl.itanalyst.alwi.floydwarshall.FloydWarshall;
import de.hskl.itanalyst.alwi.floydwarshall.Graph;
import de.hskl.itanalyst.alwi.floydwarshall.Node;
import org.junit.jupiter.api.Test;

public class FloydWarshallTestSampleGraph {

    @Test
    public void setGraphAndStartNodeA_findWay() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addNeighbour(nodeB, 1);
        nodeB.addNeighbour(nodeC, 6);
        nodeC.addNeighbour(nodeB, 7);
        nodeD.addNeighbour(nodeC, 2);
        nodeD.addNeighbour(nodeE, 4);
        nodeE.addNeighbour(nodeA, 3);
        nodeE.addNeighbour(nodeB, 5);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.computeWay(graph);
    }
}
