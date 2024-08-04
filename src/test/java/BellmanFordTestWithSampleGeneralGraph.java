import de.hskl.itanalyst.alwi.bellmannford.BellmanFord;
import de.hskl.itanalyst.alwi.bellmannford.Node;
import de.hskl.itanalyst.alwi.general.GeneralGraph;
import org.junit.jupiter.api.Test;

public class BellmanFordTestWithSampleGeneralGraph {

    @Test
    public void setGraph_StartNodeA_findWay() {
        GeneralGraph<Node> graph = new GeneralGraph<>();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        graph.addNewNode(nodeA);
        graph.addNewNode(nodeB);
        graph.addNewNode(nodeC);
        graph.addNewNode(nodeD);
        graph.addNewNode(nodeE);
        graph.addNewNode(nodeF);

        graph.addEdge(nodeA, nodeB, 4);
        graph.addEdge(nodeA, nodeD, 3);
        graph.addEdge(nodeB, nodeC, 5);
        graph.addEdge(nodeB, nodeE, 4);
        graph.addEdge(nodeC, nodeB, 5);
        graph.addEdge(nodeC, nodeF, -2);
        graph.addEdge(nodeD, nodeA, 4);
        graph.addEdge(nodeD, nodeE, 3);
        graph.addEdge(nodeE, nodeB, -3);
        graph.addEdge(nodeE, nodeD, 3);
        graph.addEdge(nodeE, nodeF, 2);
        graph.addEdge(nodeF, nodeC, 4);

        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.computeShortestPath(graph, nodeA, nodeF);
        bellmanFord.showPath();
    }
}
