import de.hskl.itanalyst.alwi.dijkstra.Dijkstra;
import de.hskl.itanalyst.alwi.general.GeneralGraph;
import de.hskl.itanalyst.alwi.dijkstra.Node;
import org.junit.jupiter.api.Test;

public class DijkstraTestWithSampleGeneralGraph {

    @Test
    public void setGraphAndStartNodeA_findWay() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.addNeighbour(nodeB, 5);
        nodeA.addNeighbour(nodeC, 16);
        nodeA.addNeighbour(nodeG, 7);

        nodeB.addNeighbour(nodeA, 5);
        nodeB.addNeighbour(nodeC, 5);
        nodeB.addNeighbour(nodeD, 5);

        nodeC.addNeighbour(nodeA, 16);
        nodeC.addNeighbour(nodeB, 5);
        nodeC.addNeighbour(nodeE, 8);
        nodeC.addNeighbour(nodeG, 4);

        nodeD.addNeighbour(nodeB, 5);
        nodeD.addNeighbour(nodeE, 6);
        nodeD.addNeighbour(nodeF, 7);

        nodeE.addNeighbour(nodeC, 8);
        nodeE.addNeighbour(nodeD, 6);
        nodeE.addNeighbour(nodeF, 4);
        nodeE.addNeighbour(nodeG, 9);

        nodeF.addNeighbour(nodeD, 7);
        nodeF.addNeighbour(nodeE, 4);
        nodeF.addNeighbour(nodeG, 11);

        nodeG.addNeighbour(nodeA, 7);
        nodeG.addNeighbour(nodeC, 4);
        nodeG.addNeighbour(nodeE, 9);
        nodeG.addNeighbour(nodeF, 11);

        GeneralGraph<Node> graph = new GeneralGraph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePath(graph, nodeF);

        System.out.println(nodeA.getShortestPath() + " =>target: A");
    }
}
