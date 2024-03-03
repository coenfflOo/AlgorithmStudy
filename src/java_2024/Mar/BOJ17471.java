package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ17471 {
    static int n;
    static List<ArrayList<Integer>> town;
    static int[] people;
    static boolean[] selected;
    static int diffMin;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selected = new boolean[n];

        people = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        town = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            town.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            for (int j = 0; j < idx; j++) {
                town.get(i).add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        diffMin = Integer.MAX_VALUE;
        subTown(0);

        if (diffMin == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(diffMin);
        }
    }

    private static void subTown(int idx) {
        if (idx == n) {
            List<Integer> aTown = new ArrayList<>();
            List<Integer> bTown = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    aTown.add(i);
                } else {
                    bTown.add(i);
                }
            }
            if (aTown.isEmpty() || bTown.isEmpty()) {
                return;
            }
            if (checkTown(aTown) && checkTown(bTown)) {
                int diff = calDiff(aTown, bTown);
                diffMin = Math.min(diffMin, diff);
            }
            return;
        }

        selected[idx] = true;
        subTown(idx + 1);
        selected[idx] = false;
        subTown(idx + 1);
    }

    private static boolean checkTown(List<Integer> subTown) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[n];
        queue.offer(subTown.get(0));
        visited[subTown.get(0)] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < town.get(cur).size(); i++) {
                int neighbor = town.get(cur).get(i);
                if (!visited[neighbor] && subTown.contains(neighbor)) {
                    count++;
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        if (count == subTown.size()) {
            return true;
        } else {
            return false;
        }
    }

    private static int calDiff(List<Integer> aTown, List<Integer> bTown) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            if (aTown.contains(i)) {
                sumA += people[i];
            } else if (bTown.contains(i)) {
                sumB += people[i];
            }
        }
        return Math.abs(sumA - sumB);
    }
}
