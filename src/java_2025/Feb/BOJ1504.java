package java_2025.Feb;

import java.util.*;
import java.io.*;

import static java.lang.System.exit;

public class BOJ1504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Load>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        int e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Load(b, c));
            list.get(b).add(new Load(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] visited = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Load> pq = new PriorityQueue<>();
        pq.add(new Load(1, 0));
        int startToA = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Load load = pq.poll();

            if (load.cur==v1){
                startToA = Math.min(startToA, load.len);
            }

            for(Load l: list.get(load.cur)){
                if (visited[l.cur]>load.len+l.len){
                    visited[l.cur] = load.len+l.len;
                    pq.add(new Load(l.cur,load.len+l.len));
                }
            }
        }
        if (startToA == Integer.MAX_VALUE){
            System.out.println("-1");
            exit(0);
        }

        visited = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        pq = new PriorityQueue<>();
        pq.add(new Load(1, 0));
        int startToB = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Load load = pq.poll();

            if (load.cur==v2){
                startToB = Math.min(startToB, load.len);
            }

            for(Load l: list.get(load.cur)){
                if (visited[l.cur]>load.len+l.len){
                    visited[l.cur] = load.len+l.len;
                    pq.add(new Load(l.cur,load.len+l.len));
                }
            }
        }
        if (startToB == Integer.MAX_VALUE){
            System.out.println("-1");
            exit(0);
        }


        visited = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        pq = new PriorityQueue<>();
        pq.add(new Load(v1, 0));
        int AToB = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Load load = pq.poll();

            if (load.cur==v2){
                AToB = Math.min(AToB, load.len);
            }

            for(Load l: list.get(load.cur)){
                if (visited[l.cur]>load.len+l.len){
                    visited[l.cur] = load.len+l.len;
                    pq.add(new Load(l.cur,load.len+l.len));
                }
            }
        }
        if (AToB == Integer.MAX_VALUE){
            System.out.println("-1");
            exit(0);
        }

        visited = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        pq = new PriorityQueue<>();
        pq.add(new Load(v1, 0));
        int AToEnd = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Load load = pq.poll();

            if (load.cur==n){
                AToEnd = Math.min(AToEnd, load.len);
            }

            for(Load l: list.get(load.cur)){
                if (visited[l.cur]>load.len+l.len){
                    visited[l.cur] = load.len+l.len;
                    pq.add(new Load(l.cur,load.len+l.len));
                }
            }
        }
        if (AToEnd == Integer.MAX_VALUE){
            System.out.println("-1");
            exit(0);
        }

        visited = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        pq = new PriorityQueue<>();
        pq.add(new Load(v2, 0));
        int BToEnd = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Load load = pq.poll();

            if (load.cur==n){
                BToEnd = Math.min(BToEnd, load.len);
            }

            for(Load l: list.get(load.cur)){
                if (visited[l.cur]>load.len+l.len){
                    visited[l.cur] = load.len+l.len;
                    pq.add(new Load(l.cur,load.len+l.len));
                }
            }
        }
        if (BToEnd == Integer.MAX_VALUE){
            System.out.println("-1");
            exit(0);
        }

        int answerA = Math.min(startToA+AToB+BToEnd, Integer.MAX_VALUE);
        int answerB = Math.min(startToB+AToB+AToEnd, Integer.MAX_VALUE);

        int answer = Math.min(answerA, answerB);
        answer = answer == Integer.MAX_VALUE ?-1:answer;
        answer = answer < 0 ?-1:answer;
        System.out.println(answer);
    }

    private static class Load implements Comparable<Load> {
        int cur;
        int len;

        public Load(int cur, int len) {
            this.cur = cur;
            this.len = len;
        }

        @Override
        public int compareTo(Load o) {
            return this.len-o.len;
        }
    }
}
