import java.util.*;
class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int remove = 0;
        while(!s.equals("1")){
            cnt++;
            int r = 0;
            for(int i=0; i<s.length();i++){
                if(s.charAt(i)=='0') r++;
            }
            remove += r;
            s = Integer.toBinaryString(s.length()-r);
        }
        return new int[]{cnt, remove};
    }
}