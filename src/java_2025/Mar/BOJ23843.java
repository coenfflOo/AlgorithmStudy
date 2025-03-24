package java_2025.Mar;
import java.util.*;
import java.lang.*;
import java.io.*;
public class BOJ23843 {
    private static int n,m;
    private static Integer[] time;
    private static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int index = Math.min(m,n);
        pq = new PriorityQueue<>();
        for (int i = 0; i < Math.min(m,n); i++) {
            pq.offer(time[i]);
        }
        while (index < n) {
            int pqTime = pq.poll();
            pq.offer(pqTime+time[index++]);
        }

        int max = Integer.MIN_VALUE;
        for(int t: pq){
            max = Math.max(max, t);
        }
        System.out.println(max);
    }
}
