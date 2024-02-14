package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] students = new int[6][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken())-1;
            students[y][s] += 1;
        }

        int room = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                room += students[i][j]/k;
                if (students[i][j]%k != 0)
                    room++;
            }
        }
        System.out.println(room);
    }
}
