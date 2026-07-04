import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> list = new ArrayList<>();
        for(int l : lottos){
            if(l==0) continue;
            list.add(l);
        }
        if(list.size()==0) return new int[]{1,6};
        int[] answer = new int[2];
        for(int n:win_nums){
            if(list.contains(n)) answer[1]++;
        }
        answer[0] = answer[1]+(6-list.size());
        for(int i=0; i<2; i++){
            answer[i] = 6-answer[i]+1>5? 6: 6-answer[i]+1;
        }
        return answer;
    }
}