package lab3.bonus;

import java.util.*;

public class Graph {
    /**
     * number of vertices
     */
    private int numberOfVerticies;
    /**
     * adjacency list
     */
    private LinkedList<Integer>[] adj;
    /**
     * variable to keep track of time
     */
    private int time;
    /**
     * discovery time of vertices
     */
    private int[] disc;
    /**
     * earliest visited vertex that can be reached from subtree rooted with current vertex
     */
    private int[] low;
    /**
     * visited vertices
     */
    private boolean[] visited;
    /**
     * articulation points
     */
    private boolean[] ap;

    // constructor
    public Graph(int v) {
        numberOfVerticies = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
        time = 0;
        disc = new int[v];
        low = new int[v];
        visited = new boolean[v];
        ap = new boolean[v];
    }

    // function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void findArticulationPoints() {
        // apeleaza DFS pt fiecare nod nevizitat
        for (int i = 0; i < numberOfVerticies; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }
    }

    /***
     *itereaza prin nodurile adiacente cu u
     *u is an articulation point if one of the following two conditions is true:
     * case 1. u is the root of the DFS tree and it has two or more children
     * case 2. u is not the root of the DFS tree and low[v] >= disc[u]
     * check if subtree rooted with v has a connection to one of the ancestors of u
     // update low value of u for parent function calls
     */
    private void dfs(int u, int parent) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int childCount = 0;

        Iterator<Integer> it = adj[u].iterator();
        while (it.hasNext()) {
            int v = it.next();
            if (!visited[v]) {
                childCount++;
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (parent == -1 && childCount > 1 || parent != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public void printArticulationPoints() {
        System.out.println("Articulation points in the graph:");
        for (int i = 0; i < numberOfVerticies; i++) {
            if (ap[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}

