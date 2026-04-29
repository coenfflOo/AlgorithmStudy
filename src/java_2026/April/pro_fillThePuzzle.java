package java_2026.April;
import java.util.*;
import java.lang.*;
public class pro_fillThePuzzle {
    static int n, index;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        // 빈칸 추출
        visited = new boolean[n][n];
        index = 0;
        List<List<int[]>> spaces = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(game_board[i][j]==0&&!visited[i][j]){
                    spaces.add(bfs(i,j,game_board,0));
                }
            }
        }

        // 조각 추출
        visited = new boolean[n][n];
        index = 0;
        List<List<int[]>> pieces = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(table[i][j]==1&&!visited[i][j]){
                    pieces.add(bfs(i,j,table,1));
                }
            }
        }

        // 정규화
        List<List<int[]>> normalizedSpaces = new ArrayList<>();
        for(List<int[]> list: spaces){
            normalizedSpaces.add(normalize(list));
        }

        List<List<int[]>> normalizedPieces = new ArrayList<>();
        for(List<int[]> list: pieces){
            normalizedPieces.add(normalize(list));
        }

        // 매칭
        boolean[] used = new boolean[normalizedPieces.size()];
        int answer = 0;

        for(List<int[]> space : normalizedSpaces) {
            for(int i=0; i<normalizedPieces.size(); i++) {
                if(used[i]) continue;
                List<int[]> piece = normalizedPieces.get(i);
                // 4번 회전하면서 비교
                for(int r=0; r<4; r++) {
                    if(isSame(space, piece)) {
                        used[i] = true;
                        answer += space.size();
                        break;
                    }
                    piece = rotate(piece);
                }
                if(used[i]) break;
            }
        }
        return answer;
    }

    private static List<int[]> bfs(int i, int j, int[][] map, int num){
        visited[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        List<int[]> find = new ArrayList<>();
        find.add(new int[]{i,j});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int k=0; k<4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny]||map[nx][ny]!=num) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
                find.add(new int[]{nx,ny});
            }
        }
        return find;
    }

    private static List<int[]> normalize(List<int[]> piece) {
        // x, y 최솟값 찾기
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for(int[] p : piece) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        // 최솟값을 빼서 (0,0) 기준으로 변환
        List<int[]> result = new ArrayList<>();
        for(int[] p : piece) {
            result.add(new int[]{p[0]-minX, p[1]-minY});
        }
        // 정렬 (비교를 위해 순서 통일)
        result.sort((a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        return result;
    }

    private static boolean isSame(List<int[]> a, List<int[]> b) {
        if(a.size() != b.size()) return false;
        for(int i=0; i<a.size(); i++) {
            if(a.get(i)[0] != b.get(i)[0]) return false;
            if(a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }

    // (x, y) → 90도 회전 → (y, -x) → 정규화
    private static List<int[]> rotate(List<int[]> piece) {
        List<int[]> result = new ArrayList<>();
        for(int[] p : piece) {
            result.add(new int[]{p[1], -p[0]});  // (x,y) → (y,-x)
        }
        result.sort((a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        return normalize(result);
    }
}
