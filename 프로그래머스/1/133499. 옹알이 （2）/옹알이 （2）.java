class Solution {
    public int solution(String[] babbling) {
        String[] possible = {"aya", "ye", "woo", "ma"};
        String[] change = {"0","1","2","3"};
        int answer = 0;
        here: for(String b : babbling){
            for(int i=0; i<4; i++){
                b=b.replaceAll(possible[i],change[i]);
            }
            if(b.charAt(0)-'0'>4) continue here;
            if(b.length()==1) {
                answer++;
                continue here;
            }
            for(int i=1; i<b.length();i++){
                if(b.charAt(i)==b.charAt(i-1)) continue here;
                if(b.charAt(i)-'0'> 4) continue here;
            }
            answer++;
        }
        return answer;
    }
}