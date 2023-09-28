package September;
import java.util.*;
import java.io.*;
public class bj13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        System.out.println(lcm(A,B));
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long lcm(long x, long y) {
        long a = Math.min(x,y);
        long b = Math.max(x,y);
        return a * b / gcd(a, b);
    }
}
