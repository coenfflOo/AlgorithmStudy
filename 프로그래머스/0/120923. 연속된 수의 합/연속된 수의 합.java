import java.util.*;
class Solution {
    public int[] solution(int num, int total) {
        int sum = 0;
        int index = -50;
        for(int i=-50; i<num-50; i++){
            sum+=i;
        }
        while(sum!=total){
            sum-=index;
            sum+=index+num;
            index++;
        }
        int[] answer = new int[num];
        for(int i=index; i<index+num; i++){
            answer[i-index] = i;
        }
        return answer;
    }
}