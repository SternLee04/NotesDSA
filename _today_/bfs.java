import java.util.*;
/**
 * bfs
 */
public class bfs {

    public static class Edge {
        
        int src, dst, wgt;
        public Edge(int src, int dst, int wgt) {
            this.src = src;
            this.dst = dst;
            this.wgt = wgt;
        }
    }

    public static class Graph {
        ArrayList<Edge>[] graph;

        public Graph(int v) {
            this.graph = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                graph[i] = new ArrayList<>();
            }
        }
        public void addEdge(int src, int dst, int wgt) {
            graph[src].add(new Edge(src, dst, wgt));
        }

        public boolean hasPath(int src, int dst) {
            return path(src, dst, new boolean[graph.length]);
        }
        public boolean path(int src, int dst, boolean[] visited) {
            if (src == dst) return true;
            visited[src] = true;
            for (Edge edge : graph[src]) {
                if (! visited[edge.dst] && path(edge.dst, dst, visited)) {
                    return true;
                }
            }

            return false;
        }

        public boolean hasPathBFS(int src, int dst) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[graph.length];

            q.add(src);
            visited[src] = true;
            while (!q.isEmpty()) {
                int node = q.poll();
                if (node == dst) return true;
                for (Edge edge : graph[node]) {
                    if (!visited[edge.dst]) {
                        q.add(edge.dst);
                        visited[edge.dst] = true;
                    }
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 0);
        g.addEdge(1, 0, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(1, 3, 0);
        g.addEdge(2, 1, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(3, 1, 0);
        g.addEdge(3, 2, 0);

        System.out.println(g.hasPath(2, 3) ? "yes" : "no");
        System.out.println(g.hasPathBFS(2, 3) ? "yes" : "no");
    }
}