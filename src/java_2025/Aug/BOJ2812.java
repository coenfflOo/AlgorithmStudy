package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            while (!queue.isEmpty() && k>0 && num > queue.peekLast()){
                queue.pollLast();
                k--;
            }
            queue.addLast(num);
        }

        while (k-- > 0) {
            queue.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.pollFirst());
        }
        System.out.println(sb);
    }
}
