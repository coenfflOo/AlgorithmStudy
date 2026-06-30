import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            int s = score[i];
            if(queue.isEmpty()) queue.offer(s);
            else {
                if(queue.size()==k) {
                    if(queue.peek()<=s) {
                        queue.poll();
                    } else {
                        answer[i] = queue.peek();
                        continue;
                    }
                }
                queue.offer(s);
            }
            answer[i] = queue.peek();
        }
        return answer;
    }
}