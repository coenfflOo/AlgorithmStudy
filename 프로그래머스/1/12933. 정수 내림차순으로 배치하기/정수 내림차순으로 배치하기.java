import java.util.*;
class Solution {
    public long solution(long n) {
        String[] str = String.valueOf(n).split("");
        Arrays.sort(str);
        
        long answer = 0;
        for(int i=str.length-1; i>=0; i--){
            answer = answer*10+Integer.parseInt(str[i]);
        }
        return answer;
    }
}