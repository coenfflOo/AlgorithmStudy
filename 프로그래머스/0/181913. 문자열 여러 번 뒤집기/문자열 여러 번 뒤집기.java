class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int[] q: queries){
            String str = new StringBuilder(sb.substring(q[0],q[1]+1)).reverse().toString();
            sb = sb.replace(q[0],q[1]+1, str);
        }
        return sb.toString();
    }
}