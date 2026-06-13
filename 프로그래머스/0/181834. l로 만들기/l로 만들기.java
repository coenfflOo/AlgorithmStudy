class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i=0; i<myString.length();i++){
            char c = myString.charAt(i);
            if(c-'l'<0){
                answer+="l";
            } else {
                answer += String.valueOf(c);
            }
        }
        return answer;
    }
}