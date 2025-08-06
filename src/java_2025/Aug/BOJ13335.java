package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Truck[] trucks = new Truck[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = new Truck(0,Integer.parseInt(st.nextToken()));
        }

        int cur = trucks[0].weight;
        int time = 1;
        Queue<Truck> queue = new ArrayDeque<>();
        queue.offer(new Truck(0,trucks[0].weight));
        int index = 1;
        while(!queue.isEmpty()){
            if(time-queue.peek().start==w) {
                cur -= queue.peek().weight;
                queue.poll();
            }
            if (index<=n-1){
                Truck truck = trucks[index];
                if (cur+truck.weight<=l){
                    queue.offer(new Truck(time, truck.weight));
                    cur += truck.weight;
                    index++;
                }
            }
            time++;
        }
        System.out.println(time);
    }

    static class Truck {
        int start;
        int weight;
        public Truck(int start, int weight) {
            this.start = start;
            this.weight = weight;
        }
    }
}
