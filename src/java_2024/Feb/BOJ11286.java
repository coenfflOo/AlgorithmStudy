package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println("0");
                }
            } else {
                queue.add(num);
            }
        }
    }
}
