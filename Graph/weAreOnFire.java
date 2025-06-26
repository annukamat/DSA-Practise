// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/we-are-on-fire/
// n,m: grid dimension, q: no. of fireball attack

public class weAreOnFire {
    int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };

    public void FireballAttacks(int[][] grid, int q, int[][] attack){
        int n = grid.length, m = grid[0].length;

        int totalNations = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) totalNations++;
            }
        }

        for (int i = 0; i < q; i++) {
            int x = attack[i][0] - 1; // convert to 0-based
            int y = attack[i][1] - 1;

            if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                int burnt = dfs(grid, x, y);
                totalNations -= burnt;
            }

            System.out.println(totalNations);
        }
    }

    public int dfs(int[][] grid, int x, int y){
        int n = grid.length, m = grid[0].length;

        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != 1)
            return 0;

        grid[x][y] = -1; // mark as burnt
        int size = 1;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            size += dfs(grid, nx, ny);
        }

        return size;
    }
}