package java_2024.Feb;

import java.util.*;

public class SWEA1218 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int length = sc.nextInt();
            Stack<String> stack = new Stack<>();
            String str = sc.next();
            for (int i = 0; i < length; i++) {
                String s = Character.toString(str.charAt(i));
                if (!stack.isEmpty() && (s.equals(")") || s.equals("}") || s.equals("]") || s.equals(">"))) {
                    if (s.equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    } else if (s.equals("}") && stack.peek().equals("{")) {
                        stack.pop();
                    } else if (s.equals("]") && stack.peek().equals("[")) {
                        stack.pop();
                    } else if (s.equals(">") && stack.peek().equals("<")) {
                        stack.pop();
                    } else {
                        break;
                    }
                } else {
                    stack.add(s);
                }
            }

            System.out.print("#" + test_case + " ");
            if (stack.isEmpty()) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
