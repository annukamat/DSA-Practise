import java.util.*;

public class hamiltonianPath {
    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return "(" + this.v + ", " + this.w + ") ";
        }
    }

    public static void hamiltonianPath_(ArrayList<Edge>[] graph, int src, int osrc, boolean[] visited, int noOfEdges){
        if(noOfEdges == N-1){
            int idx = findEdge(src, osrc);
            if(idx != -1) System.out.println("*");

            System.out.println();
            return;
        }

        visited[src] = true;
        for(Edge e: graph[src]){
            if(!visited[e.v]){
                hamiltonianPath_(graph, e.v, osrc, visited, noOfEdges);
            }
        }
        visited[src] = false;

    }

    public static int findEdge(int u, int v) {
        for (int i = 0; i < graph[u].size(); i++) {
            Edge e = graph[u].get(i);
            if (e.v == v)
                return i;
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
    }
}
