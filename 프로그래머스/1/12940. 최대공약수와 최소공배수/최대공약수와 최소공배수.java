import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.min(n,m),Math.max(n,m));
        answer[1] = n / answer[0] * m;
        return answer;
    }
    
    private int gcd(int n, int m){
        if(m==0) return n;
        return gcd(m,n%m);
    }
}