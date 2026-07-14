class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int index = 0;
        long pn = Long.parseLong(p);
        while(index+p.length()<=t.length()){
            String s = t.substring(index,index+p.length());
            if(Long.parseLong(s)<=pn) {
                answer++;
            }
            index++;
        }
        return answer;
    }
}