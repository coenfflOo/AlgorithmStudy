class Solution {
    public int solution(String s) {
        int answer = 1;
        if(s.charAt(0)=='-'){
            s = s.substring(1);
            answer*=-1;
        }
        return answer*Integer.parseInt(s);
    }
}