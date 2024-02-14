package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
