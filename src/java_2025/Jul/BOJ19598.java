package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Time[] times = new Time[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(times);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0].end);
        for(int i=1; i<n; i++){
            if (times[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(times[i].end);
        }
        System.out.println(pq.size());
    }

    static class Time implements Comparable<Time>{
        int start, end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Time o) {
            if(this.start == o.start){
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
