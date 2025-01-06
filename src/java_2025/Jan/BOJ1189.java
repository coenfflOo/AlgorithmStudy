package java_2025.Jan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1189 {
    private static int r,c,k,cnt;
    private static String[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = 0;

        graph = new String[r][c];
        visited = new boolean[r][c];
        for(int i = 0; i<r; i++){
            graph[i] = br.readLine().split("");
        }

        visited[r-1][0] = true;
        dfsLoad(r-1,0,0);
        System.out.println(cnt);
    }

    private static void dfsLoad(int i, int j, int distance) {
        if(distance==k-1){
            if(i==0&&j==c-1) {
                cnt++;
            }
            visited[i][j] = false;
            return;
        }

        for(int k = 0; k<4; k++){
            int ni = i + dx[k];
            int nj = j + dy[k];

            if(ni<0||nj<0||ni>=r||nj>=c||visited[ni][nj]||graph[ni][nj].equals("T"))
                continue;

            visited[ni][nj] = true;
            dfsLoad(ni,nj,distance+1);
            visited[ni][nj] = false;
        }
    }

    private static void print(){
        System.out.println("===========================");
        for(boolean[] str: visited){
            System.out.println(Arrays.toString(str));
        }
        System.out.println("===========================");
    }
}
