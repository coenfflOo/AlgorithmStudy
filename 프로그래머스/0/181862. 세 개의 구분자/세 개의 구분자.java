class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("a"," ");
        myStr = myStr.replaceAll("b"," ");
        myStr = myStr.replaceAll("c"," ");
        myStr = myStr.replaceAll("\\s+"," ").trim();
        if(myStr.equals("")) return new String[]{"EMPTY"};
        return myStr.split(" ");
    }
}