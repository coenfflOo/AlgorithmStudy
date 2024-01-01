package java_2023.October;
import java.util.*;
import java.io.*;
public class bj1012 {
    static int[][] land;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            land = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st2.nextToken());
                int Y = Integer.parseInt(st2.nextToken());
                land[X][Y] = 1;
            }

            int result = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (land[i][j] == 1 && !visited[i][j]) {
                        // 아직 방문하지 않은 배추가 있는 위치에서 DFS 탐색
                        dfs(land, visited, i, j);
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int[][] field, boolean[][] visited, int x, int y) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동 시 x좌표 변경
        int[] dy = {0, 0, -1, 1}; // 상하좌우 이동 시 y좌표 변경

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) { // 상하좌우 네 방향으로 이동할 수 있는지 확인
            int newX = x + dx[i]; // 새로운 x 좌표
            int newY = y + dy[i]; // 새로운 y 좌표

            if (newX >= 0 && newX < field.length && newY >= 0 && newY < field[0].length
                    && field[newX][newY] == 1 && !visited[newX][newY]) {
                // 다음 이동할 위치가 배열 범위 안에 있고, 해당 위치에 배추가 있으며 아직 방문하지 않았을 때
                dfs(field, visited, newX, newY); // 새로운 위치 newX와 newY에서 다시 탐색
            }
        }
    }
}