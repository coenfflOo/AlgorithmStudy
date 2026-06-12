import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int len = 1;
        while(len<arr.length) len*=2;
        int[] answer = new int[len];
        Arrays.fill(answer,0);
        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}