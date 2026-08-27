import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[][] time = new int[3][2];
        String[] vl = video_len.split(":");
        time[0][0] = Integer.parseInt(vl[0]);
        time[0][1] = Integer.parseInt(vl[1]);
        String[] os = op_start.split(":");
        time[1][0] = Integer.parseInt(os[0]);
        time[1][1] = Integer.parseInt(os[1]);
        String[] oe = op_end.split(":");
        time[2][0] = Integer.parseInt(oe[0]);
        time[2][1] = Integer.parseInt(oe[1]);
        String[] p = pos.split(":");
        int[] cur = new int[]{Integer.parseInt(p[0]), Integer.parseInt(p[1])};
        
        cur = skip(cur, time);
        if(cur[0]==0&&cur[1]<10) cur[1]=0;
        if(cur[0]==time[0][0]&&time[0][1]-cur[1]<10) cur = new int[]{time[0][0], time[0][1]};
        for(String c: commands){
            switch(c){
                case "prev":
                    cur[1]-=10;
                    if(cur[1]<0){
                        if(cur[0]==0){
                            cur[1] = 0;
                        } else {
                            cur[0]-=1;
                            cur[1]=60+cur[1];
                        }
                    }
                    if(cur[0]==0&&cur[1]<10) cur[1]=0;
                    break;
                case "next":
                    cur[1]+=10;
                    if(cur[1]>=60){
                        cur[0]+=1;
                        cur[1]-=60;
                    }
                    if(cur[0]>time[0][0]||(cur[0]==time[0][0]&&cur[1]>=time[0][1])) cur = time[0];
                    if(cur[0]==time[0][0]&&time[0][1]-cur[1]<10) cur = new int[]{time[0][0], time[0][1]};
                    break;
            }
            cur = skip(cur, time);
        }
        if(cur[0]<0) return "00:00";
        else if(cur[0]>time[0][0]||(cur[0]==time[0][0]&&cur[1]>time[0][1])) return video_len;
        cur = skip(cur, time);
        if(cur[0]==0&&cur[1]<10) cur[1]=0;
        if(cur[0]==time[0][0]&&time[0][1]-cur[1]<10) cur = new int[]{time[0][0], time[0][1]};
        String answer = "";
        if(cur[0]<10) answer+="0";
        answer+=String.valueOf(cur[0])+":";
        if(cur[1]<10) answer+="0";
        answer+=String.valueOf(cur[1]);
        return answer;
    }
    
    private static int[] skip(int[] cur, int[][] time){
        if((cur[0]==time[1][0]&&cur[1]>=time[1][1])||cur[0]>time[1][0]){
            if(cur[0]<time[2][0]||(cur[0]==time[2][0]&&cur[1]<=time[2][1])){
                return new int[]{time[2][0], time[2][1]};
            } else return cur;
        } return cur;
    }
}