// DSU - Disjoint Set Union
import java.util.Scanner;

public class DSU {
    int[] parent;
    int[] size;

    // find(): To determine if two elements belong to the same connected component (i.e., same set).

    // Without Path Compression (basic version):
    public int find(int[] par, int x){
        if(par[x] == x) return x;
        return find(par, par[x]);
    }

    // union
    public void union(int x, int y, int[] par){
        int x_par = find(par, x);
        int y_par = find(par, y);

        if(x_par != y_par){
            par[x_par] = y_par;
        }
    }

    // union by size
    public void union_(int x, int y){
        int x_par = find(parent, x);
        int y_par = find(parent, y);

        if(x_par == y_par) return;
        if(size[x_par] < size[y_par]){
            parent[x_par] = y_par;
            size[y_par] += size[x_par];
        }else {
            parent[y_par] = x_par;
            size[x_par] += size[y_par];
        }
    }

    // With Path Compression (optimized version):
    public int find_(int[] par, int x){
        
    }




    public void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        int rootA = find(parent, 3);
        int rootB = find(parent, 4);
    }

}