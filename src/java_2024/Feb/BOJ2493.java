package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().height < h) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek().number).append(" ");
            }
            stack.push(new Tower(h, i));
        }
        System.out.println(sb);
    }

    static class Tower {
        int height;
        int number;

        Tower(int h, int n) {
            height = h;
            number = n;
        }
    }
}
