import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int i=0;
        while(budget>0){
            if(i>=d.length || budget-d[i]<0) break;
            budget-=d[i++];
            answer++;
        }
        return answer;
    }
}