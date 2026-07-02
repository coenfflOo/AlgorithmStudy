class Solution {
    public int solution(int n) {
        int[] number = new int[n+1];
        number[2] = 1;
        for(int i=3;i<=n;i++){
            int cnt = 0;
            if(i%2==0){
                number[i] = number[i-1];
                continue;
            }
            boolean flag = true;
            for(int j=3; j<=Math.sqrt(i); j++){
                if(i%j==0) {
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