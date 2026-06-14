import java.util.*;
class Solution {
    public int solution(int[] common) {
        int diff = common[1]-common[0];
        int diff2 = common[2]-common[1];
        if(diff == diff2) return common[common.length-1]+diff;
        int mul = diff2/diff;
        return common[common.length-1]*mul;
    }
}