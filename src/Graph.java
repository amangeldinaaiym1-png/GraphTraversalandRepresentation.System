import java.util.*;

public class Graph {

    // Adjacency list
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add vertex
    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // Add edge
    public void addEdge(int from, int to) {

        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());

        adjacencyList.get(from).add(to);

        // Undirected graph
        adjacencyList.get(to).add(from);
    }

    // Print graph
    public void printGraph() {

        System.out.println("Graph Structure:");

        for (Integer vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (Integer neighbor : adjacencyList.get(vertex)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    // BFS traversal
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (Integer neighbor : adjacencyList.get(current)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // DFS traversal
    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsRecursive(start, visited);

        System.out.println();
    }

    // Recursive DFS helper
    private void dfsRecursive(int current, Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (Integer neighbor : adjacencyList.get(current)) {

            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
}