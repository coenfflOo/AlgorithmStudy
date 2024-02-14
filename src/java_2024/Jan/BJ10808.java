package java_2024.Jan;

import java.util.*;
import java.io.*;

public class BJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int arr = s.charAt(i) - 97;
            if (alp[arr] == 0) {
                alp[arr] = 1;
            } else if (alp[arr] >= 1) {
                alp[arr] += 1;
            }
        }
        for (int num :
                alp) {
            System.out.print(num+" ");
        }
    }
}
