package java_2026.April;

import java.util.LinkedList;
import java.util.Queue;

public class LC18 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0' }, {'1', '1', '0', '1', '0' }, {'1', '1', '0', '0', '0' }, {'0', '0', '0', '0', '0' }}));
    }

    //    public static int numIslands(char[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        boolean[][] visited = new boolean[n][m];
//        int count = 0;
//        Queue<int[]> queue = new LinkedList<>();
//        int[] dx = {1,-1,0,0};
//        int[] dy = {0,0,-1,1};
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1' && !visited[i][j]) {
//                    queue.offer(new int[]{i, j});
//                    visited[i][j] = true;
//                    count++;
//
//                    while (!queue.isEmpty()) {
//                        int[] curr = queue.poll();
//                        for (int k = 0; k < 4; k++) {
//                            int x = curr[0] + dx[k];
//                            int y = curr[1] + dy[k];
//                            if(x<0||y<0||x>=n||y>=m||grid[x][y]=='0'||visited[x][y]) continue;
//                            visited[x][y] = true;
//                            queue.offer(new int[]{x, y});
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }

        // mark visited
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
