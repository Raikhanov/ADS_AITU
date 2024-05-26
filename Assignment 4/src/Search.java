
import java.util.*;

public interface Search<Vertex> {
    List<Vertex> search(Vertex start, Vertex end);
}

class BreadthFirstSearch<Vertex> implements Search<Vertex> {
    private WeightedGraph<Vertex> graph;

    public BreadthFirstSearch(WeightedGraph<Vertex> graph) {
        this.graph = graph;
    }

    @Override
    public List<Vertex> search(Vertex start, Vertex end) {
        Map<Vertex, Vertex> cameFrom = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.equals(end)) {
                return constructPath(cameFrom, start, end);
            }

            for (Edge<Vertex> edge : graph.getEdges(current)) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    cameFrom.put(neighbor, current);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Vertex> constructPath(Map<Vertex, Vertex> cameFrom, Vertex start, Vertex end) {
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex at = end; at != null; at = cameFrom.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}

class DijkstraSearch<Vertex> implements Search<Vertex> {
    private WeightedGraph<Vertex> graph;

    public DijkstraSearch(WeightedGraph<Vertex> graph) {
        this.graph = graph;
    }

    @Override
    public List<Vertex> search(Vertex start, Vertex end) {
        Map<Vertex, Double> distances = new HashMap<>();
        Map<Vertex, Vertex> cameFrom = new HashMap<>();
        PriorityQueue<VertexDistance<Vertex>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        Set<Vertex> visited = new HashSet<>();

        distances.put(start, 0.0);
        priorityQueue.add(new VertexDistance<>(start, 0.0));

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll().getVertex();

            if (visited.contains(current)) continue;
            visited.add(current);

            if (current.equals(end)) {
                return constructPath(cameFrom, start, end);
            }

            for (Edge<Vertex> edge : graph.getEdges(current)) {
                Vertex neighbor = edge.getDestination();
                double newDist = distances.get(current) + edge.getWeight();

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    cameFrom.put(neighbor, current);
                    priorityQueue.add(new VertexDistance<>(neighbor, newDist));
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Vertex> constructPath(Map<Vertex, Vertex> cameFrom, Vertex start, Vertex end) {
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex at = end; at != null; at = cameFrom.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}

class VertexDistance<Vertex> {
    private Vertex vertex;
    private double distance;

    public VertexDistance(Vertex vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public double getDistance() {
        return distance;
    }
}