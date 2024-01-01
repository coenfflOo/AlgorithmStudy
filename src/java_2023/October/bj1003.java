package java_2023.October;
import java.io.*;
public class bj1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] memo = new int[41][2]; // memoization 배열, memo[i][0]은 0의 개수, memo[i][1]은 1의 개수

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            memo[i][0] = memo[i - 1][0] + memo[i - 2][0];
            memo[i][1] = memo[i - 1][1] + memo[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(memo[N][0]).append(" ").append(memo[N][1]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
// 피보나치 수열의 값을 계산할 때 0과 1의 개수를 카운트하는 것 대신,
// 이전 두 값을 더하여 다음 값을 계산합니다.

