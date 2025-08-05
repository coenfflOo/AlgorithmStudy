package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
            if (queue.isEmpty()) break;
            queue.offer(queue.poll());
        }
        System.out.println(sb);
    }
}
