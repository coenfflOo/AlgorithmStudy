class Solution {
    public String solution(String my_string, int[] index_list) {
        String[] str = my_string.split("");
        String answer = "";
        for(int i: index_list){
            answer += str[i];
        }
        return answer;
    }
}