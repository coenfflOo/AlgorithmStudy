import java.util.*;
class Solution {
    public int solution(int a, int b) {
        b = b/gcd(b,a);
        if(b%2==0){
            while(b%2==0) b=b/2;
        }
        if(b%5==0){
            while(b%5==0) b=b/5;
        }
        int answer = b==1? 1:2;
        return answer;
    }
    
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}