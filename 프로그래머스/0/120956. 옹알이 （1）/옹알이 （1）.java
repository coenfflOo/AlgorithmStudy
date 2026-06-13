class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = new String[]{"aya", "ye", "woo", "ma"};
        for(String b: babbling){
            for(String s:str){
                b=b.replace(s," ");
            }
            if(b.trim().equals("")) answer++;
        }
        return answer;
    }
}