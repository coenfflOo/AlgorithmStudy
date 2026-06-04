import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int mul = 0;
        for(int i=0; i<num_list.length; i++){
            if(i%2==0){
                odd+=num_list[i];
            } else mul+=num_list[i];
        }
        return Math.max(odd,mul);
    }
}