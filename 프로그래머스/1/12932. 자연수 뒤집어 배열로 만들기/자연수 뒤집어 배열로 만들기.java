class Solution {
    public int[] solution(long n) {
        int len = String.valueOf(n).length();
        String[] str = String.valueOf(n).split("");
        int[] answer = new int[len];
        for(int i=0; i<len; i++){
            answer[i] = Integer.parseInt(str[len-i-1]);
        }
        return answer;
    }
}