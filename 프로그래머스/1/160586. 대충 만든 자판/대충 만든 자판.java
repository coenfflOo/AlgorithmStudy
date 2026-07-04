import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for(String k : keymap){
            for(int i=0; i<k.length(); i++){
                char c = k.charAt(i);
                map.put(c,Math.min(i+1,map.getOrDefault(c,200)));
            }
        }
        int[] answer = new int[targets.length];
        for(int i=0; i<targets.length; i++){
            String s = targets[i];
            out: for(int j=0; j<s.length(); j++){
                if(!map.containsKey(s.charAt(j))){
                    answer[i] = -1;
                    break out;
                }
                answer[i] += map.get(s.charAt(j));
            }
        }
        return answer;
    }
}