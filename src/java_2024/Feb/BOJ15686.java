package java_2024.Feb;
import java.util.*;
import java.io.*;
public class BOJ15686 {
    static int N;
    static int M;
    static int[][] city;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        combChicken(0);
    }

    private static void combChicken(int cnt) {

    }
}
