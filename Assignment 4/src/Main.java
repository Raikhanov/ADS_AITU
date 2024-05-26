public class Main {
    public static void main(String[] args) {
        WeightedGraph<Vertex> graph = new WeightedGraph<>();

        Vertex v1 = new Vertex("1", "Almaty");
        Vertex v2 = new Vertex("2", "Astana");
        Vertex v3 = new Vertex("3", "Shymkent");
        Vertex v4 = new Vertex("4", "Pavlodar");
        Vertex v5 = new Vertex("5", "Oral");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v1, v2, 10);
        graph.addEdge(v1, v3, 20);
        graph.addEdge(v2, v4, 30);
        graph.addEdge(v2, v5, 40);
        graph.addEdge(v4, v5, 50);

        graph.printGraph();

        Search<Vertex> bfs = new BreadthFirstSearch<>(graph);
        System.out.println("BFS from Almaty to Pavlodar: " + bfs.search(v1, v4));

        Search<Vertex> dijkstra = new DijkstraSearch<>(graph);
        System.out.println("Dijkstra from Almaty to Pavlodar: " + dijkstra.search(v1, v4));
    }
}