import java.util.Vector;

abstract class Graph {
    abstract void addEdge(int u, int v);

    abstract void printGraph();
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

    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
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
    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
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
