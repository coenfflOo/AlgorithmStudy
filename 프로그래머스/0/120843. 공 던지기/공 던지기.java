class Solution {
    public int solution(int[] numbers, int k) {
        k = (k-1)*2 % numbers.length;
        int answer = numbers[k];
        return answer;
    }
}