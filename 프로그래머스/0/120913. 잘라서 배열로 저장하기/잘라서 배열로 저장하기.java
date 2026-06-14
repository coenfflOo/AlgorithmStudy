import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length()%n==0? (int)my_str.length()/n : (int)my_str.length()/n+1;
        String[] answer = new String[len];
        int start = 0;
        for(int i=0; i<len; i++){
            answer[i] = my_str.substring(start,Math.min(start+n,my_str.length()));
            start += n;
        }
        return answer;
    }
}