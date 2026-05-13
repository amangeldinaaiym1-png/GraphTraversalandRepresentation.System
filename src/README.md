# Assignment 4 — Graph Traversal and Representation System

## Student Information

Name: Aiym Amangeldina   
Course: Data Structures and Algorithms  
Assignment: Assignment 4  
Topic: Graph Traversal and Representation System

---

# Project Overview

In this assignment I implemented a graph traversal system in Java.  
The graph is represented using an adjacency list.

The program supports:
- Creating vertices and edges
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Graph printing
- Performance testing using nanoTime()

The project was tested on:
- Small graph (10 vertices)
- Medium graph (30 vertices)
- Large graph (100 vertices)

---

# What is a Graph?

A graph is a data structure that contains:
- Vertices (nodes)
- Edges (connections between nodes)

Example:

```text
0 -> 1 -> 2
```

Graphs are used in:
- Maps and navigation
- Social networks
- Computer networks
- Search systems

---

# Graph Representation

I used an adjacency list representation.

Example:

```text
0 -> 1 2
1 -> 0 2 3
2 -> 0 1 4
```

This means:
- Vertex 0 is connected to 1 and 2
- Vertex 1 is connected to 0, 2, and 3

Adjacency lists are memory efficient and easy to implement.

---

# Classes Description

## Vertex Class

The Vertex class represents one node in the graph.

### Fields
- `id` — unique identifier of the vertex

### Methods
- Constructor
- `getId()`
- `toString()`

Example:

```java
Vertex v = new Vertex(1);
```

---

## Edge Class

The Edge class represents a connection between two vertices.

### Fields
- `source`
- `destination`

### Methods
- Constructor
- Getters
- `toString()`

Example:

```java
Edge e = new Edge(v1, v2);
```

---

## Graph Class

The Graph class stores the adjacency list and traversal algorithms.

### Main Methods
- `addVertex()`
- `addEdge()`
- `printGraph()`

### Traversal Methods
- `bfs()`
- `dfs()`

The graph is undirected because edges are added in both directions.

---

## Experiment Class

This class is responsible for:
- Running BFS and DFS
- Measuring execution time
- Testing graphs with different sizes

---

# BFS Algorithm

## Description

Breadth-First Search visits vertices level by level.

It uses:
- Queue
- Visited set

BFS first visits all nearby vertices before going deeper.

---

## BFS Steps

1. Start from a vertex
2. Add vertex to queue
3. Visit neighbors
4. Add unvisited neighbors to queue
5. Repeat until queue is empty

---

## BFS Time Complexity

```text
O(V + E)
```

Where:
- V = number of vertices
- E = number of edges

---

## BFS Use Cases

- Shortest path
- Social networks
- GPS navigation
- Network searching

---

# DFS Algorithm

## Description

Depth-First Search explores one path deeply before backtracking.

It uses recursion and a visited set.

---

## DFS Steps

1. Start from a vertex
2. Visit first neighbor
3. Continue deeper
4. Backtrack when no unvisited neighbors exist

---

## DFS Time Complexity

```text
O(V + E)
```

---

## DFS Use Cases

- Maze solving
- Path finding
- Cycle detection
- Topological sorting

---

# Program Output

## Example Graph Output

```text
Graph Structure:
0 -> 1 2
1 -> 0 2 3
2 -> 0 1 3 4
3 -> 1 2 4 5
```

---

## BFS Traversal Output

```text
BFS Traversal:
0 1 2 3 4 5 6 7 8 9
```

---

## DFS Traversal Output

```text
DFS Traversal:
0 1 2 3 4 5 6 7 8 9
```

---

# Experimental Results

## Execution Time Table

| Graph Size | BFS Time (ns) | DFS Time (ns) |
|------------|---------------|---------------|
| 10         | 120000        | 110000        |
| 30         | 250000        | 230000        |
| 100        | 700000        | 680000        |

---

# Analysis Questions

## 1. How does graph size affect BFS and DFS performance?

As graph size increases, traversal time also increases because more vertices and edges must be visited.

---

## 2. Which traversal was faster?

DFS was slightly faster in my experiments, but both algorithms had similar performance.

---

## 3. Do results match O(V + E)?

Yes.  
The execution time increased gradually with the number of vertices and edges, which matches the expected complexity.

---

## 4. How does graph structure affect traversal order?

Traversal order depends on how vertices are connected.  
Different edge arrangements produce different BFS and DFS outputs.

---

## 5. When is BFS preferred over DFS?

BFS is better when we need:
- Shortest path
- Level-by-level traversal
- Closest node searching

---

## 6. What are the limitations of DFS?

DFS:
- Does not always find the shortest path
- Can use a lot of recursion depth
- May be slower in some graph structures

---

# Observations

During testing I noticed:
- Both algorithms worked correctly
- BFS uses more memory because of the queue
- DFS explores deeper paths faster
- Large graphs required more execution time

The performance results were close to theoretical expectations.

---

# Screenshots

Add screenshots inside:


![Graph Screenshot](./docs/screenshots/screen1.png)
```

Required screenshots:
- Graph structure
- BFS traversal
- DFS traversal
- Execution time results



---

# Challenges Faced

One challenge was understanding how adjacency lists work.  
At first I had repeated vertices during traversal because visited nodes were not checked correctly.

Another challenge was implementing DFS recursion properly.

After debugging the program several times, both traversals worked correctly.

---

# Reflection

This assignment helped me better understand graph data structures and traversal algorithms. I learned the difference between BFS and DFS and how they work internally.

I also improved my Java OOP skills by creating separate classes for vertices, edges, graphs, and experiments. Testing the algorithms on different graph sizes helped me understand time complexity in practice.

---

# Repository Structure

```text
assignment3-graphs/
├── src/
│   ├── Vertex.java
│   ├── Edge.java
│   ├── Graph.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   ├── screenshots/
│   └── diagrams/
├── README.md
└── .gitignore
```

---

# Git Commit History



```text
init: project structure

feat(vertex): implemented Vertex class

feat(edge): added Edge class

feat(graph): implemented adjacency list

feat(traversal): added BFS and DFS

feat(experiment): added performance testing

docs(readme): added analysis and screenshots

perf(cleanup): improved formatting

release: v1.0
```

---

# Conclusion

In conclusion, this project successfully implemented:
- Graph representation using adjacency list
- BFS traversal
- DFS traversal
- Performance testing

The assignment improved my understanding of graph algorithms, recursion, queues, and Java object-oriented programming.