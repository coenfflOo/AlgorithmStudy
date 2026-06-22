class Solution {
    public long solution(long n) {
        long answer = 0;
        for(long i = 1; i<50000000; i++){
            if(Math.pow(i,2)==n){
                answer = i+1;
            } else if(Math.pow(i,2)>n) break;
        }
        if(answer == 0) return -1;
        return (long)Math.pow(answer,2);
    }
}