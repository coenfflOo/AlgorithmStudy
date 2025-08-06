package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            long k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (long i = 0; i < k; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (pq.size() > 1) {
                long cur = pq.poll()+pq.poll();
                sum += cur;
                pq.add(cur);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
