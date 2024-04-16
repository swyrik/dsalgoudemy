# Graphs

Graphs will have vertices and edges

## Types of Graphs
- Undirected Graphs : these are bidirectional graphs
- Directed Graphs: Uni directional graphs
- Weighted Graphs: weight graphs are denoted using (u::from, v::to, w::cost)
- Tree: a graph with no cycles and undirected ones ( N nodes, N-1 Edges)
- Rooted Trees: where all the nodes either point inwards or outwards of the root (Inward rooted, Outward rooted)
- Directed Acyclic Graph: directed graphs with no cycles
- Bipartite Graph: vertices can be split into two groups where evert edge connects b/w those nodes of groups.
- Complete Graph: A graph in which there is a unique edge between every pair of nodes. A complete graph with n vertices is denoted as graph with Kn

## Representing Graphs

They can be represented in two ways.

- Adjacency Matrix
- Adjacency List

Most of the time it is recommended to use adjacency list.
Because it is cost-effective and uses less space.

## Adjacency Matrix

| pros                             | cons                                             |
|----------------------------------|--------------------------------------------------|
| Space efficient for dense graphs | Requires O(v^2) space                            |
| edge weight lookup is O(1)       | Iterating over all edges takes O(v^2) time <br/> |
| simplest graph representation    |                                                  |

## Adjacency List

| pros                                  | cons                                        |
|:--------------------------------------|---------------------------------------------|
| Space efficient for sparse graphs     | less space efficient for dense graphs       |
| iterating over all edges is efficient | edge weight lookup is O(E)                  |
|                                       | slightly more complex graph representation  |

## Common Graph theory problems

- Shortest Path Problem
  1) Topological Sort
- Connectivity ( can one node be connected to another node)
- Detect cycles in a graph
  1) Bellman Ford
  2) Floyd Marshall
- Strongly connected components
  1) Tarjan's
  2) Kosaraju
- Travelling salesman
  1) Branch and Bound
- Finding bipartite graphs
  1) weak points
- Articulation points
- Minimum Spanning Tree
  1) Kruskals
  2) Prims
  3) Boruvka
- Network FLow: how much flow can we push through a network
  1) Ford fulkerson
  2) Edmonds Karp
  3) Dinic

## BFS: Breadth First Search
- Navigate level wise
- Uses queue to solve the problem

## DFS: Depth First Search
- Navigate the root node followed by a single branch until it's leaf node and backtrack
- Uses stack to solve the problem

## Topological Sort

- If a graph contains cycle we can't perform topological sort.
- we can only perform top sort on Directed Acyclic Graphs
- Using tarjan strongly connected components algorithm we find cycles in a graph.

## Topological sort Algorithm
- Pick an unvisited node
- beginning with the selected node, do a DFS exploring all the unvisited nodes.
- on the recursive call back of the DFS, add the current node to the topological ordering in the reverse order

## Shortest Path (Any weight POSITIVE | NEGATIVE)
- get the top-sort array of the algorithm
- calculate the cost of traversing from start node to it's next node.
- Replace if the cost is lesser than the existing cost.

## Dijkstra Algorithm
- Single source shortest path algorithm for non-negative edge weights
- Time complexity O(E * log(v))
- It uses PriorityQueue to determine which node to visit.
- Stopping Early in Dijkstra
  - you can stop early in dijkstra algo because it always finds the smallest cost while traversing.
- you can use Indexed Priority Queue to improve the performance. O(E*log(e/v)(V))
- The Fibonacci heap can give dijkstra algorithm a time complexity of O(E+ Vlog(V)).
- Fibonacci heap is difficult to implement, and this will be helpful for large graphs.

## BellmanFord Algorithm
- Single source shortest path algorithm is for a graph which has negative edges.
- It can detect negative cycles in a graph.


## Floyd Warshall Algorithm
- Time complexity is O(V^3)
- Better for small graphs
- Good for All Pairs Shortest Path Problem
- It can also detect negative cycles
- 








