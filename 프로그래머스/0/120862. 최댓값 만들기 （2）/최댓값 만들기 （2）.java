import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        if(numbers.length==2) return numbers[0]*numbers[1];
        int answer = Math.max(numbers[0]*numbers[1], numbers[numbers.length-2]*numbers[numbers.length-1]);
        return answer;
    }
}