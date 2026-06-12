import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                map.put(rank[i],i);
                list.add(rank[i]);
            }
        }
        Collections.sort(list);
        int a = map.get(list.get(0));
        int b = map.get(list.get(1));
        int c = map.get(list.get(2));
        return 10000 * a + 100 * b + c;
    }
}