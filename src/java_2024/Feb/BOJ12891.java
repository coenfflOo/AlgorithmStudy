package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ12891 {
    static int[] acgt;
    static int[] input;

    //    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 문자열 길이
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        String[] str = br.readLine().split("");

        acgt = new int[4];
        input = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < p; i++) {
            switch (str[i]) {
                case "A":
                    input[0] += 1;
                    break;
                case "C":
                    input[1] += 1;
                    break;
                case "G":
                    input[2] += 1;
                    break;
                case "T":
                    input[3] += 1;
                    break;
            }
        }
        if (same()) {
            cnt++;
        }

        int start = 0;
        for (int i = p; i < s; i++) {
            switch (str[start++]) {
                case "A":
                    input[0] -= 1;
                    break;
                case "C":
                    input[1] -= 1;
                    break;
                case "G":
                    input[2] -= 1;
                    break;
                case "T":
                    input[3] -= 1;
                    break;
            }
            switch (str[i]) {
                case "A":
                    input[0] += 1;
                    break;
                case "C":
                    input[1] += 1;
                    break;
                case "G":
                    input[2] += 1;
                    break;
                case "T":
                    input[3] += 1;
                    break;
            }
            if (same()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean same() {
        for (int i = 0; i < 4; i++) {
            if (acgt[i] > input[i]) {
                return false;
            }
        }
        return true;
    }
}
