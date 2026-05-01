class Solution {
    public int solution(int[] num_list) {
        String p="";
        String o="";
        for(int n: num_list){
            if(n%2==0) p+=String.valueOf(n);
            else o+=String.valueOf(n);
        }
        return Integer.parseInt(p)+Integer.parseInt(o);
    }
}