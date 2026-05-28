import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c-'a'<0){
                list.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}