import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String s: strArr){
            map.put(s.length(),map.getOrDefault(s.length(),0)+1);
        }
        int answer = 0;
        for(int key:map.keySet()){
            answer = Math.max(answer,map.get(key));
        }
        return answer;
    }
}