import java.util.*;

public class Coloring extends Graph {

    // each and every node's neighbors should be exist in another set.
    // if neighbour exist in same set the graph is not bipartite.
    // for acyclic and even cycle is true and for odd cycle is false;
    public boolean isBipartite(int src) {
        int[] color = new int[graph.size()];// -1 no-color, 0 yellow, 1 blue.
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while (q.isEmpty() == false) {
            Integer current = q.poll();

            for (int i = 0; i < graph.get(current).size(); i++) {
                Edge edge = graph.get(current).get(i);
                if (color[edge.dest] == -1) {
                    int nextCol = color[current] == 0 ? 1 : 0;
                    color[edge.dest] = nextCol;
                    q.add(edge.dest);
                } else if (color[edge.dest] == color[current])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Coloring graph = new Coloring();
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

        System.out.println(graph.isBipartite(0) ? "yes" : "no");
    }
}