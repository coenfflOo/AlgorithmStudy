import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<Integer, String> map = new HashMap<>();
        int sum = 0;
        for(String p: participant){
            map.put(p.hashCode(), p);
            sum += p.hashCode();
        }
        for(String c : completion){
            sum -= c.hashCode();
        }
        return map.get(sum);
    }
}