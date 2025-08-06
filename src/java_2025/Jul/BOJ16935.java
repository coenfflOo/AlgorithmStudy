package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ16935 {
    static int n,m,r;
    static int[][] map;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int order = Integer.parseInt(br.readLine());
        switch (order) {
            case 1:
                upDown();
                break;
            case 2:
                leftRight();
                break;
            case 3:
                turnRight();
                break;
            case 4:
                turnLeft();
                break;
            case 5:
                groupRight();
                break;
            case 6:
                groupLeft();
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void upDown() {

    }

    static void leftRight() {}

    static void turnRight() {}

    static void turnLeft() {}

    static void groupRight() {}

    static void groupLeft() {}
}
