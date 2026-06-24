class Solution {
    public int solution(int num) {
        if(num==1) return 0;
        int answer = 0;
        long cur = (long) num;
        while(cur!=1){
            if(cur%2==0){
                cur /= 2;
            } else {
                cur = (long)cur*3 +1;
            }
            answer++;
            if(answer>500) break;
        }
        if(num!=1&&answer==501) return -1;
        return answer;
    }
}