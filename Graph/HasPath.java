import java.util.*;
public class HasPath {

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
    boolean hasPath(int start, int end, boolean[] visited) {// O(V + E) dfs 
        if (start == end) return true;
        
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            Edge edge = graph[start].get(i);
            if (!visited[edge.dst] && hasPath(edge.dst, end, visited)) {
                return true;
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        HasPath g = new HasPath();
        g.create(4);
        g.graph[0].add(new Edge(0, 1, 0));
        g.graph[1].add(new Edge(1, 0, 0));
        g.graph[1].add(new Edge(1, 2, 0));
        g.graph[1].add(new Edge(1, 3, 0));
        g.graph[2].add(new Edge(2, 1, 0));
        g.graph[2].add(new Edge(2, 3, 0));
        g.graph[3].add(new Edge(3, 1, 0));
        g.graph[3].add(new Edge(3, 2, 0));

        if(g.hasPath(0, 2,new boolean[g.graph.length])) 
            System.out.println("yes");
        else 
            System.out.println("no");
    }
}
