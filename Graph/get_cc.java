import java.util.ArrayList;

public class get_cc {
    public class Edge {
        int v;
        int w;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void dfs_GCC(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                dfs_GCC(graph, e.v, vis);
        }
    }

    // GCC
    // O(E + V)
    public static void getConnectedComponent(ArrayList<Edge>[] graph) {
        int components = 0, N = graph.length;
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                components++;
                dfs_GCC(graph, i, vis);
            }
        }

        System.out.println(components);
    }
    
}
