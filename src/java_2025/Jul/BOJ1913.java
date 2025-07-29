package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1913 {
    static int n,m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringBuilder sb = new StringBuilder();

        createMap();

        int[] point = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
                if (map[i][j] == m){
                    point[0] = i+1;
                    point[1] = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(point[0]).append(" ").append(point[1]);
        System.out.println(sb);
    }

    private static void createMap() {
        int number = 1;
        int x = n/2, y = n/2;
        int limit = 1;
        while (true){
            for (int i = 0; i < limit; i++) {
                map[y--][x] = number++;
            }
            if (number-1==n*n) break;
            for (int i = 0; i < limit; i++) {
                map[y][x++] = number++;
            }
            limit++;
            for (int i = 0; i < limit; i++) {
                map[y++][x] = number++;
            }
            for (int i = 0; i < limit; i++) {
                map[y][x--] = number++;
            }
            limit++;
        }
    }
}
