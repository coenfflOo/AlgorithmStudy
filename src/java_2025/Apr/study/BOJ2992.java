package java_2025.Apr.study;

import java.util.*;
import java.io.*;

public class BOJ2992 {
    private static String s;
    private static int num;
    private static int[] number;
    private static boolean[] used;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        num = Integer.parseInt(s);
        number = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            number[i] = s.charAt(i) - '0';
        }
        used = new boolean[s.length()];
        findNumber(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

    private static void findNumber(int depth, int currentNum){
        if (depth == number.length) {
            if (currentNum > num && currentNum < answer) {
                answer = currentNum;
            }
            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (!used[i]) {
                used[i] = true;
                findNumber(depth + 1, currentNum * 10 + number[i]);
                used[i] = false;
            }
        }
    }
}
