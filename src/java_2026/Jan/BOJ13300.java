package java_2026.Jan;
import java.util.*;
import java.io.*;

public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] student = new int[6][2];
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1])-1;
            student[y][s]++;
        }
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (student[i][j] % k > 0) cnt++;
                cnt += student[i][j]/k;
            }
        }
        System.out.println(cnt);
    }
}
