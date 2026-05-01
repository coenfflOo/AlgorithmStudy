class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        for(int n: num_list){
            sum += n;
            mul *= n;
        }
        if(Math.pow(sum,2)<mul) return 0;
        return 1;
    }
}