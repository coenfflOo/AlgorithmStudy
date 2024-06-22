package java_2024.June;

import java.util.*;
import java.io.*;

public class BOJ28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            if (s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 9) {
                arr[i] = Integer.parseInt(s);
                flag = true;
            }
            if (arr[i] == 0 && flag) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        int n = arr[2] + 1;
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (n % 3 == 0) {
            System.out.println("Fizz");
        } else if (n % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }
    }
}
