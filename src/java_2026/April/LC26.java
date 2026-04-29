package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC26 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(word,i,j,board,0))return true;
                }
            }
        }
        return false;
    }
    public static boolean helper(String word,int i,int j,char[][]boards,int ind){
        // 단어 다 찾으면 성공!
        if (ind == word.length()) return true;

        // 범위 벗어나면 실패 (범위체크를 호출할때가 아닌 함수 안에서 처리!)
        if (i<0 || i>=boards.length || j<0 || j>=boards[0].length) return false;

        if (boards[i][j] == word.charAt(ind)) {
            char temp = boards[i][j];
            boards[i][j] = '#'; // visited 배열 대신 '#'으로 방문 표시!

            // 4방향 한번에 체크, 하나라도 true면 바로 return
            if (helper(word,i,j+1,boards,ind+1) ||
                    helper(word,i+1,j,boards,ind+1) ||
                    helper(word,i,j-1,boards,ind+1) ||
                    helper(word,i-1,j,boards,ind+1)) {
                boards[i][j] = temp; // 백트래킹
                return true;
            }
            boards[i][j] = temp; // 백트래킹
        }
        return false;
    }

//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static Queue<int[]> q;
//    static boolean[][] visited;
//
//    public static boolean exist(char[][] board, String word) {
//        int n = board.length;
//        int m = board[0].length;
//        char start = word.charAt(0);
//        q = new ArrayDeque<>();
//        visited = new boolean[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == start) {
//                    if (dfs(board, i, j, word, 1)) return true;
//                }
//            }
//        }
//
//        return false;
//    }
//    private static boolean dfs(char[][] board, int x, int y, String word, int cnt){
//        if (cnt == word.length()) return true;
//        // dfs 끝날 때 백트래킹 필요!
//        visited[x][y] = true;
//        for (int k = 0; k < 4; k++) {
//            int nx = x + dx[k];
//            int ny = y + dy[k];
//            if(nx<0||ny<0||nx>=board.length||ny>=board[0].length||visited[nx][ny]) continue;
//            if(board[nx][ny]==word.charAt(cnt)){
//                if (!visited[nx][ny]) {
//                    // dfs 결과를 반환godigka
//                    if (dfs(board, nx, ny, word, cnt+1)) return true;
//                }
//            }
//        }
//        // 다른 경로에서 재사용 가능하게!
//        visited[x][y] = false;
//        return false;
//    }
}
