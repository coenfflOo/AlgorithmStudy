package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Load>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list.get(start).add(new Load(end, time));
        }

        int[] go = new int[n+1];
        for (int j = 1; j < n + 1; j++) {
            go[j] = Integer.MAX_VALUE;
        }
        go[0] = 0;
        for (int i = 1; i < n+1; i++) {
            PriorityQueue<Load> queue = new PriorityQueue<>();
            int[] visited = new int[n+1];
            for (int j = 1; j < n + 1; j++) {
                visited[j] = Integer.MAX_VALUE;
            }
            queue.offer(new Load(i,0));
            visited[i] = 0;
            while (!queue.isEmpty()){
                Load l = queue.poll();

                if (l.cur==x){
                    go[i] = Math.min(go[i], l.time);
                    visited[l.cur] = Math.min(visited[l.cur], l.time);
                    continue;
                }

                for(Load load: list.get(l.cur)){
                    if (visited[load.cur]>l.time+load.time){
                        visited[load.cur]=l.time+load.time;
                        queue.offer(new Load(load.cur, l.time+load.time));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(go));

        int[] come = new int[n+1];
        for (int j = 1; j < n + 1; j++) {
            come[j] = Integer.MAX_VALUE;
        }
        come[0] = 0;
        PriorityQueue<Load> queue = new PriorityQueue<>();
        queue.offer(new Load(x,0));
        come[x] = 0;
        while (!queue.isEmpty()){
            Load l = queue.poll();

            for(Load load: list.get(l.cur)){
                if (come[load.cur]>l.time+load.time){
                    come[load.cur]=l.time+load.time;
                    queue.offer(new Load(load.cur, l.time+load.time));
                }
            }
        }
        System.out.println(Arrays.toString(come));

        int max = 0;
        for (int i = 1; i < n+1; i++) {
            max = Math.max(go[i]+come[i],max);
        }
        System.out.println(max);
    }

    private static class Load implements Comparable<Load>{
        int cur;
        int time;
        public Load(int cur, int time){
            this.cur = cur;
            this.time = time;
        }

        @Override
        public int compareTo(Load o){
            return this.time-o.time;
        }
    }
}
