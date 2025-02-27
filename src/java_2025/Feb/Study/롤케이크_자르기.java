package java_2025.Feb.Study;
import java.util.*;

public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        int left = 0;
        int right = 1;
        Map<Integer, Integer> lmap = new HashMap<>();
        Map<Integer, Integer> rmap = new HashMap<>();
        lmap.put(topping[0], lmap.getOrDefault(topping[0],0)+1);
        for(int i=1; i<topping.length; i++){
            rmap.put(topping[i], rmap.getOrDefault(topping[i], 0) + 1);
        }
        while(right<topping.length-1){
            if(lmap.size()==rmap.size()){
                answer++;
            }
            left++;
            int target = topping[left];
            lmap.put(target, lmap.getOrDefault(target,0)+1);
            right++;
            if(rmap.containsKey(target)){
                if(rmap.get(target)==1){
                    rmap.remove(target);
                } else {
                    rmap.put(target, rmap.get(target)-1);
                }
            }
        }
        return answer;
    }
}
