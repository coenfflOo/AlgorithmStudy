package September;

import java.util.*;
import java.io.*;

public class bj1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.offer(new int[]{j, Integer.parseInt(st2.nextToken())});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int[] front = q.poll();
                boolean isMax = true;

                for (int j = 0; j < q.size(); j++) {
                    if (front[1] < q.get(j)[1]) {
                        q.offer(front);
                        for (int k = 0; k < j; k++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if (!isMax) {
                    continue;
                }

                count++;
                if (front[0] == M) {
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
