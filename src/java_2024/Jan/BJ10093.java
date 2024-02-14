package java_2024.Jan;

import java.util.*;
import java.io.*;

public class BJ10093 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long A = Math.min(a, b);
        long B = Math.max(a, b);
        if (A == B || A + 1 == B) {
            System.out.println("0");
        } else {
            System.out.println((B - A - 1));
        }
        for (long i = A + 1; i < B; i++) {
            System.out.print(i + " ");
        }
    }
}
