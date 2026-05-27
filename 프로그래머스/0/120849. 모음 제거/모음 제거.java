class Solution {
    public String solution(String my_string) {
        String[] mo = {"a","e","i","o","u"};
        for(String m: mo){
            my_string = my_string.replaceAll(m,"");
        }
        return my_string;
    }
}