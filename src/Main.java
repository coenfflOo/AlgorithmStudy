import java.util.*;
import java.io.*;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int fib1 = fib(N);
        int fib2 = fibonacci(N);
        bw.write(count1+" "+count2);
        bw.flush();
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private static int fibonacci(int n) {
        f = new int[n + 1];
        if (n == 1 || n == 2) {
            count2++;
            f[1] = f[2] = 1;
        }

        for (int i = 3; i < n; i++) {
            count2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        count2++;
        return f[n];
    }

}