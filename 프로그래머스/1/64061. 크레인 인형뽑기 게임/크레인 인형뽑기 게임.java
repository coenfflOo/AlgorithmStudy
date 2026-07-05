import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack> list = new ArrayList<>();
        for(int i=0; i<=board.length; i++){
            list.add(new Stack<Integer>());
        }
        for(int k=board.length-1; k>=0; k--){
            for(int i=1; i<=board.length; i++){
                if(board[k][i-1]!=0) list.get(i).add(board[k][i-1]);
            }
        }
        int answer = 0;
        Stack<Integer> bomb = new Stack<>();
        for(int m: moves){
            Stack<Integer> s = list.get(m);
            if(s.isEmpty()) continue;
            int cur = s.pop();
            if(!bomb.isEmpty()&&bomb.peek()==cur){
                answer += 2;
                bomb.pop();
            } else {
                bomb.push(cur);
            }
        }
        return answer;
    }
}