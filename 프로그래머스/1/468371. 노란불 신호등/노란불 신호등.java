import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        List<boolean[]> isYellow = new ArrayList<>();
        int max = 1;
        for(int i=0; i<n; i++){
            int[] time = signals[i];
            boolean[] check = new boolean[time[0]+time[1]+time[2]];
            for(int k=time[0];k<time[0]+time[1];k++){
                check[k] = true;
            }
            isYellow.add(check);
            max *= check.length;
        }
        int answer = 1;
        while(answer<=max){
            boolean flag = true;
            for(boolean[] y : isYellow){
                if(!y[(answer-1)%y.length]) {
                    flag = false;
                    break;
                }
            }
            if(flag) break;
            answer++;
        }
        return answer>max? -1 : answer;
    }
}