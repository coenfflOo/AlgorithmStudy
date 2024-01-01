package java_2023.October;
import java.util.*;
import java.io.*;
public class bj1697 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bw.write(String.valueOf(bfs(N, K)));
        bw.flush();
    }

    // 시작 위치 start에서 목표 위치 target까지의 최단 이동 시간을 계산
    private static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 시작 위치 : 수빈이의 현재 위치
        visited[start] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == target) {
                    return time;
                }

                int[] nextPositions = {current - 1, current + 1, current * 2};
                for (int next : nextPositions) {
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }

            time++;
        }

        return -1; // 동생을 찾지 못한 경우
    }
}
// 수빈이는 걷거나 순간이동을 할 수 있다.
// 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지
// 구하는 프로그램을 작성하시오.