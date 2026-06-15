import java.util.*;
class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int answer = sides[0]-1;
        System.out.println(answer);
        answer += sides[1]-(sides[1]-sides[0]);
        return answer;
    }
}