import java.util.*;
/**
 * Types : edges and weights
 * edges : 
 *      1. uni - direction ex. a -> b
 *      2. un - direction or bi - direction ex. a - b 
 * weights : edge has values
 *      ex. 1 --3--> 4 or 5 --3-- 1
 * 
 * Representation :
 *      1. Adjacency List
 *      2. Adjacency Matrix
 *      3. Edge List
 *      4. 2D Matrix (Implicit Graph)
 */
public class TypesGraph {

    /**
     * Representation
     * 
     * ex. 0 - 1 - 2
     *         | /
     *         3
     */
    static class Representation {
    
        static class Edge {
            int src;
            int dest;
            int weight;
            public Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }

        // Adjacency list also done usin hashmap. key = vertex, value = list edges.
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        public void createAdjList() { // search O(k)
            graph[0] = new ArrayList<>();
            graph[1] = new ArrayList<>();
            graph[2] = new ArrayList<>();
            graph[3] = new ArrayList<>();

            graph[0].add(new Edge(0, 1, 0));
            graph[1].add(new Edge(1, 0, 0));
            graph[1].add(new Edge(1,2, 0));
            graph[1].add(new Edge(1,3, 0));
            graph[2].add(new Edge(2, 1, 0));
            graph[2].add(new Edge(2, 3, 0));
            graph[3].add(new Edge(3, 1, 0));
            graph[3].add(new Edge(3, 2, 0));
        }
        HashMap<Integer, ArrayList<Edge>> graph2 = new HashMap<>();
        public void createAdjList2() {
            graph2.put(0, new ArrayList<>());
            graph2.put(1, new ArrayList<>());
            graph2.put(2, new ArrayList<>());
            graph2.put(3, new ArrayList<>());

            graph2.get(0).add(new Edge(0, 1, 0));
            graph2.get(1).add(new Edge(1, 0, 0));
            graph2.get(1).add(new Edge(1,2, 0));
            graph2.get(1).add(new Edge(1,3, 0));
            graph2.get(2).add(new Edge(2, 1, 0));
            graph2.get(2).add(new Edge(2, 3, 0));
            graph2.get(3).add(new Edge(3, 1, 0));
            graph2.get(3).add(new Edge(3, 2, 0));
        }

        // Adjacency matrix colum == source row == destination value == 0 not exist and 1 is exist.
        int[][] adjList = { // serach O(vertices ^ 2)
            {0, 1, 0, 0},
            {1, 0, 1, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
        };

        // edge list 
        int[][] edgeList = { {0,1}, {1,2}, {1,3}, {2,3} };// {src, dst, wgt}

        // 2D matrix { Implicit graph } just visualization.
        // ex. flood fill algorithm
    }
}