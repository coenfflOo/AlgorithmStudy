import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<delete_list.length;i++){
            list2.add(delete_list[i]);
        }
        for(int i=0;i<arr.length;i++){
            if(!list2.contains(arr[i])) list.add(arr[i]);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}