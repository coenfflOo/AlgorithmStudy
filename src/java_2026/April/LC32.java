package java_2026.April;

import java.util.Stack;

public class LC32 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        var arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char c : arr){
            if(c=='(' || c=='{' || c=='[')st.push(c);
            else if(c == ')'){
                if(st.isEmpty() || st.pop()!='(')return false;
            }
            else if(c == '}'){
                if(st.isEmpty() || st.pop()!='{')return false;
            }
            else if(c == ']'){
                if(st.isEmpty() || st.pop()!='[')return false;
            }
        }
        if(!st.isEmpty())return false;
        return true;
    }

//    public static boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (char c : s.toCharArray()) {
//            if (c == '(' || c == '{' || c == '[') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty()) return false;
//                if ((stack.peek() == '(' && c == ')')|| (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']')) {
//                    stack.pop();
//                } else return false;
//            }
//        }
//        if (stack.isEmpty()) return true;
//        return false;
//    }
}
