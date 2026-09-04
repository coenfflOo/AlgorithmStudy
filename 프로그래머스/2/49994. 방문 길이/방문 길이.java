import java.util.*;
class Solution {
    public int solution(String dirs) {
        int[][] map = new int[11][11];
        int[] cur = {5,5};
        int answer = 0;
        Set<String> visited = new HashSet<>();
        for(String s : dirs.split("")){
            int d=-1;
            switch(s){
                case "R":
                    d = 0;
                    break;
                case "L":
                    d=1;
                    break;
                case "D":
                    d=2;
                    break;
                case "U":
                    d=3;
                    break;
            }
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            int nx = cur[0]+dx[d];
            int ny = cur[1]+dy[d];
            
            if(nx<0||ny<0||nx>=11||ny>=11) continue;
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(nx).append(" ").append(ny).append(" ").append(cur[0]).append(" ").append(cur[1]);
            sb2.append(cur[0]).append(" ").append(cur[1]).append(" ").append(nx).append(" ").append(ny);
            if(!visited.contains(sb1.toString())) {
                answer++;
                visited.add(sb1.toString());
                visited.add(sb2.toString());
            }
            cur = new int[]{nx,ny};
        }
        return answer;
    }
}