import java.util.Scanner;

public class knightMove {
    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void KnightTour() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sr = scn.nextInt();
        int sc = scn.nextInt();
        int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
        int[][] vis = new int[n][n];
        // for(int[] d : vis) Arrays.fill(d,-1);

        knightMove_(sr, sc, 1, n * n, vis, dir);

    }

    public static int knightMove_(int sr, int sc, int move, int tnc, int[][] vis, int[][] dir){
        int n=vis.length, m=vis[0].length;
        if(move == tnc){
            vis[sr][sc] = move;
            displayBoard(vis);
            vis[sr][sc] = 0;

            return 1;
        }

        vis[sr][sc] = move;
        int count = 0;
        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==0)
                count += knightMove_(r, c, move+1, tnc, vis, dir);
        }
        vis[sr][sc] = 0;
        return count;
    }

    public static int knightMoveAgain(int sr, int sc, int move, int tnc, int[][] dir, int[][] vis){
        int n=vis.length, m=vis[0].length;
        // bc
        if(move == tnc){
            vis[sr][sc] = move;
            displayBoard(vis);
            vis[sr][sc] = 0;
            return 1;
        }

        vis[sr][sc] = move;
        int count = 0;
        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==0){
                count += knightMoveAgain(r, c, move+1, tnc, dir, vis);
            }
        }
        vis[sr][sc] = 0;
        return count;
    }
}
