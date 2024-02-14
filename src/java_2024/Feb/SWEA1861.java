package java_2024.Feb;

import java.util.*;

class SWEA1861 {
    static int[][] room;
    static int N;
    static int visitRoom;
    static int possibleRoom;
    static int roomNumber;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            room = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    room[i][j] = sc.nextInt();
                }
            }

            roomNumber = 0;
            possibleRoom = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visitRoom = 0;
                    bfs(i, j);
                    if (visitRoom > possibleRoom || (roomNumber > room[i][j] && visitRoom == possibleRoom)) {
                        possibleRoom = visitRoom;
                        roomNumber = room[i][j];
                    }
                }
            }
            System.out.println("#" + test_case + " " + roomNumber + " " + possibleRoom);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Room> queue = new ArrayDeque<>();
        queue.offer(new Room(i, j));

        while (!queue.isEmpty()) {
            Room r = queue.poll();
            visitRoom++;

            for (int k = 0; k < 4; k++) {
                int ai = r.i + dx[k];
                int aj = r.j + dy[k];
                if (ai >= 0 && aj >= 0 && ai < N && aj < N && room[ai][aj] - room[r.i][r.j] == 1) {
                    queue.offer(new Room(ai, aj));
                }
            }
        }
    }

    static class Room {
        int i;
        int j;

        Room(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
