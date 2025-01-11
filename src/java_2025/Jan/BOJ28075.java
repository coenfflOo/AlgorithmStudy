package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28075 {
    private static int n,m, cnt;
    private static int[][] work;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        work = new int[2][3];
        for(int i = 0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                work[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        find(-1,0,0);
        System.out.println(cnt);
    }

    private static void find(int place, int day, int contribution){
        if(day == n){
            if(contribution >= m)
                cnt++;
            return;
        }

        for(int i = 0; i<2; i++){
            for(int j = 0; j<3; j++){
                if (place == j) {
                    find(j,day+1,contribution+(work[i][j]/2));
                } else {
                    find(j,day+1,contribution+work[i][j]);
                }
            }
        }
    }
}
