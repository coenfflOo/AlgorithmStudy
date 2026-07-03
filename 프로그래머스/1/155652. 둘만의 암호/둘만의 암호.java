class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] unavailable = new boolean[26];
        for(int i=0; i<skip.length(); i++){
            unavailable[skip.charAt(i)-'a'] = true;
        }
        String answer = "";
        for(int i=0; i<s.length(); i++){
            int cur = s.charAt(i)-'a';
            for(int j=0; j<index; j++){
                cur++;
                if(cur>=26) cur = 0;
                while(unavailable[cur]){
                    cur++;
                    if(cur>=26) cur = 0;
                }
            }
            answer += String.valueOf((char)('a'+cur));
        }
        return answer;
    }
}