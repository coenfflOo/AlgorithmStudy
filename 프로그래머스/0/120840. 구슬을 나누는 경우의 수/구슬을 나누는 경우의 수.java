class Solution {
    public int solution(int balls, int share) {
        double ja = 1;
        for(int i=share+1; i<= balls; i++) ja*=i;
        double nm = 1;
        for(int i=2; i<= balls-share; i++) nm*=i;
        int answer = balls==share? 1: (int)(ja/nm);
        return answer;
    }
}