class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        int answer = myString.contains(pat)? 1:0;
        return answer;
    }
}