import java.util.*;
import java.io.*;
public class bj2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] q = new int[T][2];
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            q[i][0] = k;
            q[i][1] = n;
        }

        for (int i = 0; i < T; i++) {
            bw.write(String.valueOf(apartPeople(q[i][0],q[i][1]))+"\n");
        }
        bw.flush();
    }

    public static int apartPeople(int k, int n){
        // 아파트 기본 설정
        int[][] apart = new int[15][15];
        for(int i = 1; i < 15; i++) {
            apart[0][i] = i;
        }

        // 양의 정수 k와 n에 대해 k층에 n호에는 몇 명
        for(int i = 1; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
            }
        }

        return apart[k][n];
    }
}

