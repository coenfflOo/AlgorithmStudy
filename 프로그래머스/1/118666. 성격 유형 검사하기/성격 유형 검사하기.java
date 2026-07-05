class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = new int[26];
        for(int i=0; i<survey.length; i++){
            String s = survey[i];
            if(choices[i]<4){
                score[s.charAt(0)-'A']+=(4-choices[i]);
            } else if(choices[i]>4){
                score[s.charAt(1)-'A']+=(choices[i]-4);
            }
        }
        String[] str = {"RT","CF","JM","AN"};
        String answer = "";
        for(int i=0; i<4; i++){
            int index = score[str[i].charAt(0)-'A']>=score[str[i].charAt(1)-'A']?str[i].charAt(0)-'A':str[i].charAt(1)-'A';
            answer+=String.valueOf((char)(index+'A'));
        }
        return answer;
    }
}