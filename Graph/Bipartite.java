import java.util.*;

/**
 * Bipartite Graph are those graphs each and every edges of nodes u,v or v,u
 * should be in two sets(U,V)
 * that means u and v should not be in same set(U,V).
 * 
 * using modified bfs,
 * 
 * firstly make all graphs as colorless that means -1.
 * 
 * paint first node with red color.
 * 
 * upcoming connected nodes(neighbours) may be colorless or already painted.
 * 
 * case 1 : upcoming connected nodes(neighbours) is colorless then color with
 * blue(different than current).
 * case 2 :
 * case 2.2 : upcoming connected nodes(neighbours) is colored with
 * blue(different) then we cann't judge.
 * case 2.3 : upcoming connected nodes(neighbours) is colored with red(same)
 * then graph is not bipartite.
 * 
 * 
 * Short hand :
 * Acyclic graph is bipartite.
 * Even Length Cyclic graphs are bipartite.
 * Odd Length Cyclic graphs are not bipartite.
 */

public class Bipartite {
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

    boolean isbipartite() {// O(V+E)
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                color[i] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (Edge e : graph[curr]) {
                        if (color[e.dst] == color[curr]) {// same color
                            return false;
                        } else if (color[e.dst] == -1) {// colorless
                            int next_color = color[curr] == 0 ? 1 : 0;// make different than current
                            color[e.dst] = next_color;
                            q.add(e.dst);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Bipartite g = new Bipartite();
        g.create(4);

        // component 1
        g.graph[0].add(new Edge(0, 1, 0));
        g.graph[1].add(new Edge(1, 0, 0));
        g.graph[1].add(new Edge(1, 2, 0));
        g.graph[1].add(new Edge(1, 3, 0));
        g.graph[2].add(new Edge(2, 1, 0));
        g.graph[2].add(new Edge(2, 3, 0));
        g.graph[3].add(new Edge(3, 1, 0));
        g.graph[3].add(new Edge(3, 2, 0));

        if (g.isbipartite()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

// ex. 0 - 1 - 2 is bipartite
// | /
// 3
//
// ex. 0 - 1 - 2 not bipartite
// |
// 3