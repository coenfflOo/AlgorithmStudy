package java_2023.October;

import java.io.*;

public class bj2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }

        drawStars(arr, N, 0, 0);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void drawStars(char[][] arr, int N, int x, int y) {
        // Base case: N이 3일 때 별 찍기 패턴
        if (N == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        arr[x + i][y + j] = ' ';
                    } else {
                        arr[x + i][y + j] = '*';
                    }
                }
            }
            return;
        }

        int size = N / 3;

        // 3x3 영역을 재귀적으로 호출하여 별 찍기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    for (int k = 0; k < size; k++) {
                        for (int l = 0; l < size; l++) {
                            arr[x + i * size + k][y + j * size + l] = ' ';
                        }
                    }
                } else {
                    drawStars(arr, size, x + i * size, y + j * size);
                }
            }
        }
    }
}