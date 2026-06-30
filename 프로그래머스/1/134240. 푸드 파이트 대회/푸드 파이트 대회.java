class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for(int i=1; i<food.length; i++){
            int cnt = food[i]/2;
            if(cnt<=0) continue;
            answer.insert(index,String.valueOf(i).repeat(cnt*2));
            index += cnt;
        }
        answer.insert(index,String.valueOf(0));
        return answer.toString();
    }
}