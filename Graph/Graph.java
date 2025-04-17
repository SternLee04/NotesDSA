import java.util.*;
public class Graph {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    
    public static void bfs(ArrayList<Edge>[] graph, int V) {
        Queue<Integer> queue = new LinkedList<>();// to keep track will want to traverse next node.
        boolean[] visited = new boolean[V];// to keep track that same node not visit twice and fall under cycle.
        
        // queue.add(graph[0].get(0).src);
        queue.add(0);
        while (queue.isEmpty() == false) {
            Integer currentNode = queue.poll();
            if (visited[currentNode] == false) {
                // print the node
                System.out.print(currentNode + " ");
                // mark current visted.
                visited[currentNode] = true;
                // add all neighbors to queue.
                for (int i = 0; i < graph[currentNode].size(); i++) {
                    Edge edge = graph[currentNode].get(i);
                    queue.add(edge.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int V, int currentNode, boolean[] visted) {
        System.out.print(currentNode + " ");// print the node.
        visted[currentNode] = true;// mark current visted.

        for(int i = 0 ; i < graph[currentNode].size(); i++) {
            Edge edge = graph[currentNode].get(i);
            if (visted[edge.dest] == false) {
                dfs(graph, V, edge.dest, visted);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 2, 3));

        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 3, 3));
        
        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 4, 3));
        graph[3].add(new Edge(3, 5, 3));

        graph[4].add(new Edge(4, 2,3));
        graph[4].add(new Edge(4, 3, 3));
        graph[4].add(new Edge(4, 5, 3));

        graph[5].add(new Edge(5, 3, 3));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        
        bfs(graph, V);
        System.out.println();
        dfs(graph, V, 0, new boolean[V]);
    }
}