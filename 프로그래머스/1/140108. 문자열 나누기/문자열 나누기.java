class Solution {
    public int solution(String s) {
        int answer = 0;
        char f = ' ';
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(f==' ') f = s.charAt(i);
            if(s.charAt(i)==f) cnt++;
            else {
                cnt--;
                if(cnt==0){
                    answer++;
                    f = ' ';
                }
            }
        }
        if(f!=' ') answer++;
        return answer;
    }
}