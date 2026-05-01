class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int num = a;
        for(boolean f: included){
            if(f){
                answer += num;
            }
            num += d;
        }
        return answer;
    }
}