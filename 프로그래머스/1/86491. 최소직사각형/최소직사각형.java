import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int n=0;
        int m=0;
        for(int i=0; i<sizes.length;i++){
            for(int j=0; j<2; j++){
                n = Math.max(n,Math.max(sizes[i][0],sizes[i][1]));
                m = Math.max(m,Math.min(sizes[i][0],sizes[i][1]));
            }
        }
        int answer = n*m;
        return answer;
    }
}