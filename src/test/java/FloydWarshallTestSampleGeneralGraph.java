import de.hskl.itanalyst.alwi.floydwarshall.FloydWarshall;
import de.hskl.itanalyst.alwi.floydwarshall.Node;
import de.hskl.itanalyst.alwi.general.GeneralGraph;
import org.junit.jupiter.api.Test;

public class FloydWarshallTestSampleGeneralGraph {

    @Test
    public void setGraphAndStartNodeA_findWay() {
        GeneralGraph<Node> graph = new GeneralGraph<>();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        graph.addNewNode(nodeA);
        graph.addNewNode(nodeB);
        graph.addNewNode(nodeC);
        graph.addNewNode(nodeD);
        graph.addNewNode(nodeE);

        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeC, 6);
        graph.addEdge(nodeD, nodeC, 7);
        graph.addEdge(nodeD, nodeC, 2);
        graph.addEdge(nodeD, nodeE, 4);
        graph.addEdge(nodeE, nodeA, 3);
        graph.addEdge(nodeE, nodeB, 5);

        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.computeShortestPath(graph, nodeD, nodeB);
        floydWarshall.printDistanceMatrix();
        floydWarshall.showPath();
    }
}
