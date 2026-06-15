import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        int n = board.length;
        int m = board[0].length;
        boolean[][] map = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==1){
                    map[i][j] = true;
                    for(int k=0; k<8; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx<0||ny<0||nx>=n||ny>=m) continue;
                        map[nx][ny] = true;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!map[i][j]) answer++;
            }
        }
        return answer;
    }
}