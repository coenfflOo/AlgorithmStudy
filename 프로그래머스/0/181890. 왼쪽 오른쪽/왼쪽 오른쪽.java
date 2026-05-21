class Solution {
    public String[] solution(String[] str_list) {
        int index = 0;
        boolean left = true;
        for(int i=0; i<str_list.length; i++){
            if(str_list[i].equals("l")){
                index = i;
                break;
            } else if(str_list[i].equals("r")){
                index = i;
                left = false;
                break;
            }
        }
        int len = 0;
        if(left){
            len = index;
        } else {
            len = str_list.length-index-1;
        }
        String[] answer =new String[len];
        if(left){
            for(int i=0; i<len; i++){
                answer[i] = str_list[i];
            }
        } else {
            for(int i=index+1; i<str_list.length; i++){
                answer[i-(index+1)] = str_list[i];
            }
        }
        return answer;
    }
}