package September;

import java.io.*;

public class bj17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 에라토스테네스의 체를 사용하여 소수를 미리 구해놓습니다.
        boolean[] isPrime = new boolean[1000001];
        findPrimes(isPrime);

        while (T > 0) {
            long num = Long.parseLong(br.readLine());
            long result = countGoldbachPartitions(num, isPrime);
            sb.append(result).append("\n");
            T--;
        }

        bw.write(sb.toString());
        bw.close();
    }

    // 에라토스테네스의 체를 사용하여 소수를 찾습니다.
    private static void findPrimes(boolean[] isPrime) {
        for (int i = 2; i * i <= 1000000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    private static long countGoldbachPartitions(long N, boolean[] isPrime) {
        long count = 0;

        for (int i = 2; i <= N / 2; i++) {
            if (!isPrime[i] && !isPrime[(int) (N - i)]) {
                count++;
            }
        }
        return count;
    }
}


// 2 3 5 - 3,3
// 2 3 5 7 - 3,5
// 2 3 5 7  - 5,5 3,7
// 2 3 4 7 11 - 4,7