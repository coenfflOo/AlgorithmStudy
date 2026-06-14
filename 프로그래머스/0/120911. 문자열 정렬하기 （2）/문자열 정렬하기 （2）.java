import java.util.*;
class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        String[] str = my_string.split("");
        Arrays.sort(str);
        String answer = "";
        for(String s: str) answer+=s;
        return answer;
    }
}