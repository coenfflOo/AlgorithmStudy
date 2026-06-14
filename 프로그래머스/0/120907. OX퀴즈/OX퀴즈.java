import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++){
            String[] q = quiz[i].split(" ");
            int num = Integer.parseInt(q[0]);
            switch(q[1]){
                case "+":
                    num+=Integer.parseInt(q[2]);
                    break;
                 case "-":
                    num-=Integer.parseInt(q[2]);
                    break;
                    
            }
            if(num==Integer.parseInt(q[4])) answer[i] = "O";
            else answer[i] = "X";
        }
        return answer;
    }
}