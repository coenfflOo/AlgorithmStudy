package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                cnt++;
            }
            if (stack.isEmpty() || stack.peek() < y) {
                if (y != 0) stack.push(y);
            }
        }
        cnt += stack.size();
        System.out.println(cnt);
    }
}
