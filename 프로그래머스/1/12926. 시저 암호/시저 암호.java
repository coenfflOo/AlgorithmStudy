class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' ') {
                answer+=" ";
            } else {
                int index = s.charAt(i)+n;
                if(index>122){
                    answer += String.valueOf((char)(index-26));
                } else if(s.charAt(i)<=90&&index>90){
                    answer += String.valueOf((char)(index-26));
                } else {
                    answer += String.valueOf((char)(index));
                }
            }
            
        }
        return answer;
    }
}