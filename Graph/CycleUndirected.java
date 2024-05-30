import java.util.*;

/**
 * Cycle detection in Un-Directed.
 * 1. BFS
 * 2. DFS
 * 3. Disjoint Set Union
 * 
 * 
 * DFS :
 * case 1 : visited[neighbor] == true but not parent of current node. Than CYCLE
 * exists.
 * case 2 : visited[neighbor] == true but is parent of current node. Cann't say
 * anything.
 * case 3 : visited[neighbor] == false make visited and call visit that
 * recursively returns true. Then CYCLE is exists.
 */
public class CycleUndirected {
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

    boolean detection() {// O(V + E)
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if(detectCycle(visited, i, -1))
                    return true;
            }
        }
        return false;
    }
    boolean detectCycle(boolean[] visited, int current, int parent) {
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            // case 3
            if (!visited[e.dst]) {
                if(detectCycle(visited, e.dst, current))// neighbour told you there is cycle.
                    return true;
            }
            // case 1
            else if (visited[e.dst] && e.dst != parent) {
                return true;
            }
        }
        // case 2 do nothing
        return false;
    }

    public static void main(String[] args) {
        CycleUndirected g = new CycleUndirected();
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

        if (g.detection()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

// ex. 0 - 1 - 2 cycle
//         | /
//         3
//
// ex. 0 - 1 - 2 not cycle
//         | 
//         3  