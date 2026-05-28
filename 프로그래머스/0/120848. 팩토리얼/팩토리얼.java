class Solution {
    public int solution(int n) {
        int answer = 1;
        int mul = 1;
        while(mul<=n){
            answer++;
            mul*=answer;
        }
        return answer-1;
    }
}