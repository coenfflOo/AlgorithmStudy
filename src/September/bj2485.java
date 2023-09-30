package September;
import java.io.*;
import java.util.*;

public class bj2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] tree = new long[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(tree);
        long minGap = findMinGap(tree);
        long count = 0;
        for (int i = 1; i < N; i++) {
            count += (tree[i] - tree[i - 1]) / minGap - 1;
        }
        bw.write(String.valueOf(count));
        bw.close();
    }

    private static long findMinGap(long[] arr) {
        long minGap = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            minGap = gcd(minGap, arr[i] - arr[i - 1]);
        }
        return minGap;
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
