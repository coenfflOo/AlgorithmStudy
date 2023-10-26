package October;
import java.util.*;
import java.io.*;

public class bj9184 {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + wFunction(a, b, c));
        }
    }

    static int wFunction(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return wFunction(20, 20, 20);
        }

        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            dp[a][b][c] = wFunction(a, b, c - 1) + wFunction(a, b - 1, c - 1) - wFunction(a, b - 1, c);
        } else {
            dp[a][b][c] = wFunction(a - 1, b, c) + wFunction(a - 1, b - 1, c) + wFunction(a - 1, b, c - 1) - wFunction(a - 1, b - 1, c - 1);
        }

        return dp[a][b][c];
    }
}