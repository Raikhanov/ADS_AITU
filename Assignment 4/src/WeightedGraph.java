
import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(new Edge<>(destination, weight));
        adjacencyList.get(destination).add(new Edge<>(source, weight));
    }

    public List<Edge<Vertex>> getEdges(Vertex vertex) {
        return adjacencyList.get(vertex);
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge<Vertex>>> entry : adjacencyList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + " connected to: ");
            for (Edge<Vertex> edge : entry.getValue()) {
                System.out.print(edge.getDestination() + " (weight " + edge.getWeight() + "), ");
            }
            System.out.println();
        }
    }
}

class Edge<Vertex> {
    private Vertex destination;
    private double weight;

    public Edge(Vertex destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}