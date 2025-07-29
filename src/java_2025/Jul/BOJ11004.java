package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        while (k-- > 1) {
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}
