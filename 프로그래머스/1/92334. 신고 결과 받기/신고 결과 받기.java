import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String id: id_list){
            list.add(new ArrayList<>());
            map.put(id, map.size());
        }
        for(String r: report){
            String[] str = r.split(" ");
            List<Integer> ids = list.get(map.get(str[1]));
            if(!ids.contains(map.get(str[0]))) ids.add(map.get(str[0]));
        }
        int[] answer = new int[id_list.length];
        for(String id: id_list){
            int idx = map.get(id);
            if(list.get(idx).size()>=k){
                for(int num : list.get(idx)){
                    answer[num]++;
                }
            }
        }
        return answer;
    }
}