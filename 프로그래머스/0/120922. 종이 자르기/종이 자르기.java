import java.util.*;
class Solution {
    public int solution(int M, int N) {
        int answer = (Math.min(M,N)-1)+(Math.min(M,N))*(Math.max(M,N)-1);
        return answer;
    }
}