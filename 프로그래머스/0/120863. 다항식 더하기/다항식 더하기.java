class Solution {
    public String solution(String polynomial) {
        String[] str = polynomial.split(" \\+ ");
        int num = 0;
        int coef = 0;
        for(String s:str){
            if(s.contains("x")){
                if(s.length()==1) coef++;
                else coef += Integer.parseInt(s.substring(0,s.length()-1));
            } else {
                num += Integer.parseInt(s);
            }
        }
        String answer = "";
        boolean flag = false;
        if(coef!=0&&coef!=1) {
            answer += String.valueOf(coef)+"x";
            flag = true;
        } else if(coef==1) {
            answer += "x";
            flag = true;
        }
        if(flag&&num!=0) answer += " + ";
        if(num!=0) answer += String.valueOf(num);
        return answer;
    }
}