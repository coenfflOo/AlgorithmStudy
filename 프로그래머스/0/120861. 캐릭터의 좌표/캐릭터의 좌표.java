import java.util.*;
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int x = 0;
        int y = 0;
        for(String s: keyinput){
            int dir = -1;
            switch(s){
                case "up":
                    dir = 0;
                    break;
                case "down":
                    dir = 1;
                    break;
                case "left":
                    dir = 2;
                    break;
                case "right":
                    dir = 3;
                    break;
            }
            x += dx[dir];
            y += dy[dir];
            if(x<((board[0]/2)*-1)||x>board[0]/2||y<((board[1]/2)*-1)||y>board[1]/2) {
                x -= dx[dir];
                y -= dy[dir];
            }
        }
        int[] answer = {x,y};
        return answer;
    }
}