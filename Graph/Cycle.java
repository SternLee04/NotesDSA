import java.util.*;

public class Cycle extends Graph {

    public boolean hasPath(int src, int dest, boolean[] visited) {
        if (src == dest)
            return true;

        if (visited[src] == false) {
            visited[src] = true;

            for (int i = 0; i < graph.get(src).size(); i++) {
                Edge e = graph.get(src).get(i);
                if (visited[e.dest] == false) {
                    if (hasPath(e.dest, dest, visited) == true)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycleDfs(int current, int previous, boolean[] visited) {
        if (visited[current] == false) {
            visited[current] = true;

            for (int i = 0; i < graph.get(current).size(); i++) {
                Edge e = graph.get(current).get(i);
                if (visited[e.dest] == false) {
                    if (detectCycleDfs(e.dest, current, visited) == true) {
                        return true;
                    } else if (visited[e.dest] == true && e.dest != previous) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean detectCycleDirected(int current, boolean[] visited, boolean[] stack) {
        visited[current] = true;
        stack[current] = true;// expilicit that exactly same as implicit.

        for (int i = 0; i < graph.get(current).size(); i++) {
            Edge e = graph.get(current).get(i);
            if (stack[e.dest] == true) {
                return true;
            }
            if (visited[e.dest] == false) {
                if (detectCycleDirected(e.dest, visited, stack)) {
                    return true;
                }
            }
        }

        stack[current] = false;
        return false;
    }

    public static void main(String[] args) {
        Cycle graph = new Cycle();
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

        System.out.println(graph.hasPath(0, 0, new boolean[graph.graph.size()]) ? "yes" : "no");

        Cycle graphCycle = new Cycle();

        graphCycle.addEdge(0, 1, 0);
        graphCycle.addEdge(0, 2, 0);
        graphCycle.addEdge(1, 3, 0);
        graphCycle.addEdge(2, 3, 0);

        System.out.println(graphCycle.detectCycleDirected(0, new boolean[graphCycle.graph.size()], new boolean[graphCycle.graph.size()]) ? "yes" : "no");
    }
}
