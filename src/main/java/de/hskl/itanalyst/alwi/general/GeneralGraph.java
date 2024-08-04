package de.hskl.itanalyst.alwi.general;

import lombok.Getter;

import java.util.*;

@Getter
public class GeneralGraph<T extends GeneralNode<T>> {

    protected Map<T, List<GeneralEdge<T>>> edges = new HashMap<>();

    /**
     * Add a new node to build a graph
     *
     * @param node Node
     */
    public void addNewNode(final T node) {
        edges.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Use method when edge is directed to set a single direction from Node to Node
     *
     * @param node1  Source Node of Edge
     * @param node2  Target Node of Edge
     * @param weight Weight of given Edge
     */
    public void addEdge(final T node1, final T node2, final Integer weight) {
        edges.putIfAbsent(node1, new ArrayList<>());
        edges.putIfAbsent(node2, new ArrayList<>());
        edges.get(node1).add(new GeneralEdge<T>(node2, weight));
    }

    /**
     * Use method to simplify an edge implementation for undirected edges
     *
     * @param node1  First Node of Edge
     * @param node2  Second Node of Edge
     * @param weight Weight of Edge
     */
    public void addUndirectedEdge(final T node1, final T node2, final Integer weight) {
        addEdge(node1, node2, weight);
        addEdge(node2, node1, weight);
    }

    /**
     * Get all edges which is linked to a node
     *
     * @param node Node on Edge
     * @return List of Edges linked to a node
     */
    public List<GeneralEdge<T>> getEdgesByNode(final T node) {
        return edges.getOrDefault(node, new ArrayList<>());
    }

    /**
     * Get all Edges in the whole graph
     *
     * @return List of all Edges
     */
    public List<GeneralEdge<T>> getAllEdges() {
        List<GeneralEdge<T>> allEdges = new ArrayList<>();
        for (Map.Entry<T, List<GeneralEdge<T>>> entry : edges.entrySet()) {
            allEdges.addAll(entry.getValue());
        }

        return allEdges;
    }

    /**
     * Get all Nodes contained in the whole graph
     *
     * @return Set of Nodes
     */
    public Set<T> getAllNodes() {
        return edges.keySet();
    }
}
