package java_2026.Jan;

import java.io.*;
import java.util.*;

public class BOJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] idx = new int[N];
        int[] val = new int[N];
        int head = 0, tail = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            int leftBound = i - L + 1;
            if (head < tail && idx[head] < leftBound) {
                head++;
            }
            while (head < tail && val[tail - 1] > x) {
                tail--;
            }

            idx[tail] = i;
            val[tail] = x;
            tail++;

            sb.append(val[head]).append(" ");
        }
        System.out.println(sb);
    }

    static class Number implements Comparable<Number> {
        int num;
        int idx;

        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Number o) {
            if (this.num == o.num) {
                return this.idx - o.idx;
            }
            return this.num - o.num;
        }
    }
}
