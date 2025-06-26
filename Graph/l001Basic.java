import java.util.*;

public class l001Basic {

    public static class Edge {
        int v;
        int w;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return "(" + this.v + ", " + this.w + ") ";
        }
    }

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static boolean hasPath(int src, int des, boolean[] vis){
        if(src==des)
            return true;

        vis[src] = true;
        boolean res = false;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                res = res || hasPath(e.v, des, vis);
            }
        }

        return res;
    }



    public static void main(String[] args) {
        for (int i=0; i<N; i++) graph[i] = new ArrayList<>();
        addEdge(0, 1, 10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 2);
        addEdge(4, 5, 3);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
        // addEdge(2, 5, 5);
        // addEdge(0, 6, 16);
    }
    
}