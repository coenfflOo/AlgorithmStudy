package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ27896 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] bulman = new int[n];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            bulman[i] = Integer.parseInt(st.nextToken());
            pq.add(bulman[i]);
            total += bulman[i];
            if (total >= m) {
                int temp = pq.poll();
                cnt++;
                total -= (temp*2);
            }
        }
        System.out.println(cnt);
    }
}
