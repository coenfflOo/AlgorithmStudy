class Solution {
    public String[] solution(String my_string) {
        String[] str = my_string.replaceAll("\\s+", " ").trim().split(" ");
        String[] answer = new String[str.length];
        for(int i=0; i< str.length; i++){
            answer[i] = str[i].trim();
        }
        return answer;
    }
}