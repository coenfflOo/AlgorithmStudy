package java_2025.Feb;

import java.util.*;
import java.io.*;

public class BOJ23284 {
    private static int n;
    private static Stack<Integer> stack;
    private static List<Integer> number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        number = new ArrayList<>();

        find(1, 0);
    }

    private static void find(int push, int pop) {
        if (push == n+1 && pop == n){
            StringBuilder sb = new StringBuilder();
            for(int num: number){
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        if (!stack.isEmpty()){
            int num = stack.pop();
            number.add(num);
            find(push,pop+1);
            stack.push(num);
            number.remove(number.size()-1);
        }

        if(push<=n){
            stack.push(push);
            find(push+1,pop);
            stack.pop();
        }
    }
}
