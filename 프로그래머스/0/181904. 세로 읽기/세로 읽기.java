class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for(int i=0; i<my_string.length()/m;i++){
            if(i*m+c-1>=my_string.length()) continue;
            answer+=String.valueOf(my_string.charAt(i*m+c-1));
        }
        return answer;
    }
}
// ihrh
// bakr
// fpnd
// oplj
// hygc