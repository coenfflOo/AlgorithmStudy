class Solution {
    public int solution(String binomial) {
        String[] str = binomial.split(" ");
        int b = Integer.parseInt(str[2]);
        int answer = Integer.parseInt(str[0]);
        switch(str[1]){
            case "+":
                return answer+b;
            case "-":
                return answer-b;
            case "*":
                return answer*b;
        }
        return -1;
    }
}