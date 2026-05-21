public class Experiment {

    public void run() {

        Graph g = new Graph();

        for (int i = 0; i < 6; i++) {
            g.addVertex(i);
        }

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 3);
        g.addEdge(4, 5, 2);

        g.bfs(0);
        g.dfs(0);
        g.dijkstra(0);
    }
}