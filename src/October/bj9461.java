package October;

import java.io.*;

public class bj9461 {
    private static long[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        P = new long[101];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(findPNumber(N) + "\n");
        }

        bw.flush();
    }

    private static long findPNumber(int N) {
        if (N <= 3)
            return 1;

        if (P[N] != 0)
            return P[N];

        P[N] = findPNumber(N - 2) + findPNumber(N - 3);
        return P[N];
    }
}
