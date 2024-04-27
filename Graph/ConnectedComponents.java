import java.util.*;

/**
 * ConnectedComponents
 * It is possible that threre is no completely connection is not exist.
 * 
 * ex. 0 - 1 - 2    4 - 5
 *         | /
 *         3
 * here 2 connected components in graph.
 * 
 * simply create visited outside and traverse to cover all vertices.
 */
public class ConnectedComponents {
    ArrayList<Edge>[] graph;

    static public class Edge {

        int src, dst, wgt;

        public Edge(int src, int dst, int wgt) {
            this.src = src;
            this.dst = dst;
            this.wgt = wgt;
        }
    }

    void create(int v) {
        this.graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            this.graph[i] = new ArrayList<>();
        }
    }
    void dfs() {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsutil(i, visited);
        }
    }
    public void dfsutil(int curr, boolean[] visited) {

            System.out.print(curr + " ");
            visited[curr] = true;
 
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!visited[e.dst]) {
                    dfsutil(e.dst, visited);
                }
            }
        }
    
    void bfs() {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsutil(visited);
            }
        }
    }
    public void bfsutil(boolean[] visited) {
            Queue<Integer> q = new LinkedList<>();

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
    public static void main(String[] args) {
        ConnectedComponents g = new ConnectedComponents();
        g.create(6);

        // component 1
        g.graph[0].add(new Edge(0, 1, 0));
        g.graph[1].add(new Edge(1, 0, 0));
        g.graph[1].add(new Edge(1, 2, 0));
        g.graph[1].add(new Edge(1, 3, 0));
        g.graph[2].add(new Edge(2, 1, 0));
        g.graph[2].add(new Edge(2, 3, 0));
        g.graph[3].add(new Edge(3, 1, 0));
        g.graph[3].add(new Edge(3, 2, 0));
        // component 2
        g.graph[4].add(new Edge(4,5,0));
        g.graph[5].add(new Edge(5,4,0));
        
        g.dfs();
    }
}