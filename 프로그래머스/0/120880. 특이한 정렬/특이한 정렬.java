import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        PriorityQueue<Number> queue = new PriorityQueue<>();
        for(int num: numlist){
            queue.offer(new Number(num, Math.abs(num-n)));
        }
        int[] answer = new int[numlist.length];
        for(int i=0; i<numlist.length; i++){
            answer[i] = queue.poll().value;
        }
        return answer;
    }
    
    static class Number implements Comparable<Number>{
        int value;
        int abs;
        
        public Number (int v, int i){
            this.value = v;
            this.abs = i;
        }
        
        @Override
        public int compareTo(Number o){
            if(o.abs==this.abs) return o.value - this.value;
            return this.abs-o.abs;
        }
    }
}