package java_2025.Feb;

import java.util.*;
import java.io.*;

public class BOJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Line>> line = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            line.add(new ArrayList<>());
        }

        int e = Integer.parseInt(st.nextToken());
        int  k = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            line.get(u).add(new Line(v1,w));
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();
        int[] answer = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            answer[i] = Integer.MAX_VALUE;
        }
        pq.add(new Line(k,0));
        while(!pq.isEmpty()){
            Line l = pq.poll();

            if (answer[l.v]>l.w){
                answer[l.v] = l.w;
                for (Line next : line.get(l.v)){
                    pq.offer(new Line(next.v,next.w+l.w));
                }
            }
        }

        for (int i = 1; i < v+1; i++) {
            if (answer[i]==Integer.MAX_VALUE)
                System.out.println("INF");
            else System.out.println(answer[i]);
        }
    }

    static class Line implements Comparable<Line>{
        int w;
        int v;
        public Line(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Line o) {
            return this.w - o.w;
        }
    }
}
