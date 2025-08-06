package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ20301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }
        boolean flag = true;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            int idx = 1;
            if(flag){
                while (idx < k){
                    idx++;
                    dq.addLast(dq.pollFirst());
                }
                sb.append(dq.pollFirst()).append("\n");
            } else {
                while (idx < k){
                    idx++;
                    dq.addFirst(dq.pollLast());
                }
                sb.append(dq.pollLast()).append("\n");
            }
            cnt++;
            if (cnt % m == 0){
                flag = !flag;
            }
        }
        System.out.print(sb);
    }
}
