class Solution {
    public int[] solution(String myString) {
        String[] str = myString.split("x");
        int len = str.length;
        if(myString.endsWith("x")) len++;
        int[] answer = new int[len];
        for(int i=0; i< str.length; i++){
            answer[i] = str[i].length();
        }
        return answer;
    }
}