import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int start = 0;
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i)=='*'){
                int f = list.get(list.size()-1)*2;
                list.remove(list.size()-1);
                if(list.size()>0){
                    int s = list.get(list.size()-1)*2;
                    list.remove(list.size()-1);
                    list.add(s);
                }
                list.add(f);
            } else if(dartResult.charAt(i)=='#'){
                int num = list.get(list.size()-1)*(-1);
                list.remove(list.size()-1);
                list.add(num);
            } else {
                while(!(dartResult.charAt(i)=='S'||dartResult.charAt(i)=='D'||dartResult.charAt(i)=='T')){
                    i++;
                }
                int score = cal(Integer.parseInt(dartResult.substring(start,i)),dartResult.charAt(i));
                list.add(score);
            }
            start = i+1;
        }
        for(int i=0; i<list.size();i++) {
            answer+=list.get(i);
        }
        return answer;
    }
    
    private int cal(int n, char s){
        switch(s){
            case 'S':
                return (int)Math.pow(n,1);
            case 'D':
                return (int)Math.pow(n,2);
            case 'T':
                return (int)Math.pow(n,3);
        }
        return 0;
    }
}