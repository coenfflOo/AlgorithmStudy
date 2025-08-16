package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 10;
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == stack.peek()) sum += 5;
            else sum += 10;
            stack.push(ch);
        }
        System.out.println(sum);
    }
}
