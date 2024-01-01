package java_2023.September;
import java.util.*;
import java.io.*;
public class bj1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sonA = Integer.parseInt(st.nextToken());
        long momA = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long sonB = Integer.parseInt(st2.nextToken());
        long momB = Integer.parseInt(st2.nextToken());

        long lcmNum = lcm(momA,momB);
        long sonR = sonA*(lcmNum/momA) + sonB*(lcmNum/momB);

        long gcdNum = gcd(sonR, lcmNum);
        System.out.println((sonR/gcdNum)+" "+(lcmNum/gcdNum));

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
