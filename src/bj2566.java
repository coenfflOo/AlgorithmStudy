import java.util.*;
import java.io.*;
public class bj2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] A = new int[9][9];
        int n = 0;
        int m = 0;
        int max = A[n][m];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j]>max){
                    max = A[i][j];
                    n = i;
                    m = j;
                }
            }
        }

        bw.write(max+"\n"+(n+1)+" "+(m+1));
        //모두 0 일때 0,0 갱신되지 않음으로 출력시 1을 더해줌
        bw.flush();
    }
}
