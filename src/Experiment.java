public class Experiment {

    // Run BFS and DFS
    public void runTraversals(Graph g) {

        long startBFS = System.nanoTime();
        g.bfs(0);
        long endBFS = System.nanoTime();

        long bfsTime = endBFS - startBFS;

        long startDFS = System.nanoTime();
        g.dfs(0);
        long endDFS = System.nanoTime();

        long dfsTime = endDFS - startDFS;

        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
    }

    // Multiple tests
    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("\n=========================");
            System.out.println("Graph Size: " + size);
            System.out.println("=========================");

            Graph graph = createGraph(size);

            if (size == 10) {
                graph.printGraph();
            }

            runTraversals(graph);
        }
    }

    // Create graph
    private Graph createGraph(int size) {

        Graph graph = new Graph();

        // Add vertices
        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        // Add edges
        for (int i = 0; i < size - 1; i++) {

            graph.addEdge(i, i + 1);

            // Extra edges
            if (i + 2 < size) {
                graph.addEdge(i, i + 2);
            }
        }

        return graph;
    }

    // Print results
    public void printResults() {

        System.out.println("\nExperiment completed successfully.");
    }
}
