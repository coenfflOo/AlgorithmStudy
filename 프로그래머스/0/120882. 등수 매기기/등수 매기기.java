import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        PriorityQueue<Score> queue = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            queue.offer(new Score((double)(score[i][0]+score[i][1])/2,i));
        }
        
        double prev = -1;
        int pr = -1;
        int rank = 1;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Score cur = queue.poll();
            if(prev==cur.value) {
                list.add(cur.index);
                if(list.size()==1) pr = rank-1;
            } else {
                if(list.size()!=0){
                    for(int i=0; i<list.size();i++){
                        answer[list.get(i)] = pr;
                    }
                    list = new ArrayList<>();
                    pr = -1;
                }
                answer[cur.index] = rank;
            }
            prev = cur.value;
            rank++;
        }
        if(list.size()!=0){
            for(int i=0; i<list.size();i++){
                answer[list.get(i)] = pr;
            }
        }
        return answer;
    }
    
    static class Score implements Comparable<Score>{
        double value;
        int index;
        
        Score (double v, int i){
            this.value = v;
            this.index = i;
        }
        
        @Override
        public int compareTo(Score o){
            if(o.value>this.value)
                return 1;
            else if(o.value<this.value) return -1;
            return 0;
        }
    }
}