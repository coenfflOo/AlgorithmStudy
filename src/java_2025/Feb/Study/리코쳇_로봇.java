package java_2025.Feb.Study;

import java.util.*;

class 리코쳇_로봇 {
    private static int n,m;
    private static String[][] map;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new String[n][m];

        Point robot = null;
        for(int i=0; i<n; i++){
            map[i] = board[i].split("");
            for(int j=0; j<m; j++){
                if(map[i][j].equals("R")){
                    robot = new Point(i,j);
                }
            }
        }
        // for(String[] mp: map){
        //     System.out.println(Arrays.toString(mp));
        // }

        int answer = moveBFS(robot);
        return answer;
    }

    private static int moveBFS(Point robot){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(robot);
        visited[robot.i][robot.j] = true;

        int cnt = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point p = queue.poll();

                out: for(int k=0; k<4; k++){
                    int ni = p.i;
                    int nj = p.j;
                    while(true){
                        ni += dx[k];
                        nj += dy[k];
                        if(impossibleMove(ni,nj))
                            break;
                    }
                    ni -= dx[k];
                    nj -= dy[k];

                    if(visited[ni][nj])
                        continue;

                    if(map[ni][nj].equals("G"))
                        return cnt;
                    visited[ni][nj]=true;
                    queue.offer(new Point(ni,nj));
                }
            }
            cnt++;
            // for(boolean[] v: visited){
            //     System.out.println(Arrays.toString(v));
            // }
            // System.out.println("=====================");
        }
        return -1;
    }

    private static boolean impossibleMove(int i, int j){
        return i<0 || j<0 || i>=n ||j>=m || map[i][j].equals("D");
    }

    private static class Point{
        int i;
        int j;

        public Point(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
}
