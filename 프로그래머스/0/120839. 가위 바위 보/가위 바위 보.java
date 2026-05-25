class Solution {
    public String solution(String rsp) {
        String answer = "";
        String[] input = rsp.split("");
        for(String i : input){
            switch(i){
                case "2":
                    answer+="0";
                    break;
                case "0":
                    answer+="5";
                    break;
                case "5":
                    answer+="2";
                    break;
            }
        }
        return answer;
    }
}