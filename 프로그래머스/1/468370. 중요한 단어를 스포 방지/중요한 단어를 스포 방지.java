import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        String[] mstr = message.split(" ");
        StringBuilder origin = new StringBuilder(message);
        for(int[] range: spoiler_ranges){
            for(int i=range[0]; i<range[1]+1; i++){
                int end = i;
                while(end<range[1]+1&&message.charAt(end)!=' '){
                    end++;
                }
                origin.replace(i, end, "*".repeat(end-i));
                i = end;
            }
            
        }
        String[] sstr = origin.toString().split(" ");
        List<String> spo = new ArrayList<>();
        Set<String> words = new HashSet<>();
        for(int i=0; i<mstr.length; i++){
            if(sstr[i].contains("*")){
                if(!spo.contains(mstr[i])) spo.add(mstr[i]);
            } else {
                words.add(mstr[i]);
            }
        }
        Set<String> answer = new HashSet<>();
        for(String s: spo){
            if(!words.contains(s)) answer.add(s);
        }
        return answer.size();
    }
}