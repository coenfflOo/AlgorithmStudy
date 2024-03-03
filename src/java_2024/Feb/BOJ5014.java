package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()) - 1;
        int g = Integer.parseInt(st.nextToken()) - 1;
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] building = new int[f];

        if (u == 0 || d == 0) {
            System.out.println("use the stairs");
            return;
        } else if (s == g) {
            System.out.println("0");
            return;
        }

        bfs(f, s, g, u, d, building);
    }

    private static void bfs(int floor, int start, int end, int up, int down, int[] building) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                break;
            }

            if (start > end && start - down >= 0) {
                queue.offer(start - down);
            }

            if (start + up < floor) {
                queue.offer(start + up);
            }
        }
    }
}
