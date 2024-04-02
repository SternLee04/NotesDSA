import java.util.*;
/**
 * Traversals : BFS and DFS T(V+E)
 * 
 * BFS :
 *      1. goto immediately neighbors first.
 *      2. print node and put D.S that holds visited nodes (as cycles are there in graph.)
 *      3. put in neighbors in queue.
 * DFS :
 *      1. goto first neighbor.
 *      2. print node and put D.S that holds visited nodes
 *      3. then move to next neighbor and print if not visited.
 */

public class Traversals {
    static class Edge {
        int src, dst, wgt;
        
        public Edge(int src, int dst, int wgt) {
            this.src = src;
            this.dst = dst;
            this.wgt = wgt;
        }
    }

    static public class Graph {
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

        public void bfs() {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[graph.length];

            q.add(0);
            visited[0] = true;
            while (!q.isEmpty()) {
                int curr = q.remove();
                System.out.print(curr + " ");

                for (Edge e : graph[curr]) {
                    if (!visited[e.dst]) {
                        q.add(e.dst);
                        visited[e.dst] = true;
                    }
                }
            }
        }
        public void dfs(int curr, boolean[] visited) {

            System.out.print(curr + " ");
            visited[curr] = true;
 
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!visited[e.dst]) {
                    dfs(e.dst, visited);
                }
            }
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

        g.bfs();
        System.out.println();
        g.dfs(0, new boolean[g.graph.length]);
    }
}
