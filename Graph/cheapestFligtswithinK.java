// https://leetcode.com/problems/cheapest-flights-within-k-stops/
import java.util.*;

public class cheapestFligtswithinK {
    public class Edge {
        int v;
        int w;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public class Pair{
        int u;
        int cost;
        Pair(int u, int cost){
            this.u = u;
            this.cost = cost;
        }
    }

    public void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(v, w));
    }

    public void createGraph(ArrayList<Edge>[] graph, int[][] flights){
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            addEdge(graph, u, v, w);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flights);
        
        int[] costArr = new int[n];
        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[src] = 0;

        LinkedList<Pair> que = new LinkedList<>();
        que.add(new Pair(src, 0));

        int levels = 0;

        while (!que.isEmpty() && levels <= k) {
            int size = que.size();
            int[] tempCost = Arrays.copyOf(costArr, n); // Level-based copy

            while (size-- > 0) {
                Pair curr = que.poll();
                int u = curr.u;
                int cost = curr.cost;

                for (Edge e : graph[u]) {
                    if (cost + e.w < tempCost[e.v]) {
                        tempCost[e.v] = cost + e.w;
                        que.add(new Pair(e.v, cost + e.w));
                    }
                }
            }

            costArr = tempCost; // Commit updates after level
            levels++;
        }

        return costArr[dst] == Integer.MAX_VALUE ? -1 : costArr[dst];
    }


    
}