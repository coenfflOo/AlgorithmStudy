class Solution {
    public String solution(int a, int b) {
        String[] yoil = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        for(int i=1;i<a;i++){
            sum+=month[i-1];
        }
        sum+=b;
        sum %= 7;
        String answer = yoil[sum];
        return answer;
    }
}