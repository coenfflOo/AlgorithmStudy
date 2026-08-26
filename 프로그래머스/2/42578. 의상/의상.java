import java.util.*;
class Solution {
    static List<List<String>> list;
    static Map<String, Integer> map;
    static int answer;
    static boolean[] used;
    public int solution(String[][] clothes) {
        list = new ArrayList<>();
        map = new HashMap<>();
        for(String[] c: clothes){
            if(!map.containsKey(c[1])){
                map.put(c[1], map.size());
                list.add(new ArrayList<>());
            }
            list.get(map.get(c[1])).add(c[0]);
        }
        used = new boolean[list.size()];
        answer = 0;
        comb(0);
        return answer;
    }
    
    private static void comb(int idx){
        if(idx==list.size()){
            if(check()) 
                answer++;
            return;
        }
        
        List<String> co = list.get(idx);
        used[idx] = true;
        for(int j=0;j<co.size();j++){
            comb(idx+1);
        }
        used[idx] = false;
        comb(idx+1);
    }
    
    private static boolean check(){
        for(boolean u:used){
            if(u) return true;
        }
        return false;
    }
}