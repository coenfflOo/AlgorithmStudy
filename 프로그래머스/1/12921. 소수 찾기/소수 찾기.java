class Solution {
    public int solution(int n) {
        int[] number = new int[n+1];
        number[2] = 1;
        for(int i=3;i<=n;i++){
            int cnt = 0;
            if(i%2==0){ // 짝수 컷
                number[i] = number[i-1];
                continue;
            }
            boolean flag = true;
            for(int j=3; j<=Math.sqrt(i); j++){ // 3부터 제곱근까지 확인
                if(i%j==0) { // 하나라도 걸리면 컷
                    number[i] = number[i-1];
                    flag = false;
                    break;
                }
            }
            if(flag) number[i] = number[i-1]+1;
        }
        return number[n];
    }
}