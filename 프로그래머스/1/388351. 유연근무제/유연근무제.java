import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int[] limits = new int[schedules.length];
        for(int i=0; i<schedules.length; i++){
            int limit = schedules[i]+10;
            if(limit%100>=60){
                limit += 40;
            }
            limits[i] = limit;
        }
        System.out.println(Arrays.toString(limits));
        boolean[] impossible = new boolean[schedules.length];
        for(int i=0; i<timelogs.length; i++){
            int sd = startday;
            int[] time = timelogs[i];
            int limit = limits[i];
            for(int t : time){
                if(sd == 6 || sd == 7) {
                    sd = sd+1>7? 1: sd+1;
                    continue;
                }
                if(t>limit) impossible[i] = true;
                sd = sd+1>7? 1: sd+1;
            }
        }
        int answer = 0;
        for(boolean ip : impossible){
            if(!ip) answer++;
        }
        return answer;
    }
}