package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int[][] test = new int[n+1][2];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            test[i][0] = Integer.parseInt(st.nextToken());
            test[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] solve = new int[n+1][time+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < time+1; j++) {
                if(j>=test[i][0]){
                    solve[i][j] = Math.max(solve[i-1][j-test[i][0]]+test[i][1], test[i][1]);
                }
                solve[i][j] = Math.max(solve[i-1][j], solve[i][j]);
            }
        }
        System.out.println(solve[n][time]);
    }
}
