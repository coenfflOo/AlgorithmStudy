class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int one = 0;
        int two = 0;
        for(int i= 0; i<goal.length; i++){
            boolean possible = false;
            if(one<cards1.length){
                if(cards1[one].equals(goal[i])){
                    possible = true;
                    one++;
                }
            }
            if(!possible && two<cards2.length){
                if(cards2[two].equals(goal[i])){
                    possible = true;
                    two++;
                }
            }
            if(!possible) return "No";
        }
        return "Yes";
    }
}