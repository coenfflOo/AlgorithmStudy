import java.util.*;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length<arr2.length) return -1;
        else if (arr1.length>arr2.length) return 1;
        int one = Arrays.stream(arr1).sum();
        int two = Arrays.stream(arr2).sum();
        if(one<two) return -1;
        else if (one>two) return 1;
        return 0;
    }
}