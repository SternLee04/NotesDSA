import java.util.*;
public class Graph {

    public static class Edge {
        int src, dest, wgt;
        Edge(int src, int dest, int wgt) {
            this.src = src;
            this.dest = dest;
            this.wgt = wgt;
        }
    }

    public ArrayList<ArrayList<Edge>> graph;

    Graph() {
        this.graph = new ArrayList<>();
    }
    

    void addEdge(int src, int dest, int wgt) {
        // ensure inner lists exist up to index src
        while (graph.size() <= src) {
            graph.add(new ArrayList<>());
        }
        graph.get(src).add(new Edge(src, dest, wgt));
    }

    void connectedBfs() {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                bfs(i, visited);
            }
        }
    }
    void bfs(int src, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

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
    
    void connectedDfs() {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                dfs(i, visited);
            }
        }
    }
    void dfs(int src, boolean[] visited) {
        if (visited[src] == false) {   
            System.out.println(src);
            visited[src] = true;
    
            for (int i = 0; i < graph.get(src).size(); i++) {
                Edge e = graph.get(src).get(i);
                if (visited[e.dest] == false) {
                    dfs(e.dest, visited);
                }
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

        graph.connectedBfs();
        graph.connectedDfs();
    }
}
