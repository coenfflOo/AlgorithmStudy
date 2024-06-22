package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ2310 {
    static int n;
    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    static Room[] info;
    static int money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("0")) {
            n = Integer.parseInt(s);
            list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }
            info = new Room[n + 1];
            visited = new int[n + 1];
            Arrays.fill(visited, Integer.MIN_VALUE);

            StringTokenizer st;
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                info[i] = new Room(st.nextToken(), Integer.parseInt(st.nextToken()));

                String roomNumber;
                while (!(roomNumber = st.nextToken()).equals("0")) {
                    int num = Integer.parseInt(roomNumber);
                    list.get(i).add(num);
                }
            }
            money = 0;

            if (roomEscape()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean roomEscape() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (info[now].roomInfo.equals("L")) {
                if (money < info[now].cost) {
                    money = info[now].cost;
                }
            } else if (info[now].roomInfo.equals("T")) {
                if (money < info[now].cost) {
                    continue;
                } else {
                    money -= info[now].cost;
                }
            }

            if (now == n) {
                return true;
            }

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if (visited[next] < info[now].cost) {
                    visited[next] = info[now].cost;
                    q.offer(next);
                }
            }
        }
        return false;
    }

    static class Room {
        String roomInfo;
        int cost;

        public Room(String roomInfo, int cost) {
            this.roomInfo = roomInfo;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "roomInfo='" + roomInfo + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
}
