import java.util.Vector;

public class Runner_MST_Kruskal {
    public static void main(String[] args) {

    }
}

class Edge {
    int U;
    int V;
    int Weight;

    public Edge(int U, int V, int Weight) {
        this.U = U;
        this.V = V;
        this.Weight = Weight;
    }
}

class Graph_MST {
    private int V;
    private Vector<Edge> edges;

    public Graph_MST(int vertices) {
        this.V = vertices;
        edges = new Vector<Edge>();
    }

    public void addEdge(int u, int v, int weight) {
        Edge edge = new Edge(u, v, weight);
        edges.add(edge);
    }

    public void printGraph() {
        for (Edge edge : edges) {
            System.out.println(edge.U + " -- " + edge.V + " == " + edge.Weight);
        }
    }

    public int getV() {
        return V;
    }

    public Vector<Edge> getEdges() {
        return edges;
    }

    public void Kruskal_MST(Graph_MST graph) {

        Vector<Edge> edges = graph.getEdges();
        int V = graph.getV();

        for (int i = 0; i < edges.size() - 1; i++) {
            for (int j = 0; j < edges.size() - i - 1; j++) {
                if (edges.get(j).Weight > edges.get(j + 1).Weight) {

                    Edge temp = edges.get(j);
                    edges.set(j, edges.get(j + 1));
                    edges.set(j + 1, temp);
                }
            }
        }

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        Vector<Edge> mst = new Vector<Edge>();
        int edgeCount = 0;

        // Process edges in sorted order
        for (Edge edge : edges) {
            int uRoot = find(parent, edge.U);
            int vRoot = find(parent, edge.V);

            if (uRoot != vRoot) {
                mst.add(edge);
                union(parent, uRoot, vRoot);
                edgeCount++;

                if (edgeCount == V - 1) {
                    break;
                }
            }
        }

        System.out.println("Edges in Minimum Spanning Tree:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge.U + " -- " + edge.V + " == " + edge.Weight);
            totalWeight += edge.Weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    private void union(int[] parent, int x, int y) {
        parent[y] = x;
    }

    public void Prims_MST(Graph_MST graph) {
        int V = graph.getV();
        Vector<Edge> edges = graph.getEdges();

        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (Edge edge : edges) {
                if (edge.U == u && !mstSet[edge.V] && edge.Weight < key[edge.V]) {
                    parent[edge.V] = u;
                    key[edge.V] = edge.Weight;
                }
            }
        }

        System.out.println("Edges in Minimum Spanning Tree:");
        int totalWeight = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " -- " + i + " == " + key[i]);
            totalWeight += key[i];
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
