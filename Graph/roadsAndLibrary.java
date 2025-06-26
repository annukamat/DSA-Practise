import java.util.*;

public class roadsAndLibrary {

    // https://www.hackerrank.com/challenges/torque-and-development/problem
    public long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        if (c_road >= c_lib) return (long) c_lib * n;

        // create graph
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (List<Integer> e : cities) {
            int u = e.get(0) - 1; // - 1 for zero based indexing
            int v = e.get(1) - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int gcc = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                gcc_dfs(graph, i, vis);
                gcc++;
            }
        }

        return (long)(c_lib * gcc) + (long)(c_road * (n - gcc));
    }

    public void gcc_dfs(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        vis[src] = true;

        for (int nbr : graph[src]) {
            if (!vis[nbr]) gcc_dfs(graph, nbr, vis);
        }
    } 

    public static void main(String[] args) {
        
    }
}
