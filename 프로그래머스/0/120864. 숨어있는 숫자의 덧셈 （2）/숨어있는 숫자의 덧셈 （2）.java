import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int prev = 0;
        for(int i=0; i<my_string.length();i++){
            char c = my_string.charAt(i);
            if(c=='0'&&prev==0)continue;
            if(c-'A'<0){
                prev = prev*10+Integer.parseInt(String.valueOf(c));
            } else {
                answer += prev;
                prev = 0;
            }
        }
        if(prev!=0) answer+=prev;
        return answer;
    }
}