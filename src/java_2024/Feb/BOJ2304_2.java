package java_2024.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2304_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pillar = new int[1001];
        int maxH = 0, maxR = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c > maxH) {
                maxH = c;
                maxR = r;
            }
            pillar[r] = c;
        }

        int max = 0;
        for (int i = 0; i < maxR; i++) {
            if (pillar[i] > max) {
                max = pillar[i];
            }
            pillar[i] = max;
        }

        max = 0;
        for (int i = 1000; i >= maxR; i--) {
            if (pillar[i] > max) {
                max = pillar[i];
            }
            pillar[i] = max;
        }

        int res = 0;
        for (int num : pillar) {
            res += num;
        }
        System.out.println(res);
    }

}
