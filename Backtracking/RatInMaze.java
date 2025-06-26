// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1&selectedLang=python3
import java.util.*;

public class RatInMaze {
    char[] dir_ch = {'U', 'D', 'R', 'L'};
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length, m = maze[0].length;

        ArrayList<String> res = new ArrayList<>();
        if (maze[0][0] == 0) return res;

        boolean[][] vis = new boolean[n][m];
        explore_maze(maze, 0, 0, "", res, vis);

        return res;
    }

    public void explore_maze(int[][] maze, int i, int j, String ans, ArrayList<String> res, boolean[][] vis) {
        int n = maze.length, m = maze[0].length;

        if (i == n - 1 && j == m - 1) {
            res.add(ans);
            return;
        }

        vis[i][j] = true;

        for (int d = 0; d < dir.length; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 1 && !vis[r][c]) {
                explore_maze(maze, r, c, ans + dir_ch[d], res, vis);
            }
        }

        vis[i][j] = false; // backtrack
    }
}