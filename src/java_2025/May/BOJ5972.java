package java_2025.May;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Road>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Road(b, c));
            list.get(b).add(new Road(a, c));
        }

        int[] visited = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[0] = 0;
        visited[1] = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            ArrayList<Road> now = list.get(p);
            for (int i = 0; i < now.size(); i++) {
                Road cur = now.get(i);
                if (visited[cur.next]>visited[p] + cur.cow){
                    visited[cur.next] = visited[p] + cur.cow;
                    if (cur.next != n){
                        queue.add(cur.next);
                    }
                }
//                visited[cur.next] = Math.min(visited[cur.next], visited[p] + cur.cow);

            }
        }
        System.out.println(visited[n]);
    }

    private static class Road {
        int next;
        int cow;
        Road(int next, int cow) {
            this.next = next;
            this.cow = cow;
        }
    }
}
