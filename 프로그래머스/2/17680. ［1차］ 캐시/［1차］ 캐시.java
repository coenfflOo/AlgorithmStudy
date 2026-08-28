import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> queue = new ArrayDeque<>();
        int answer = 0;
        for(String c : cities){
            c = c.toLowerCase();
            if(queue.contains(c)){
                answer+=1;
                queue.remove(c);
                queue.push(c);
            } else {
                answer+=5;
                queue.push(c);
                if(queue.size()>cacheSize){
                    queue.pollLast();
                }
            }
        }
        return answer;
    }
}