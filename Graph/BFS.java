import java.util.*;

public class BFS {
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
    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void BFS_(int src, boolean[] vis){
        int level = 0, cycleCount = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        while(que.size() > 0){
            int size = que.size();
            System.out.println("Level -> " + level);

            // rm*wa*
            while (size-- > 0) {
                int rVtx = que.removeFirst();   // remove
                vis[rVtx] = true;   // mark *

                System.out.println(rVtx);   // work

                if(!vis[rVtx]){     // add*
                    cycleCount++;
                    continue;
                }
                for(Edge e: graph[rVtx]){
                    if(!vis[e.v]){
                        que.addLast(e.v);
                    }
                }
            }
            System.out.println();
            level++;
        }

    }

    public static void main(String[] args) {
        boolean[] vis = new boolean[N];

        BFS_(0, vis);
    }
    
}
