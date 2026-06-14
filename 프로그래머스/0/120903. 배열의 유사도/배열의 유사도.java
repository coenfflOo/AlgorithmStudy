import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        List<String> list = new ArrayList<>();
        for(String s: s1){
            list.add(s);
        }
        int answer = 0;
        for(String s: s2){
            if(list.contains(s)) answer++;
        }
        return answer;
    }
}