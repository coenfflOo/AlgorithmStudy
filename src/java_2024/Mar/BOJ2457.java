package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ2457 {
    static boolean[][] calender = new boolean[12][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Flower> flowers = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int s = sm * 100 + sd;
            int e = em * 100 + ed;
            flowers.add(new Flower(s, e));
        }

        // 시작시간 기준으로 정렬하기
        Collections.sort(flowers);

        int startFlower = 301;
        int endFlower = 1201;
        int cnt = 0;
        int max = 0;
        int index = 0;
        while (startFlower < endFlower) {
            boolean find = false;

            for (int i = index; i < n; i++) {
                if (flowers.get(i).start > startFlower) {
                    break;
                }
                if (max < flowers.get(i).end) {
                    find = true;
                    max = flowers.get(i).end;
                    index = i + 1;
                }
            }

            if (find) {
                startFlower = max;
                cnt++;
            } else {
                break;
            }
        }

        if (max < endFlower) {
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }
    }

    static class Flower implements Comparable<Flower> {
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 1) 시작일 낮은 순
        // 2) 종료일 높은 순
        @Override
        public int compareTo(Flower o) {
            if (this.start > o.start) {
                return this.start - o.start;
            } else if (this.start == o.start) {
                if (this.end > o.end) {
                    return -1;
                } else if (this.end == o.end) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        }
    }
}
