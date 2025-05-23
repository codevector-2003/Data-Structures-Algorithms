import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

abstract class Graph {
    abstract void addEdge(int u, int v);

    abstract void addEdge(int u, int v, int weight);

    abstract void printGraph();

    abstract void DFS(int start);

    abstract void BFS(int Start);
}

class Undirected_Graph extends Graph {
    Vector<Vector<Integer>> adj;

    public Undirected_Graph(int vertices) {
        adj = new Vector<Vector<Integer>>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new Vector<Integer>());
        }
    }

    @Override
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    @Override
    public void addEdge(int u, int v, int weight) {
        addEdge(u, v); // For unweighted graph, ignore weight
    }

    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void BFS(int start) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
            }
            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i);
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public void DFS(int Start) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(Start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
            }
            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }

}

class Directed_Graph extends Graph {
    Vector<Vector<Integer>> adj;

    public Directed_Graph(int vertices) {
        adj = new Vector<Vector<Integer>>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new Vector<Integer>());
        }
    }

    @Override
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    @Override
    public void addEdge(int u, int v, int weight) {
        addEdge(u, v);
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void DFS(int start) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
            }
            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }

    @Override
    public void BFS(int start) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
            }
            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i);
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
    }
}

class Weighted_Graph extends Graph {
    int[][] adj;

    public Weighted_Graph(int vertices) {
        adj = new int[vertices][vertices];
    }

    @Override
    public void addEdge(int u, int v) {
        addEdge(u, v, 1);
    }

    @Override
    public void addEdge(int u, int v, int weight) {
        adj[u][v] = weight;
        adj[v][u] = weight;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                System.out.print(i + " " + j + " " + adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void DFS(int start) {
        boolean[] visited = new boolean[adj.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
            }
            for (int i = 0; i < adj[node].length; i++) {
                if (adj[node][i] != 0 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    @Override
    public void BFS(int start) {
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
            }
            for (int i = 0; i < adj[node].length; i++) {
                if (adj[node][i] != 0 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    public void prims() {
        int V = adj.length;
        int[] parent = new int[V]; // Array to store MST
        int[] key = new int[V]; // Key values to pick minimum weight edge
        boolean[] mstSet = new boolean[V]; // Vertices included in MST

        // Initialize all keys as infinite
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Start with first vertex
        key[0] = 0;
        parent[0] = -1; // First node is root of MST

        // Construct MST with V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick minimum key vertex not yet included in MST
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            // Update key and parent of adjacent vertices
            for (int v = 0; v < V; v++) {
                // Update only if:
                // - There is an edge from u to v
                // - v is not in MST
                // - Edge weight is smaller than current key
                if (adj[u][v] != 0 && !mstSet[v] && adj[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = adj[u][v];
                }
            }
        }

        // Print the MST
        printMST(parent);
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < adj.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        int totalWeight = 0;
        for (int i = 1; i < adj.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + adj[i][parent[i]]);
            totalWeight += adj[i][parent[i]];
        }
        System.out.println("Total MST Weight: " + totalWeight);
    }
}

public class Runner_Graph {
    public static void main(String args[]) {
        Undirected_Graph g = new Undirected_Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.printGraph();
    }

}
