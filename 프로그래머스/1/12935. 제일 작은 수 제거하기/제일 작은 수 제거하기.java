import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1};
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        int[] answer = new int[arr.length-1];
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==copy[0]){
                continue;
            } else {
                answer[index++]=arr[i];
            }
        }
        return answer;
    }
}