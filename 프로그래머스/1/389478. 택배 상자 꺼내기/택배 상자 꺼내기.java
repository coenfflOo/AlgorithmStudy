import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int row = (num-1)/w;
        int colBase = (num-1)%w;
        int col = row%2==0? colBase : w-1-colBase;
        
        int count = 0;
        int curRow = row;
        while(true){
            int curColBase = (curRow % 2 == 0) ? col : (w - 1 - col);
            int curNum = curRow * w + curColBase + 1;

            if (curNum > n) break;
            count++;
            curRow++;
        }
        return count;
    }
}