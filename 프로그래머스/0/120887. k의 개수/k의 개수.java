class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int num=i; num<=j; num++){
            int cur = num;;
            while(cur>0){
                if(cur%10==k) answer++;
                cur/=10;
            }
        }
        return answer;
    }
}