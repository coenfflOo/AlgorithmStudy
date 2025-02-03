package java_2025.Feb.Study;

import java.util.*;
class 미로_탈출 {
    static int n,m;
    static String[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new String[n][m];
        Point start = null;
        Point lebber = null;
        for(int i=0; i<n; i++){
            map[i] = maps[i].split("");
            for(int j=0; j<m; j++){
                if(map[i][j].equals("S"))
                    start = new Point(i,j);
                else if(map[i][j].equals("L"))
                    lebber = new Point(i,j);
            }
        }

        int answer = findLebber(start);
        if(answer!=-1){
            int exit = findExit(lebber);
            System.out.println(exit);
            if(exit != -1){
                answer += exit;
            } else return -1;
        }
        return answer;
    }

    static int findLebber(Point start){
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start.i][start.j] = true;
        int time = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point p = queue.poll();

                for(int k=0; k<4; k++){
                    int ni = p.i+dx[k];
                    int nj = p.j+dy[k];

                    if(ni<0||nj<0||ni>=n||nj>=m||visited[ni][nj]||map[ni][nj].equals("X"))
                        continue;

                    if(map[ni][nj].equals("L"))
                        return time;
                    else{
                        visited[ni][nj] = true;
                        queue.offer(new Point(ni,nj));
                    }
                }
            }
            time++;
        }

        return -1;
    }

    static int findExit(Point lebber){
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(lebber);
        visited[lebber.i][lebber.j] = true;
        int time = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point p = queue.poll();

                for(int k=0; k<4; k++){
                    int ni = p.i+dx[k];
                    int nj = p.j+dy[k];

                    if(ni<0||nj<0||ni>=n||nj>=m||visited[ni][nj]||map[ni][nj].equals("X"))
                        continue;

                    if(map[ni][nj].equals("E"))
                        return time;
                    else{
                        visited[ni][nj] = true;
                        queue.offer(new Point(ni,nj));
                    }
                }
            }
            time++;
        }

        return -1;
    }

    static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
