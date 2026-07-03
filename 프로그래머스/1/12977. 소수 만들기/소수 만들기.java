class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int num = nums[i]+nums[j]+nums[k];
                    if(num%2==0) continue;
                    boolean flag = true;
                    for(int z=3; z<=Math.sqrt(num);z++){
                        if(num%z==0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}