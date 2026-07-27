class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int answer = health;
        int index = 0;
        int time = 0;
        while(index<attacks.length){
            int[] monster = attacks[index];
            if(time == monster[0]){
                answer -= monster[1];
                if(answer<=0) return -1;
                index++;
                t = bandage[0];
            } else {
                t--;
                answer = answer+x >= health? health : answer+x;
                if(t==0){
                    answer = answer+y >= health? health : answer+y;
                    t = bandage[0];
                }
            }
            time++;
        }
        return answer;
    }
}