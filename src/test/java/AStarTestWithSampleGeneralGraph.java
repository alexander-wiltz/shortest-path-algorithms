import de.hskl.itanalyst.alwi.astarwithxy.Graph;
import de.hskl.itanalyst.alwi.astarwithxy.Heuristic;
import de.hskl.itanalyst.alwi.astarwithxy.Node;
import de.hskl.itanalyst.alwi.astarwithxy.RouteFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AStarTestWithSampleGeneralGraph {

    private Graph<Node> map;
    private RouteFinder<Node> routeFinder;

    @BeforeEach
    public void init() {
        Set<Node> nodes = new HashSet<>();
        Map<String, Set<String>> connections = new HashMap<>();

        nodes.add(new Node("A", 1.0, 6.0));
        nodes.add(new Node("B", 16.0, 41.0));
        nodes.add(new Node("C", 36.0, 16.0));
        nodes.add(new Node("D", 61.0, 46.0));
        nodes.add(new Node("E", 57.0, 12.0));
        nodes.add(new Node("F", 41.0, 0.0));
        nodes.add(new Node("G", 111.0, 8.0));

        connections.put("A", Stream.of("B", "C", "G").collect(Collectors.toSet()));
        connections.put("B", Stream.of("A", "C", "D").collect(Collectors.toSet()));
        connections.put("C", Stream.of("A", "B", "E", "G").collect(Collectors.toSet()));
        connections.put("D", Stream.of("B", "E", "F").collect(Collectors.toSet()));
        connections.put("E", Stream.of("C", "D", "F", "G").collect(Collectors.toSet()));
        connections.put("F", Stream.of("D", "E", "G").collect(Collectors.toSet()));
        connections.put("G", Stream.of("A", "C", "E", "F").collect(Collectors.toSet()));

        map = new Graph<>(nodes, connections);
        routeFinder = new RouteFinder<>(map, new Heuristic(), new Heuristic());
    }

    @Test
    public void findRoute() {
        List<Node> route = routeFinder.findRoute(map.getNode("A"), map.getNode("F"));
        assertThat(route).size().isPositive();

        route.stream().map(Node::getName).toList().forEach(System.out::println);
    }
}
