class Solution {
    public String solution(String myString, String pat) {
        int index = -1;
        for(int i=myString.length()-pat.length(); i>=0; i--){
            if(myString.substring(i).contains(pat)){
                index = i+pat.length();
                break;
            }
        }
        return myString.substring(0,index);
    }
}