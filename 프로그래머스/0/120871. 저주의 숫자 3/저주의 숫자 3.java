import java.util.*;
class Solution {
    public int solution(int n) {
        int[] arr = new int[101];
        int num = 0;
        for(int i=0; i<101; i++){
            arr[i] = num++;
            while(num%3==0||String.valueOf(num).contains("3")){
                num++;
            }
        }
        int answer = arr[n];
        return answer;
    }
}