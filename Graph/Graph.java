import java.util.*;

public class Graph {

    private ArrayList<ArrayList<Edge>> graph;

    public static class Edge {
        int src, dest, wgt;

        Edge(int src, int dest, int wgt) {
            this.src = src;
            this.dest = dest;
            this.wgt = wgt;
        }
    }

    Graph() {
        this.graph = new ArrayList<>();
    }

    public int getSize() {
        return graph.size();
    }

    void addEdge(int src, int dest, int wgt) {
        // ensure inner lists exist up to index src
        while (graph.size() <= src) {
            graph.add(new ArrayList<>());
        }
        graph.get(src).add(new Edge(src, dest, wgt));
    }

    void bfs(int src, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (!visited[current]) {
                System.out.println(current);
                visited[current] = true;
                for (int i = 0; i < graph.get(current).size(); i++) {
                    Edge e = graph.get(current).get(i);
                    if (!visited[e.dest]) {
                        q.add(e.dest);
                    }
                }
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
}