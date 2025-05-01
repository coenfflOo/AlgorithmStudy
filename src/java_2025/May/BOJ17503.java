package java_2025.May;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ17503 {
    private static long n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        PriorityQueue<Beer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Beer> drinks = new PriorityQueue<>(new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                if (o1.love == o2.love) return (int) (o1.level - o2.level);
                return (int) (o1.love - o2.love);
            }
        });
        long love = 0;
        long ans = Long.MAX_VALUE;
        while (!pq.isEmpty()) {
            Beer beer = pq.poll();
            love += beer.love;
            drinks.offer(beer);
            if (drinks.size() == n){
                if (love < m) {
                    Beer drink = drinks.poll();
                    love -= drink.love;
                } else {
                    long level = 0;
                    while (!drinks.isEmpty()){
                        level = Math.max(level, drinks.poll().level);
                    }
                    ans = Math.min(ans, level);
                    break;
                }
            }
        }
        if (ans != Long.MAX_VALUE) System.out.println(ans);
        else System.out.println("-1");
    }

    private static class Beer implements Comparable<Beer> {
        long love;
        long level;
        public Beer(long love, long level) {
            this.love = love;
            this.level = level;
        }
        @Override
        public int compareTo(Beer o) {
            if (this.level == o.level) return (int) (o.love - this.love);
            return (int) (this.level - o.level);
        }
    }
}
