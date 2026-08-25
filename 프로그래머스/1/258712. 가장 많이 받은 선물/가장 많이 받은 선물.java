import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] gat = new int[n][n];
        Map<String, Integer> map = new HashMap<>();
        for(String f: friends){
            map.put(f,map.size());
        }
        int[] index = new int[n];
        for(String s: gifts){
            int give = map.get(s.split(" ")[0]);
            int take = map.get(s.split(" ")[1]);
            gat[give][take]++;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                index[i]+=gat[i][j];
                index[i]-=gat[j][i];
            }
        }
        int[] present = new int[n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(gat[i][j]>gat[j][i]){
                    present[i]++;
                } else if (gat[i][j]==gat[j][i]) {
                    if(index[i]>index[j]) present[i]++;
                    else if(index[i]<index[j])present[j]++;
                } else {
                    present[j]++;
                }
            }
        }
        int answer = 0;
        for(int p:present){
            answer = Math.max(answer, p);
        }
        return answer;
    }
}