import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int n= park.length;
        int m = park[0].length();
        int[][] map = new int[n][m];
        int[] cur = new int[2];
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                if(park[i].charAt(j)=='S'){
                    cur[0] = i;
                    cur[1] = j;
                } else if(park[i].charAt(j)=='X'){
                    map[i][j] = 1;
                }
            }
        }
        int[] dx = {0,0,1,-1};//e,w,s,n
        int[] dy = {1,-1,0,0};
        for(String r: routes){
            String[] str = r.split(" ");
            int dir = 0;
            switch(str[0]){
                case "E":
                    dir = 0;
                    break;
                case "W":
                    dir = 1;
                    break;
                case "S":
                    dir = 2;
                    break;
                case "N":
                    dir = 3;
                    break;
            }
            int times = Integer.parseInt(str[1]);
            // System.out.println(str[0]+" "+times+" "+dir);
            int nx = cur[0];
            int ny = cur[1];
            boolean flag = true;
            out: while(times-->0){
                nx += dx[dir];
                ny += dy[dir];
                if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==1){
                    flag = false;
                    break out;
                }
            }
            if(flag){
                cur[0] = nx;
                cur[1] = ny;
            }
            // System.out.println(Arrays.toString(cur));
        }
        return cur;
    }
}