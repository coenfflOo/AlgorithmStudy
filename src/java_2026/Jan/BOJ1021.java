package java_2026.Jan;

import java.io.*;
import java.util.*;

public class BOJ1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) dq.addLast(i);

        st = new StringTokenizer(br.readLine());
        int ans = 0;

        for (int k = 0; k < M; k++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (int v : dq) {
                if (v == target) break;
                idx++;
            }

            int size = dq.size();
            int left = idx;
            int right = size - idx;

            if (left <= right) {
                for (int i = 0; i < left; i++) {
                    dq.addLast(dq.pollFirst());
                    ans++;
                }
            } else {
                for (int i = 0; i < right; i++) {
                    dq.addFirst(dq.pollLast());
                    ans++;
                }
            }

            dq.pollFirst();
        }

        System.out.println(ans);
    }
}
