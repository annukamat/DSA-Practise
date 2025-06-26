import java.util.ArrayList;
import java.util.LinkedList;

public class courseSchedule {
    public class Edge{
        int v = 0;
        Edge(int v){
            this.v = v;
        }
    }

    public void addEdge(ArrayList<Edge>[] graph, int u, int v){
        graph[u].add(new Edge(v));
    }

    public void createGraph(ArrayList<Edge>[] graph, int numCourses, int[][] prerequisites){
        // initialise graph with arraylist
        for(int i=0; i<numCourses; i++)
            graph[i] = new ArrayList<>();

        for(int[] pre: prerequisites){
            int u = pre[1];
            int v = pre[0];

            addEdge(graph, u, v);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph, numCourses, prerequisites);

        // calculate indegree
        int[] indegree = new int[numCourses];
        for(int i=0; i<graph.length; i++){
            for(Edge e: graph[i]){
                indegree[e.v]++;
            }
        }

        // bfs
        LinkedList<Integer> que = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0) que.addLast(i);
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while(!que.isEmpty()){
            int rVtx = que.removeFirst();
            ans[idx++] = rVtx;
            
            for(Edge e: graph[rVtx]){
                indegree[e.v]--;
                if(indegree[e.v] == 0) que.addLast(e.v);
            }
        }

        return idx == numCourses ? ans : new int[0];
    }
    
}
