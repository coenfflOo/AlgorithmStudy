import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for(String t: terms){
            String[] str = t.split(" ");
            map.put(str[0],Integer.parseInt(str[1]));
        }
        String[] todayStr = today.split("\\.");
        int ty = Integer.parseInt(todayStr[0]);
        int tm = Integer.parseInt(todayStr[1]);
        int td = Integer.parseInt(todayStr[2]);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            String[] pr = privacy[0].split("\\.");
            int limit = map.get(privacy[1]);
            int py = Integer.parseInt(pr[0]);
            int pm = Integer.parseInt(pr[1])+limit;
            int pd = Integer.parseInt(pr[2])-1;
            if(pm>12){
                py += (limit/12);
                pm -= limit;
                pm += limit%12;
                if(pm>12){
                    py++;
                    pm -= 12;
                }
            }
            if(pd<=0){
                pm--;
                pd+=31;
                if(pm==0){
                    py--;
                    pm = 12;
                }
            }
            if(py<ty) list.add(i+1);
            else if(py==ty&&pm<tm) list.add(i+1);
            else if(py==ty&&pm==tm&&pd<td) list.add(i+1);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}