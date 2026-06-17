import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (a,b) -> a[0]-b[0]);
        int answer = Math.abs(dots[0][1]-dots[1][1])*Math.abs(dots[1][0]-dots[2][0]);
        return answer;
    }
}