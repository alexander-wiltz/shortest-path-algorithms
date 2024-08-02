package de.hskl.itanalyst.alwi.general;

import lombok.Getter;

import java.util.*;

@Getter
public class GeneralGraph<T extends GeneralNode<T>> {
    @Deprecated
    protected Set<T> nodes = new HashSet<>();
    protected Map<T, List<GeneralEdge<T>>> edges = new HashMap<>();

    @Deprecated
    public void addNode(final T node) {
        nodes.add(node);
    }

    /**
     * Add a new node to build a graph
     * @param node Node
     */
    public void addNewNode(final T node) {
        edges.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Use method when edge is directed to set a single direction from Node to Node
     * @param node1 Source Node of Edge
     * @param node2 Target Node of Edge
     * @param weight Weight of given Edge
     */
    public void addEdge(final T node1, final T node2, final Integer weight) {
        edges.putIfAbsent(node1, new ArrayList<>());
        edges.putIfAbsent(node2, new ArrayList<>());
        edges.get(node1).add(new GeneralEdge<T>(node2, weight));
    }

    /**
     * Use method to simplify an edge implementation for undirected edges
     * @param node1 First Node of Edge
     * @param node2 Second Node of Edge
     * @param weight Weight of Edge
     */
    public void addUndirectedEdge(final T node1, final T node2, final Integer weight) {
        addEdge(node1, node2, weight);
        addEdge(node2, node1, weight);
    }

    public List<GeneralEdge<T>> getEdges(final T node) {
        return edges.getOrDefault(node, new ArrayList<>());
    }

    public Set<T> getAllNodes() {
        return edges.keySet();
    }
}
