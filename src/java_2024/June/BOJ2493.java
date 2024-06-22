package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ2493 {
    static HashMap<Integer,Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());
//            System.out.println(h);
            while (!stack.isEmpty()){
                if (stack.peek()<h) {
                    stack.pop();
                } else break;
            }
            if (stack.isEmpty()){
                map.put(h,i);
                stack.push(h);
                sb.append(0).append(" ");
            } else {
                sb.append(map.get(stack.peek())).append(" ");
                stack.push(h);
                map.put(h,i);
            }
//            System.out.println(stack);
        }
        System.out.println(sb);
    }
}
