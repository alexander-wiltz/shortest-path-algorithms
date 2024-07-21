import de.hskl.itanalyst.alwi.bellmannford.BellmanFord;
import de.hskl.itanalyst.alwi.bellmannford.Graph;
import de.hskl.itanalyst.alwi.bellmannford.Node;
import org.junit.jupiter.api.Test;

public class BellmanFordTestWithSampleGraph {

    @Test
    public void setGraphAndStartNodeA_findWay() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNeighbour(nodeB, 4);
        nodeA.addNeighbour(nodeD, 3);

        nodeB.addNeighbour(nodeC,5);
        nodeB.addNeighbour(nodeE, 4);

        nodeC.addNeighbour(nodeB, 5);
        nodeC.addNeighbour(nodeF, -2);

        nodeD.addNeighbour(nodeA, 4);
        nodeD.addNeighbour(nodeE, 3);

        nodeE.addNeighbour(nodeB, -3);
        nodeE.addNeighbour(nodeD, 3);
        nodeE.addNeighbour(nodeF, 2);

        nodeF.addNeighbour(nodeC, 4);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.findShortestPath(graph, "A", "f");
    }
}
