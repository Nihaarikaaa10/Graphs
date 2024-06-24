import java.util.*;

class Pair {
    int u;
    int v;
    Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

class PairW {
    Pair p;
    int steps;
    PairW(Pair p, int steps) {
        this.p = p;
        this.steps = steps;
    }
}

class Solution {

    static boolean isSafe(int x, int y, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        return (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && !vis[x][y]);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        }

        int n = grid.length;
        Queue<PairW> queue = new LinkedList<>();
        queue.add(new PairW(new Pair(0, 0), 1));
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        while (!queue.isEmpty()) {
            PairW current = queue.poll();
            int x = current.p.u;
            int y = current.p.v;
            int steps = current.steps;

            if (x == n - 1 && y == n - 1) {
                return steps;
            }

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (isSafe(nx, ny, grid, vis)) {
                    vis[nx][ny] = true;
                    queue.add(new PairW(new Pair(nx, ny), steps + 1));
                }
            }
        }

        return -1;
    }
}
