import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] map = new int[N+1];
        int user = stages.length;
        for(int s: stages){
            if(s>N) s = 0;
            map[s]++;
        }
        PriorityQueue<Stage> queue = new PriorityQueue<>();
        for(int i=1; i<N+1; i++){
            double fail = 0;
            if(user != 0)
                fail = (double) map[i] / user;
            queue.offer(new Stage(i,fail));
            user -= map[i];
        }
        
        int[] answer = new int[N];
        int index = 0;
        while(!queue.isEmpty()){
            answer[index++] = queue.poll().stage;
        }
        return answer;
    }
    
    class Stage implements Comparable<Stage> {
        int stage;
        double fail;
        
        public Stage (int stage, double fail){
            this.stage = stage;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Stage o){
            if(o.fail == this.fail) return this.stage - o.stage;
            else if(Double.compare(o.fail, this.fail)>0) return 1;
            else return -1;
        }
    }
}