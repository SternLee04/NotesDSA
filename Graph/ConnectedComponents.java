import java.util.*;
public class ConnectedComponents extends Graph {

    public void componentsBfs() {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < visited.length; i++) {
            bfs(i, visited);
        }
    }

    public void componentsDfs() {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < visited.length; i++) {
            dfs(i, visited);
        }
    }

    public static void main(String[] args) {
        ConnectedComponents graph = new ConnectedComponents();
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

        // graph.componentsBfs();
        graph.componentsDfs();
    }
}