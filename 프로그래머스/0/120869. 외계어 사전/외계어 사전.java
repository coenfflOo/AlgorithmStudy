import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String d:dic){
            int[] arr = new int[26];
            for(int i=0;i<spell.length; i++){
                arr[spell[i].charAt(0)-'a']++;
            }
            boolean flag = true;
            out: for(int i=0; i<d.length(); i++){
                int index = d.charAt(i)-'a';
                if(arr[index]<1) {
                    flag = false;
                    break out;
                }
                arr[index]--;
            }
            for(int i=0;i<26; i++){
                if(arr[i] != 0) flag = false;
            }
            if(flag) return 1;
        }
        return 2;
    }
}