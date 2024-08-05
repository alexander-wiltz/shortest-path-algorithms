import de.hskl.itanalyst.alwi.dijkstra.Dijkstra;
import de.hskl.itanalyst.alwi.general.GeneralGraph;
import de.hskl.itanalyst.alwi.dijkstra.Node;
import org.junit.jupiter.api.Test;

public class DijkstraTestWithSampleGeneralGraph {

    @Test
    public void setGraph_StartNodeA_TargetNodeF_findWay() {
        GeneralGraph<Node> graph = new GeneralGraph<>();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        graph.addNewNode(nodeA);
        graph.addNewNode(nodeB);
        graph.addNewNode(nodeC);
        graph.addNewNode(nodeD);
        graph.addNewNode(nodeE);
        graph.addNewNode(nodeF);
        graph.addNewNode(nodeG);

        graph.addUndirectedEdge(nodeA, nodeB, 5);
        graph.addUndirectedEdge(nodeA, nodeC, 16);
        graph.addUndirectedEdge(nodeA, nodeG, 7);
        graph.addUndirectedEdge(nodeB, nodeC, 5);
        graph.addUndirectedEdge(nodeB, nodeD, 5);
        graph.addUndirectedEdge(nodeC, nodeE, 8);
        graph.addUndirectedEdge(nodeC, nodeG, 4);
        graph.addUndirectedEdge(nodeD, nodeE, 6);
        graph.addUndirectedEdge(nodeD, nodeF, 7);
        graph.addUndirectedEdge(nodeE, nodeF, 4);
        graph.addUndirectedEdge(nodeE, nodeG, 9);
        graph.addUndirectedEdge(nodeF, nodeG, 11);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computeShortestPaths(graph,nodeA, nodeF);
        dijkstra.showPath();
    }
}
