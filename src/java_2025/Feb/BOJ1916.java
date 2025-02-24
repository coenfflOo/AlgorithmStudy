package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ1916 {
    private static int n,m;
    private static ArrayList<ArrayList<Bus>> city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        city = new ArrayList<>();
        long[] visited = new long[n+1];
        for (int i = 0; i < n+1; i++) {
            city.add(new ArrayList<>());
        }

        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            city.get(a).add(new Bus(b,c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        long min = Long.MAX_VALUE;
        pq.offer(new Bus(start,0));
        visited[start] = 0;
        for (int i = 1; i < n+1; i++) {
            visited[i] = Long.MAX_VALUE;
        }
        while (!pq.isEmpty()) {
            Bus cur = pq.poll();
            if (visited[cur.goal]<cur.price) continue;
            for (Bus b : city.get(cur.goal)) {
                if (visited[b.goal]>b.price+ cur.price) {
                    if (b.goal == end) {
                        min = Math.min(min, cur.price+b.price);
                    }
                    visited[b.goal] = b.price+ cur.price;
                    pq.offer(new Bus(b.goal, b.price+cur.price));
                }
            }
        }
        min = min == Integer.MAX_VALUE ? 0 : min;
        min = start == end ? 0 : min;
        System.out.println(min);
    }

    private static class Bus implements Comparable<Bus> {
        int goal;
        long price;

        public Bus(int goal, long price) {
            this.goal = goal;
            this.price = price;
        }

        @Override
        public String toString() {
            return this.goal + " " + this.price;
        }

        @Override
        public int compareTo(Bus o) {
            if (this.price > o.price) {
                return 1;
            } else if (this.price < o.price) {
                return -1;
            } else return 0;
        }
    }

}
