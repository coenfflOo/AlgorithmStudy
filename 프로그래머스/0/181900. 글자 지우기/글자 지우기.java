import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        int index = 0;
        Arrays.sort(indices);
        for(int i=0; i<my_string.length(); i++){
            if(index<indices.length&&i==indices[index]){
                index++;
                continue;
            }
            answer+=String.valueOf(my_string.charAt(i));
        }
        return answer;
    }
}