import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int a: array){
            String s = String.valueOf(a);
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='7') answer++;
            }
        }
        return answer;
    }
}