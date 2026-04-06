package java_2026.Mar;

import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ10384 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("Case " + t + ": ");
            String s = br.readLine().toLowerCase();
            int[] alphabet = new int[26];
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if ('a'<=c && c<='z') {
                    alphabet[s.charAt(i) - 'a']++;
                }
            }
            boolean flag = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] ==0) {
                    flag = false;
                    break;
                } else min = Math.min(min, alphabet[i]);
            }
            min = Math.min(min, 3);
            if (!flag) {
                sb.append("Not a pangram");
            } else {
                switch (min) {
                    case 1:
                        sb.append("Pangram!");
                        break;
                    case 2:
                        sb.append("Double pangram!!");
                        break;
                    case 3:
                        sb.append("Triple pangram!!!");
                        break;
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
