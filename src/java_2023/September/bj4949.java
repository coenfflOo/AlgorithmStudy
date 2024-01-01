package java_2023.September;

import java.util.*;
import java.io.*;

public class bj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!Objects.equals(s = br.readLine(), ".")) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.empty() && s.charAt(i) == ')') {
                    stack.push(")");
                    break;
                } else if (stack.empty() && s.charAt(i) == ']') {
                    stack.push("]");
                    break;
                } else if (s.charAt(i) == '(')
                    stack.push("(");
                else if (s.charAt(i) == ')') {
                    if (Objects.equals(stack.peek(), "("))
                        stack.pop();
                    else
                        stack.push(")");
                } else if (s.charAt(i) == '[')
                    stack.push("[");
                else if (s.charAt(i) == ']') {
                    if (Objects.equals(stack.peek(), "["))
                        stack.pop();
                    else
                        stack.push("]");
                }
            }
            if (stack.empty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
