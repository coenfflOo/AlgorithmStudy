import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        PriorityQueue<Str> str = new PriorityQueue<>();
        for(String s : strings){
            str.offer(new Str(s,n));
        }
        String[] answer = new String[strings.length];
        int i = 0;
        while(!str.isEmpty()){
            answer[i++]=str.poll().s;
        }
        return answer;
    }
    
    class Str implements Comparable<Str> {
        String s;
        int index;
        public Str(String s,int index){
            this.s = s;
            this.index = index;
        }
        
        @Override
        public int compareTo(Str o){
            int cur = s.charAt(index)-'a';
            int other = o.s.charAt(o.index)-'a';
            if(cur==other){
                return s.compareTo(o.s);
            } else return cur-other;
        }
    }
}