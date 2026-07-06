import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        int[] prev = new int[players.length];
        int[] next = new int[players.length];
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
            if(i == 0){
                prev[i] = -1;
                next[i] = i+1;
            } else if(i == players.length-1){
                prev[i] = i-1;
                next[i] = -1;
            } else {
                prev[i] = i-1;
                next[i] = i+1;
            }
        }
        for(String name : callings){
            int a = map.get(name); 
            int b = prev[a];
            int x = prev[b];
            int y = next[a];
            
            if (x != -1) next[x] = a;
            prev[a] = x;

            next[a] = b;
            prev[b] = a;

            next[b] = y;
            if (y != -1) prev[y] = b;
        }
        String[] answer = new String[players.length];
        int cur = 0;
        while (prev[cur] != -1) {
            cur = prev[cur];
        }
        for (int i = 0; i < players.length; i++) {
            answer[i] = players[cur];
            cur = next[cur];
        }
        return answer;
    }
}