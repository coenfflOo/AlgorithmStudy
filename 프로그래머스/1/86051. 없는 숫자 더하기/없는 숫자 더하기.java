class Solution {
    public int solution(int[] numbers) {
        boolean[] nums = new boolean[10];
        for(int number : numbers){
            nums[number] = true;
        }
        int answer = 0;
        for(int i=0;i<10;i++){
            if(!nums[i]) answer+=i;
        }
        return answer;
    }
}