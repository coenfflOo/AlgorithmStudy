import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = Arrays.copyOf(arr, arr.length);
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            for(int j=q[0]; j<=q[1]; j++){
                if(j%q[2]==0){
                    answer[j]++;
                }
            }
        }
        return answer;
    }
}