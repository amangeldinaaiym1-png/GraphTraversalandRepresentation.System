import java.util.*;

public class Graph {

    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }


    public void addVertex(int v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {

        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());

        adjacencyList.get(from).add(new Edge(to, weight));
        adjacencyList.get(to).add(new Edge(from, weight)); // undirected
    }

    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();
            System.out.print(current + " ");

            for (Edge e : adjacencyList.get(current)) {

                int neighbor = e.getDestination();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS: ");
        dfsRec(start, visited);
        System.out.println();
    }

    private void dfsRec(int current, Set<Integer> visited) {

        visited.add(current);
        System.out.print(current + " ");

        for (Edge e : adjacencyList.get(current)) {

            int neighbor = e.getDestination();

            if (!visited.contains(neighbor)) {
                dfsRec(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {

        int n = adjacencyList.size();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        // set infinity
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {

            int u = getMin(dist, visited);
            visited[u] = true;

            for (Edge e : adjacencyList.get(u)) {

                int v = e.getDestination();
                int weight = e.getWeight();

                if (!visited[v]
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;
                }
            }
        }

        System.out.println("Dijkstra from " + start + ":");

        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
    }

    private int getMin(int[] dist, boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < dist.length; i++) {

            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }

        return index;
    }
}