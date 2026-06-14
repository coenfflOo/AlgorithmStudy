import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] str = my_string.split("");
        List<String> list = new ArrayList<>();
        for(String s:str){
            if(!list.contains(s)) answer+=s;
            list.add(s);
        }
        return answer;
    }
}