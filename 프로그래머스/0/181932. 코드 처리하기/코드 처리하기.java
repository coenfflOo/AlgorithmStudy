class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int i = 0; i<code.length(); i++){
            char c = code.charAt(i);
            if(c == '1') {
                mode = mode == 1? 0:1;
                continue;
            }
            if(mode==1){
                if(i%2==1){
                    answer += String.valueOf(c);
                }
            } else {
                if(i%2==0){
                    answer += String.valueOf(c);
                }
            }
        }
        answer = answer.equals("") ? "EMPTY" : answer;
        return answer;
    }
}