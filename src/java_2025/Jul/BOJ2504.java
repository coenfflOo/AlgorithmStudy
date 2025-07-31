package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;

import static java.lang.System.exit;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int total = 0;
        int tmp = 1;
        out: for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(')');
                    tmp *= 2;
                    break;
                case '[':
                    stack.push(']');
                    tmp *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != ch) {
                        total = 0;
                        break out;
                    }
                    if (str.charAt(i - 1) == '(') {
                        total += tmp;
                    }
                    tmp /= 2;
                    stack.pop();
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != ch) {
                        total = 0;
                        break out;
                    }
                    if (str.charAt(i - 1) == '[') {
                        total += tmp;
                    }
                    tmp /= 3;
                    stack.pop();
                    break;

            }
        }
        if (!stack.isEmpty()) total = 0;
        System.out.println(total);
    }
}
