package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ1074 {
    static int visited = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        int answer = recursiveZ(r, c, size);

        System.out.println(answer);
    }

    private static int recursiveZ(int r, int c, int size) {
        if (size == 1) {
            return visited;
        }

        int halfSize = size / 2;
        int quadrant = 0;

        if (r >= halfSize) { // 1,2 사분면인지 3,4 사분면인지
            // 3,4 사분면이라면
            quadrant += 2;
            r -= halfSize;
        }
        if (c >= halfSize) { // 1,3 사분면인지 2,4 사분면인지,
            // 2,4 사분면이라면
            quadrant += 1;
            c -= halfSize;
        }

        int subSize = halfSize * halfSize; // 4개로 나눈 뒤의 하나의 사분면 계산
        visited += subSize * quadrant; // r, c가 속한 사분면 외의 사분면 계산

        return recursiveZ(r, c, halfSize);
    }
}
