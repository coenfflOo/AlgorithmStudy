import java.util.*;
class Solution {
    public int solution(String A, String B) {
        StringBuilder sb = new StringBuilder(B);
        int index = 0;
        while(index<B.length()&&!A.equals(sb.toString())){
            sb.append(B.charAt(index++));
            sb.delete(0,1);
        }
        if(A.equals(sb.toString())) return index;
        return -1;
    }
}