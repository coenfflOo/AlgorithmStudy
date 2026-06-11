class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i=0; i<myString.length(); i++){
            if(myString.charAt(i) == 'a' || myString.charAt(i) == 'A'){
                answer += String.valueOf(myString.charAt(i)).toUpperCase();
            } else {
                answer += String.valueOf(myString.charAt(i)).toLowerCase();
            }
        }
        return answer;
    }
}