package java_2025.Feb.Study;
import java.util.*;
import java.io.*;
public class 점수따먹기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int stack = 0;
            for (int j = 1; j <= m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(i==1&&j==1){
                    map[i][j] = input;
                } else if (i==1) {
                    map[i][j] = map[i][j-1] + input;
                } else {
                    map[i][j] = map[i-1][j] + input + stack;
                    stack += input;
                }
            }
        }

        int max = -10000;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i==0||j==0)
                    continue;
                max = Math.max(map[i][j],max);
                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        int find = map[i][j]-map[k][j]-map[i][l]+map[k][l];
                        if (max<find)
                            max = find;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
