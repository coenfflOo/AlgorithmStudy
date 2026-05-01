class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            int min = Integer.MAX_VALUE;
            for(int j=q[0]; j<= q[1]; j++){
                if(arr[j]>q[2]){
                    min = Math.min(min,arr[j]);
                }
            }
            if(min == Integer.MAX_VALUE) min = -1;
            answer[i] = min;
        }
        return answer;
    }
}