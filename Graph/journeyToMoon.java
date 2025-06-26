import java.util.*;

public class journeyToMoon {

    // journey to the moon
    public static long journeyToMoon_(int n, int[][] astronaut){
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] a: astronaut){
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }

        ArrayList<Integer> sizeArr = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i])
                sizeArr.add(moonDFS(graph, i, vis));
        }

        long ssf = 0, res = 0;
        for(int e: sizeArr){
            res += e * ssf;
            ssf += e;
        }
        return res;
    }

    public static int moonDFS(ArrayList<Integer>[] graph, int src, boolean[] vis){
        vis[src] = true;
        int size = 0;
        for(Integer e: graph[src]){
            if(!vis[e]) moonDFS(graph, e, vis);
        }

        return size + 1;
    }


    public static void main(String[] args) {
        
    }
}