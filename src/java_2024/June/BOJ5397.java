package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ5397 {
    static Stack<String> st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String[] str = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            st = new Stack<>();
            for (String s: str) {
                switch (s){
                    case "<":
                        if (!stack.isEmpty()){
                            st.add(stack.pop());
                        }
                        break;
                    case ">":
                        if (!st.isEmpty()){
                            stack.add(st.pop());
                        }
                        break;
                    case "-":
                        if (!stack.isEmpty()){
                            stack.pop();
                        }
                        break;
                    default:
                        stack.push(s);
                        break;
                }
            }
            while (!st.isEmpty()){
                stack.add(st.pop());
            }
            for (String s: stack) {
                bw.write(s);
            }
            bw.newLine();
        }
        bw.flush();
    }
}
