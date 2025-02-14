package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ2240_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] tree = new int[t+1];
        for (int i = 1; i <= t; i++) {
            tree[i] = Integer.parseInt(br.readLine())%2;
        }

        int[][] drop = new int[w+2][t+1];
        for (int i = 1; i < w + 2; i++) {
            for (int j = 1; j < t+1; j++) {
                if(i%2==tree[j]) {
                    drop[i][j] = Math.max(drop[i][j-1]+1, drop[i-1][j-1]+1);
                } else drop[i][j] = drop[i][j-1];
            }
        }

        int max = 0;
        for (int i = 0; i < w+2; i++) {
            max= Math.max(drop[i][t], max);
        }
        System.out.println(max);
    }
}
