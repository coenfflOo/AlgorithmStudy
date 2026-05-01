import java.util.*;

class Solution {
    static int index;
    static List<Integer> list;
    static int[] number = {0,5};
    public int[] solution(int l, int r) {
        list = new ArrayList<>();
        perm(l,r,0);
        if(list.size()==0) return new int[]{-1};
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void perm(int l, int r, int num){
        if(num!=0 && num>=l && num<=r){
            if(!list.contains(num)) list.add(num);
        } else if(num>r) return;
        
        for(int i=0; i<2; i++){
            if(num==0){
                perm(l,r,5);
            } else {
                perm(l,r,num*10+number[i]);
            }
        }
    }
}