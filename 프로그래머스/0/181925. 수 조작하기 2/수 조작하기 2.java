class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int cur = numLog[0];
        for(int i=1; i<numLog.length; i++){
            switch(cur-numLog[i]){
                case 1:
                    answer += "s";
                    break;
                case -1:
                    answer += "w";
                    break;
                case 10:
                    answer += "a";
                    break;
                case -10:
                    answer += "d";
                    break;
            }
            cur=numLog[i];
        }
        return answer;
    }
}