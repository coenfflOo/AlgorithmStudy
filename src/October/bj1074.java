package October;
import java.util.*;
import java.io.*;
public class bj1074 {
    static int visited = 0; // 현재까지 방문한 칸의 개수를 나타내는 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2,N);
        int answer = recursiveZOrder(r, c, size);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int recursiveZOrder(int r, int c, int size) {
        if (size == 1) { // 배열의 크기가 1x1 = 분할할 필요가 없는 하나의 원소 위치
            return visited;
        }

        int halfSize = size / 2; // 사분면의 크기
        int quadrant = 0;

        if (r >= halfSize) {
            quadrant += 2;  // 3 or 4 사분면
            r -= halfSize;
        }
        if (c >= halfSize) {
            quadrant += 1;  // 2nd or 4th quadrant
            c -= halfSize;
        }

        int subSize = halfSize * halfSize; // 해당 사분면에서 방문한 칸의 수
        visited += subSize * quadrant; // 현재 사분면의 방문 횟수 누적

        return recursiveZOrder(r, c, halfSize);
    }
}
