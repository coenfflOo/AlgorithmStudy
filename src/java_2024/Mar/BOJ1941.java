package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ1941 {
    static String[][] students = new String[5][5];
    static boolean[] selected;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Student> princess;
    static boolean possible;
    static int count;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] stu = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                students[i][j] = stu[j];
            }
        }

        selected = new boolean[25];
        count = 0;
        combStudent(0, 0);

        System.out.println(count);
    }

    private static void combStudent(int cnt, int start) {
        if (cnt == 7) {
            princess = new ArrayList<>();
            visited = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (selected[i * 5 + j]) {
                        princess.add(new Student(i, j, students[i][j]));
                    }
                }
            }

            int sGroup = 0;
            for (int i = 0; i < princess.size(); i++) {
                if (princess.get(i).group.equals("S")) {
                    sGroup++;
                }
            }

            if (sGroup < 4) {
                return;
            } else {
                possible = false;
                bfsStudents(princess);
            }

            if (possible) {
                count++;
            }
            return;
        }

        if (start == 25) {
            return;
        }

        selected[start] = true;
        combStudent(cnt + 1, start + 1);
        selected[start] = false;
        combStudent(cnt, start + 1);
    }

    private static void bfsStudents(List<Student> princess) {
        Queue<Student> queue = new ArrayDeque<>();

        queue.offer(princess.get(0));
        visited[princess.get(0).i][princess.get(0).j] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Student s = queue.poll();
            cnt++;

            for (int k = 0; k < 4; k++) {
                int ni = s.i + dx[k];
                int nj = s.j + dy[k];

                if (ni >= 0 && nj >= 0 && ni < 5 && nj < 5 && checkPrincess(ni, nj) && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    queue.offer(new Student(ni, nj, students[ni][nj]));
                }
            }
        }

        if (cnt == 7) {
            possible = true;
        }
    }

    private static boolean checkPrincess(int ni, int nj) {
        for (Student s : princess) {
            if (s.i == ni && s.j == nj) {
                return true;
            }
        }
        return false;
    }

    static class Student {
        int i;
        int j;
        String group;

        public Student(int i, int j, String group) {
            this.i = i;
            this.j = j;
            this.group = group;
        }
    }
}
