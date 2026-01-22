package java_2026.Jan;
import java.io.*;
import java.util.*;
public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if(!queue.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
