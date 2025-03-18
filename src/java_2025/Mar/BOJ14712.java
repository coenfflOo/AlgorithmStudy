package java_2025.Mar;
import java.util.*;
import java.lang.*;
import java.io.*;
public class BOJ14712 {
    private static int n,m, answer;
    private static boolean[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n+1][m+1];
        answer = 0;
        putNemmo(0);
        System.out.println(answer);
    }

    private static void putNemmo(int cnt){
        if(cnt == n*m){
            answer++;
            return;
        }

        int ni = cnt / m + 1;
        int nj = cnt % m + 1;

        if(map[ni-1][nj-1] && map[ni-1][nj] && map[ni][nj-1]) {
            putNemmo(cnt + 1);
        } else {
            map[ni][nj] = true;
            putNemmo(cnt + 1);
            map[ni][nj] = false;
            putNemmo(cnt + 1);
        }
    }
}
