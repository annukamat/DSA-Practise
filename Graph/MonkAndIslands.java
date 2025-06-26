// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/
// n = no. of islands, m = no. of bridges
import java.util.*;

public class MonkAndIslands {

    public static int minDistance(ArrayList<Integer>[] graph, int n, int m) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(1);
        dist[1] = 0;

        // bfs
        while (!que.isEmpty()) {
            int rvtx = que.removeFirst();

            for (int nbr : graph[rvtx]) {
                if (dist[nbr] == -1) {
                    dist[nbr] = dist[rvtx] + 1;
                    que.addLast(nbr);
                }
            }
        }

        return dist[n];
    }

}
