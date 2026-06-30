class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remain = 0;
        while(n>=a){
            answer+=(n/a)*b;
            remain = n%a;
            n = n/a*b;
            if(remain!=0) {
                n+=remain;
                remain = 0;
            }
        }
        return answer;
    }
}