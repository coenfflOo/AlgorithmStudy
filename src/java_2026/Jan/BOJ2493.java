package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() <= top) {
                stack.pop();
                num.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(num.peek()).append(" ");
            }
            stack.push(top);
            num.push(i+1);
        }
        System.out.println(sb);
    }
}
