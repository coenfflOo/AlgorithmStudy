import java.util.*;
class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] str = my_string.split("");
        String s = str[num1];
        str[num1] = str[num2];
        str[num2] = s;
        
        String answer = "";
        for(String ss: str) answer += ss;
        return answer;
    }
}