import de.hskl.itanalyst.alwi.astar.AStar;
import de.hskl.itanalyst.alwi.astar.Node;
import de.hskl.itanalyst.alwi.general.GeneralGraph;
import org.junit.jupiter.api.Test;

public class AStarTestWithSampleGeneralGraph {

    @Test
    public void setGraph_StartNodeA_TargetNodeF_findWay() {
        GeneralGraph<Node> graph = new GeneralGraph<>();
        Node nodeA = new Node("A", 1.0, 6.0);
        Node nodeB = new Node("B", 16.0, 41.0);
        Node nodeC = new Node("C", 36.0, 16.0);
        Node nodeD = new Node("D", 61.0, 46.0);
        Node nodeE = new Node("E", 57.0, 12.0);
        Node nodeF = new Node("F", 111.0, 8.0);
        Node nodeG = new Node("G", 41.0, 0.0);

        graph.addNewNode(nodeA);
        graph.addNewNode(nodeB);
        graph.addNewNode(nodeC);
        graph.addNewNode(nodeD);
        graph.addNewNode(nodeE);
        graph.addNewNode(nodeF);
        graph.addNewNode(nodeG);

        graph.addUndirectedEdge(nodeA, nodeB, 19);
        graph.addUndirectedEdge(nodeA, nodeC, 73);
        graph.addUndirectedEdge(nodeA, nodeG, 35);
        graph.addUndirectedEdge(nodeB, nodeC, 27);
        graph.addUndirectedEdge(nodeB, nodeD, 23);
        graph.addUndirectedEdge(nodeC, nodeE, 43);
        graph.addUndirectedEdge(nodeC, nodeG, 14);
        graph.addUndirectedEdge(nodeD, nodeE, 29);
        graph.addUndirectedEdge(nodeD, nodeF, 31);
        graph.addUndirectedEdge(nodeE, nodeF, 27);
        graph.addUndirectedEdge(nodeE, nodeG, 100);
        graph.addUndirectedEdge(nodeF, nodeG, 60);

        AStar aStar = new AStar();
        aStar.computeShortestPath(graph, nodeA, nodeF);
        aStar.showPath();
    }
}
