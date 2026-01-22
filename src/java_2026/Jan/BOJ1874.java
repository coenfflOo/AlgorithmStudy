package java_2026.Jan;
import java.io.*;
import java.util.*;
public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> sample = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            sample.add(Integer.parseInt(br.readLine()));
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
//            System.out.println("+");
            sb.append("+\n");
            while (stack.peek().equals(sample.peek())) {
                stack.pop();
                sample.poll();
                sb.append("-\n");
//                System.out.println("-");
                if (stack.isEmpty()) break;
            }
        }
        if (!stack.isEmpty()) {
            sb = new StringBuilder();
            sb.append("NO");
        }
        System.out.println(sb);
    }
}
