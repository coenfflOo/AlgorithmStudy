class Solution {
    public int solution(int a, int b) {
        int answer = Math.max(2*a*b, Integer.parseInt(String.valueOf(a)+String.valueOf(b)));
        return answer;
    }
}