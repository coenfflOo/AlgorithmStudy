class Solution {
    static int j = 5;
    static int b = 3;
    static int o = 1;
    public int solution(int hp) {
        int answer = hp/j;
        hp%=j;
        answer+=hp/b;
        hp%=b;
        answer+=hp;
        return answer;
    }
}