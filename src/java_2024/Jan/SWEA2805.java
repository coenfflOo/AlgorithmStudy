package java_2024.Jan;

import java.util.Scanner;

public class SWEA2805 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] str = sc.next().split("");
                for (int j = 0; j < N; j++) {
                    farm[i][j] = Integer.parseInt(str[j]);
                }
            }

            int sum = 0;
            for (int i = 0; i <= N / 2; i++) {
                int j = N / 2 - i;
                for (int k = 1; k <= (i + 1) * 2 - 1; k++) {
                    sum += farm[i][j++];
                }
            }

            for (int i = N - N / 2; i < N; i++) { //3,4
                int j = i - N / 2;//1,2
                for (int k = (N - i) * 2 - 1; k > 0; k--) {//3,1
                    sum += farm[i][j++];
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
