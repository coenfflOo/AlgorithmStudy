class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        int index = -1;
        for(int i=0; i<answer.length; i++){
            if(i%k!=0){
                answer[i] = answer[i-1];
            } else {
                index++;
                answer[i] = "";
                for(int j=0; j<picture[index].length()*k; j++){
                    answer[i] += String.valueOf(picture[index].charAt(j/k));
                }
            }
        }
        return answer;
    }
}