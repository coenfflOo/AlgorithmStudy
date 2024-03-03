package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ16234 {
    static int n, l, r;
    static int[][] people;
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int days;
    static boolean loop;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        people = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                people[i][j] = sc.nextInt();
            }
        }

        days = 0;

        loop = true;
        while (loop) {
            visited = new boolean[n][n];
            loop = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            days++;
        }

        System.out.println(days - 1);
    }

    static void bfs(int pi, int pj) {
        Queue<City> queue = new ArrayDeque<>();
        Queue<City> union = new ArrayDeque<>();
        queue.offer(new City(pi, pj));
        union.offer(new City(pi, pj));
        visited[pi][pj] = true;
        int sum = people[pi][pj];
        int cnt = 1;

        while (!queue.isEmpty()) {
            City city = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newi = city.i + dx[k];
                int newj = city.j + dy[k];
                if (newi >= 0 && newj >= 0 && newi < n && newj < n && !visited[newi][newj]) {
                    int diff = Math.abs(people[newi][newj] - people[city.i][city.j]);
                    if (diff >= l && diff <= r) {
                        visited[newi][newj] = true;
                        sum += people[newi][newj];
                        cnt++;
                        queue.offer(new City(newi, newj));
                        union.offer(new City(newi, newj));
                        loop = true;
                    }
                }
            }
        }

        sum /= cnt;
        while (!union.isEmpty()) {
            City unit = union.poll();
            people[unit.i][unit.j] = sum;
        }
    }

    static class City {
        int i;
        int j;

        public City(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "City{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(people[i][j] + " ");
            }
            System.out.println();
        }
    }

}
