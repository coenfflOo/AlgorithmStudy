class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int left = 0;
        int right = pat.length();
        while(left<right){
            if(myString.substring(left,right).contains(pat)){
                answer++;
                left = right-pat.length()+1;
                right = left+pat.length();
            } else {
                right++;
            }
            if(right>myString.length()) break;
        }
        return answer;
    }
}