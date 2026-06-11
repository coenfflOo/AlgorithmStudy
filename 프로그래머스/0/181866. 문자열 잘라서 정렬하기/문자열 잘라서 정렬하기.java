import java.util.*;
class Solution {
    public String[] solution(String myString) {
        myString = myString.replaceAll("x"," ");
        String[] answer = myString.replaceAll("\\s+", " ").trim().split(" ");
        Arrays.sort(answer);
        return  answer;
    }
}