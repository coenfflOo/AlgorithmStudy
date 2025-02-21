package java_2025.Feb.Study;
import java.util.*;
public class 게임_맵_최단거리 {
    private static int n,m;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        int answer = bfs(maps);
        return answer;
    }

    private static int bfs(int[][] maps){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Point(0,0));
        visited[0][0] = true;

        int cnt = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point p = queue.poll();
                for(int k=0;k<4;k++){
                    int ni = p.i+dx[k];
                    int nj = p.j+dy[k];

                    if(ni<0||nj<0||ni>=n||nj>=m||visited[ni][nj]||maps[ni][nj]==0) continue;

                    if(ni==n-1&&nj==m-1)
                        return cnt+1;
                    queue.offer(new Point(ni,nj));
                    visited[ni][nj] = true;
                }
            }
            cnt++;
        }
        return -1;
    }

    private static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
