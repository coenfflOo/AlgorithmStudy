import java.util.*;
class Solution {
    public int solution(int num, int k) {
        int answer = String.valueOf(num).indexOf(String.valueOf(k))+1;
        answer = answer == 0? -1 : answer;
        return answer;
    }
}