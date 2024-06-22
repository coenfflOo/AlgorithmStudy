package java_2024.Apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18428 {
    static int n;
    static String[][] map;
    static List<Point> list;
    static List<Point> teachers;
    static boolean[] select;
    static String[][] copy;
    static boolean find;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        StringTokenizer st;
        list = new ArrayList<>();
        teachers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("X")) {
                    list.add(new Point(i, j));
                } else if (map[i][j].equals("T")) {
                    teachers.add(new Point(i, j));
                }
            }
        }
        select = new boolean[list.size()];

        find = true;
        combObstacle(0, 0);

        if (!find) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    private static void combObstacle(int cnt, int target) {
        if (cnt == 3) {
            // 배열 복사
            makeCopy();

            // 장애물 만들기
            for (int i = 0; i < select.length; i++) {
                if (select[i]) {
                    Point p = list.get(i);
                    copy[p.i][p.j] = "O";
                }
            }
            if (!findStudent()) {
                find = false;
            }
            printMap();
            return;
        }

        if (target == list.size()) {
            return;
        }

        select[target] = true;
        combObstacle(cnt + 1, target + 1);
        select[target] = false;
        combObstacle(cnt, target + 1);
    }

    private static boolean findStudent() {

        for (Point teacher : teachers) {
            boolean obj = false;
            for (int i = teacher.i + 1; i < n; i++) {
                if (copy[i][teacher.j].equals("S") && !obj) {
                    return true;
                } else if (copy[i][teacher.j].equals("O")) {
                    obj = true;
                } else if (copy[i][teacher.j].equals("X") && !obj) {
                    copy[i][teacher.j] = "-";
                }
            }
            obj = false;
            for (int i = teacher.j + 1; i < n; i++) {
                if (copy[teacher.i][i].equals("S") && !obj) {
                    return true;
                } else if (copy[teacher.i][i].equals("O")) {
                    obj = true;
                } else if (copy[teacher.i][i].equals("X") && !obj) {
                    copy[teacher.i][i] = "-";
                }
            }
            obj = false;
            for (int i = teacher.i; i >= 0; i--) {
                if (copy[i][teacher.j].equals("S") && !obj) {
                    return true;
                } else if (copy[i][teacher.j].equals("O")) {
                    obj = true;
                } else if (copy[i][teacher.j].equals("X") && !obj) {
                    copy[i][teacher.j] = "-";
                }
            }
            obj = false;
            for (int i = teacher.j; i >= 0; i--) {
                if (copy[teacher.i][i].equals("S") && !obj) {
                    return true;
                } else if (copy[teacher.i][i].equals("O")) {
                    obj = true;
                } else if (copy[teacher.i][i].equals("X") && !obj) {
                    copy[teacher.i][i] = "-";
                }
            }
        }
        return false;
    }

    private static void makeCopy() {
        copy = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    private static void printMap() {
        System.out.println("=====================================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=====================================");
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

