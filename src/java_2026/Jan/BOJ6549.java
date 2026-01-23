package java_2026.Jan;

import java.io.*;
import java.util.*;

public class BOJ6549 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) break;
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());

            Stack<Square> stack = new Stack<>();
            long max = 0;

            // i == n 에서 height = 0을 넣어 스택을 끝까지 비움
            for (int i = 0; i <= n; i++) {
                long height = (i == n) ? 0 : Integer.parseInt(st.nextToken());
                int start = i;

                while (!stack.isEmpty() && stack.peek().height > height) {
                    Square prev = stack.pop();
                    max = Math.max(max, prev.height * (i - prev.start));
                    // 더 낮은 높이는 더 왼쪽까지 확장 가능
                    start = prev.start;
                }

                // 같은 높이는 굳이 중복 push 안 해도 됨(더 이른 start만 유지)
                if (stack.isEmpty() || stack.peek().height < height) {
                    stack.push(new Square(height, start));
                }
            }

            System.out.println(max);
        }
    }

    static class Square {
        long height;
        int start;
        Square(long height, int start) {
            this.height = height;
            this.start = start;
        }
    }
}
