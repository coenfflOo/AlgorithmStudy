import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, 1);
        map.put(b, map.getOrDefault(b,0)+1);
        map.put(c, map.getOrDefault(c,0)+1);
        map.put(d, map.getOrDefault(d,0)+1);
        if(map.size()==1){
            answer = 1111 * a;
        } else if(map.size()==2){
            boolean sec = false;
            boolean flag = true;
            int p=0,q=0;
            for(int s: map.keySet()){
                if(map.get(s)==1){
                    answer += s;
                } else if(map.get(s) == 3){
                    answer += s*10;
                    sec = true;
                } else if(map.get(s)==2&&flag){
                    p=s;
                    flag = false;
                } else {
                    q=s;
                }
            }
            if(sec) answer = (int)Math.pow(answer,2);
            if(!flag) answer = (p+q)*(int)Math.abs(p-q);
        } else if(map.size()==3){
            answer = 1;
            for(int s: map.keySet()){
                if(map.get(s) != 2){
                    answer *= s;
                }
            }
        } else {
            answer = Math.min(a,Math.min(b, Math.min(c,d)));
        }
        return answer;
    }
}