import java.util.*;
public class Graph {
    
    private ArrayList<ArrayList<Edge>> graph;

    Graph() {
        this.graph = new ArrayList<>();
    }
    
    public static class Edge {
        int src, dest, wgt;
        Edge(int src, int dest, int wgt) {
            this.src = src;
            this.dest = dest;
            this.wgt = wgt;
        }
    }

    void addEdge(int src, int dest, int wgt) {
        // ensure inner lists exist up to index src
        while (graph.size() <= src) {
            graph.add(new ArrayList<>());
        }
        graph.get(src).add(new Edge(src, dest, wgt));
    }
    
    void bfs(int src) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        q.add(src);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (!visited[current]) {
                System.out.println(current);
                visited[current] = true;
                for(int i = 0; i < graph.get(current).size() ; i++) {
                    Edge e = graph.get(current).get(i);
                    if (!visited[e.dest]) {
                        q.add(e.dest);
                    }
                }
            }
        }
    }

    void dfs(int src, boolean[] visited) {
        System.out.println(src);
        visited[src] = true;

        for (int i = 0; i < graph.get(src).size(); i++) {
            Edge e = graph.get(src).get(i);
            if (visited[e.dest] == false) {
                dfs(e.dest, visited);
            }
        }
    }
    

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);

        graph.addEdge(1, 0, 1);
        graph.addEdge(1, 3, 3);

        graph.addEdge(2, 0, 1);
        graph.addEdge(2, 4, 0);

        graph.addEdge(3, 1, 3);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 2);

        graph.addEdge(4, 2, 0);
        graph.addEdge(4, 3, 1);
        graph.addEdge(4, 5, 1);
        
        graph.addEdge(5, 3, 2);
        graph.addEdge(5, 4, 1);
        graph.addEdge(5, 6, 1);

        graph.addEdge(6, 5, 1);

        graph.bfs(0);
        graph.dfs(0, new boolean[graph.graph.size()]);
    }
}