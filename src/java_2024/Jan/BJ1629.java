package java_2024.Jan;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = calculate(a, b, c);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static long calculate(long base, long exponent, long modulus) {
        if (exponent == 1) {
            return base % modulus;
        }
        long val = calculate(base, exponent / 2, modulus);
        val = val * val % modulus;
        if (exponent % 2 == 0) {
            return val;
        }
        return val * base % modulus;
    }
}
