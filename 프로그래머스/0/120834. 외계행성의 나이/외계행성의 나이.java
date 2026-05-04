class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        while(age>0){
            char c = (char)('a'+(age%10));
            sb = new StringBuilder(String.valueOf(c)).append(sb);
            age/=10;
        }
        return sb.toString();
    }
}