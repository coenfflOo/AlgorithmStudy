class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer;
        int start = 0;
        int end = 0;
        switch(n){
            case 1:
                start = 0;
                end = slicer[1];
                break;
            case 2:
                start = slicer[0];
                end = num_list.length-1;
                break;
            case 3:
                start = slicer[0];
                end = slicer[1];
                break;
            case 4:
                start = slicer[0];
                end = slicer[1];
                break;
        }
        if(n==4){
            answer = new int[(end-start)/slicer[2]+1];
            int index = 0;
            for(int i=start; i<=end; i+=slicer[2]){
                answer[index++] = num_list[i];
            }
        } else {
            answer = new int[end-start+1];
            for(int i=start; i<=end; i++){
                answer[i-start] = num_list[i];
            }
        }
        return answer;
    }
}