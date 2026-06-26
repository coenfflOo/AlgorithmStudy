import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length;j++){
                int sum = numbers[i]+numbers[j];
                if(nums.contains(sum)) continue;
                nums.add(sum);
            }
        }
        int[] answer = new int[nums.size()];
        Collections.sort(nums);
        for(int i=0; i<nums.size();i++){
            answer[i] = nums.get(i);
        }
        return answer;
    }
}