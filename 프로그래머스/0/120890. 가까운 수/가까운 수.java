import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(array);
        for(int a: array){
            if(Math.abs(n-a)<Math.abs(n-answer)){
                answer = a;
            }
        }
        return answer;
    }
}