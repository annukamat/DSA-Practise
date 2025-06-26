import java.util.*;

public class EvenTree {
    static int removableEdges;

    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        // Initialize
        removableEdges = 0;

        // create graph
        ArrayList<Integer>[] graph = new ArrayList[t_nodes];

        for(int i=0; i<t_nodes; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<t_edges; i++){
            int u = t_from.get(i) - 1;
            int v = t_to.get(i) - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        // call dfs to count removable edges
        boolean[] vis = new boolean[t_nodes];
        dfs(graph, 0, vis);

        return removableEdges;
    }

    public static int dfs(ArrayList<Integer>[] graph, int src, boolean[] vis){
        vis[src] = true;

        int size = 1;
        for(int e: graph[src]){
            if(!vis[e]){
                int subTreeSize = dfs(graph, e, vis);
                if(subTreeSize%2 == 0) removableEdges++;
                else size += subTreeSize;
            }
        }
        return size;
    }
    
    public static void main(String[] args) {
        List<Integer> from = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> to =   Arrays.asList(1, 1, 3, 2, 1, 2, 6, 8, 8);
        System.out.println(evenForest(10, 9, from, to)); // Output: 2
    }
}
