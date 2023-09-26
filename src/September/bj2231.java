import java.util.*;
import java.io.*;
public class bj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 1; i < N; i++) {
            int number = sumFunc(i);
            if (number == N){
                ans = i;
                break;
            }

        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    // 분해합 구하는 함수
    private static int sumFunc(int n){
        int num = n;
        while (n != 0){
            num += n%10;
            n/=10;
        }
        return num;
    }
}
