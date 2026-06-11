class Solution {
    public int solution(String myString, String pat) {
        String p = "";
        for(int i=0; i<pat.length(); i++){
            char c = pat.charAt(i);
            if(c=='A') p+="B";
            else p+="A";
        }
        return myString.contains(p)?1:0;
    }
}