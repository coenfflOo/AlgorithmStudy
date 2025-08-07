package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            int start = Math.min(h, o);
            int end = Math.max(h, o);
            list.add(new int[]{start, end});
        }
        int d = Integer.parseInt(br.readLine());
        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]); // end 기준 오름차순
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for (int[] arr : list) {
            int start = arr[0];
            int end = arr[1];
            if (end-start>d) continue;
            pq.add(start);
            while (!pq.isEmpty() && pq.peek()<end-d){
                pq.poll();
            }
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }
}
