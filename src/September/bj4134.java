package September;
import java.io.*;

public class bj4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            long num = Long.parseLong(br.readLine());
            long prime = findNextPrime(num);
            sb.append(prime).append("\n");
            N--;
        }

        System.out.print(sb);
    }

    // 다음 소수를 찾는 함수
    private static long findNextPrime(long num) {
        if (num <= 1) num = 2;
        if (num == 2) return 2;

        while (true) {
            boolean isPrime = true;
            for (long i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) return num;
            num++;
        }
    }
}
