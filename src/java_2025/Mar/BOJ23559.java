package java_2025.Mar;

import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ23559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            pq.offer(new Food(p, q));
        }

        int flavor = 0;
        while (!pq.isEmpty()) {
            Food food = pq.poll();
            if ((x - 5000) >= pq.size() * 1000 && food.fifty > food.ten) {
                x -= 5000;
                flavor += food.fifty;
            } else {
                x -= 1000;
                flavor += food.ten;
            }
        }
        System.out.println(flavor);
    }

    static class Food implements Comparable<Food> {
        int fifty;
        int ten;

        public Food(int fifty, int ten) {
            this.fifty = fifty;
            this.ten = ten;
        }

        @Override
        public int compareTo(Food o) {
            if((this.fifty - this.ten)> (o.fifty - o.ten))
                return -1;
            else if ((this.fifty - this.ten)< (o.fifty - o.ten)) {
                return 1;
            } else return 0;
        }
    }
}
