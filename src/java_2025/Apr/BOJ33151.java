package java_2025.Apr;
import java.util.*;
import java.io.*;
public class BOJ33151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        long k = Long.parseLong(st[1]);

        if (n == 1) {
            System.out.println(k);
            return;
        }

        int[][] map = new int[n][n];
        int even;
        int odd;
        if (n % 2 == 0) {
            even = 0;
            odd = 1;
        } else {
            if (k % 2 == 0) {
                even = 0;
                odd = 1;
            } else {
                even = 1;
                odd = 0;
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i+j) % 2 == 0) {
                    map[i][j] = even;
                    sum += even;
                } else {
                    map[i][j] = odd;
                    sum += odd;
                }
            }
        }

        if (k < sum){
            System.out.println(-1);
            return;
        }

        if (n%2 == 0 && k%2==1){
            System.out.println(-1);
            return;
        }

        long coin = k - sum;

        long addCoin = coin / (2L *n*n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += 2 * addCoin;
            }
        }

        coin -= 2*addCoin*n*n;

//        int small = Math.min(even, odd);
//        for (int i = 0; i < n && coin > 0; i++) {
//            for (int j = 0; j < n && coin > 0; j++) {
//                if (((i + j) % 2 == 0 && even == small) || ((i + j) % 2 == 1 && odd == small)) {
//                    map[i][j] += 2;
//                    coin -= 2;
//                }
//            }
//        }
//  꼭 부족한 쪽에만 +2 해줘야되는게 아니라 부쪽한 쪽 다 채웠으면 coin이 남는 경우에 나머지 부분에도 +2 해서 채워줘야 함

        for (int i = 0; i < n && coin > 0; i++) {
            for (int j = 0; j < n && coin > 0; j++) {
                if (((i + j) % 2 == 0 && even == 0) || ((i + j) % 2 == 1 && odd == 0)) {
                    map[i][j] += 2;
                    coin -= 2;
                }
            }
        }
        for (int i = 0; i < n && coin > 0; i++) {
            for (int j = 0; j < n && coin > 0; j++) {
                if (((i + j) % 2 == 0 && even == 1) || ((i + j) % 2 == 1 && odd == 1)) {
                    map[i][j] += 2;
                    coin -= 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
