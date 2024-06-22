package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ9205 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();

            List<Point> destination = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                destination.add(new Point(sc.nextInt(), sc.nextInt()));
            }

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (distance(destination.get(i), destination.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append(BFS(graph, n) ? "happy" : "sad").append('\n');
        }
        System.out.println(sb);
    }

    private static boolean BFS(ArrayList<ArrayList<Integer>> graph, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] visited = new boolean[n+2];
        visited[0] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);

                if (visited[next])
                    continue;
                if (next == n+1)
                    return true;

                visited[next]=true;
                q.offer(next);
            }
        }
        return false;
    }

    private static int distance(Point point1, Point point2) {
        return Math.abs(point1.i - point2.i) + Math.abs(point1.j - point2.j);
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
