import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] num = new int[10];
        for(int i=0; i<X.length(); i++){
            num[X.charAt(i)-'0']++;
        }
        int[] arr = new int[10];
        for(int i=0; i<Y.length(); i++){
            if(num[Y.charAt(i)-'0']>0){
                num[Y.charAt(i)-'0']--;
                arr[Y.charAt(i)-'0']++;
            }
        }
        String answer = "";
        for(int i=9;i>=0;i--){
            if(arr[i]>0){
                if(i==0 && answer.equals("")) answer+="0";
                else answer+=String.valueOf(i).repeat(arr[i]);
            }
        }
        if(answer.equals("")) return "-1";
        return answer;
    }
}