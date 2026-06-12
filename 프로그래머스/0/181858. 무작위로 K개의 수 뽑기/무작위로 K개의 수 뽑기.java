import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer,-1);
        List<Integer> list = new ArrayList<>();
        int index=0;
        for(int a: arr){
            if(list.contains(a)) continue;
            list.add(a);
            answer[index++] = a;
            if(index>=k) break;
        }
        return answer;
    }
}