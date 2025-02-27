package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ23284_2 {
    private static int n;
    private static StringBuilder sb;
    private static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        sb = new StringBuilder();
        perm(0,1);
    }

    private static void perm(int current, int push){
        if (current == n*2){
            System.out.println(sb);
            return;
        }

        if (!stack.isEmpty()){
            int st = stack.pop();
            sb.append(st).append(" ");
            perm(current+1, push);
            sb = st==10? new StringBuilder(sb.substring(0, sb.length() - 3)) : new StringBuilder(sb.substring(0, sb.length() - 2));
            stack.push(st);
        }

        if (push <= n){
            stack.push(push);
            perm(current+1, push+1);
            stack.pop();
        }
    }
}
