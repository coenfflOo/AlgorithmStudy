import java.util.*;
class Solution {
    public int solution(String s) {
        String[] str = s.split(" ");
        int prev = 0;
        int answer = 0;
        for(String ss: str){
            if(ss.equals("Z")) answer -= prev;
            else {
                answer += Integer.parseInt(ss);
                prev = Integer.parseInt(ss);
            }
        }
        return answer;
    }
}