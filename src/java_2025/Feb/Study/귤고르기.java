package java_2025.Feb.Study;
import java.util.*;
import java.io.*;
public class 귤고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t: tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        keySetList.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key : keySetList){
            k -= map.get(key);
            answer++;
            if(k<=0)
                break;
        }

        return answer;
    }
}
