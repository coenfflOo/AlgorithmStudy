import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
		for(int i : arr) {
			list.add(i);
		}
        for(int i = 0; i<query.length; i++){
            if(i%2==0){
                int size = list.size()-query[i]-1;
                while(size-->0){
                    list.remove(list.size()-1);
                }
            } else {
                int size = query[i];
                while(size-->0){
                    list.remove(0);
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}