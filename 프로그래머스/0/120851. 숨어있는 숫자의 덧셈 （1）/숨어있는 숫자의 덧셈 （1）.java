import java.util.*;
class Solution {
    public int solution(String my_string) {
        List<Character> list = new ArrayList<>();
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        int answer = 0;
        for(int i=0; i<my_string.length(); i++){
            if(list.contains(my_string.charAt(i))){
                answer+=(int)(my_string.charAt(i)-'0');
            }
        }
        return answer;
    }
}