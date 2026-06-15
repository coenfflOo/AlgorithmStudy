import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int[] line = new int[250];
        for(int i=0; i<lines.length; i++){
            for(int j=lines[i][0]; j<lines[i][1]; j++){
                line[j+100]++;
            }
        }
        int answer = 0;
        for(int i=0; i<line.length; i++){
            if(line[i]>1) answer++;
        }
        return answer;
    }
}