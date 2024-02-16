package java_2024.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992 {
    static int N;
    static String[][] video;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new String[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            video[i] = br.readLine().split("");
        }

        Point start = new Point(0, 0);
        Point end = new Point(N, N);
        sb = new StringBuilder();
        changeVideo(start, end);
        System.out.println(sb.toString());
    }

    private static void changeVideo(Point start, Point end) {
        if (checkAllBlack(start, end)) {
            sb.append("1");
            return;
        } else if (checkAllWhite(start, end)) {
            sb.append("0");
            return;
        } else {
            sb.append("(");
            changeVideo(start, new Point((start.i + end.i) / 2, (start.j + end.j) / 2));
            changeVideo(new Point(start.i, (start.j + end.j) / 2), new Point((start.i + end.i) / 2, end.j));
            changeVideo(new Point((start.i + end.i) / 2, start.j), new Point(end.i, (start.j + end.j) / 2));
            changeVideo(new Point((start.i + end.i) / 2, (start.j + end.j) / 2), end);
            sb.append(")");
        }
    }

    private static boolean checkAllBlack(Point start, Point end) {
        for (int i = start.i; i < end.i; i++) {
            for (int j = start.j; j < end.j; j++) {
                if (video[i][j].equals("0")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkAllWhite(Point start, Point end) {
        for (int i = start.i; i < end.i; i++) {
            for (int j = start.j; j < end.j; j++) {
                if (video[i][j].equals("1")) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

