import java.util.*;
class Solution {
    public int solution(String num_str) {
        String[] str = num_str.split("");
        int answer = 0;
        for(String s: str){
            answer+=Integer.parseInt(s);
        }
        return answer;
    }
}