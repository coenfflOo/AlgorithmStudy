class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] uncolor = new boolean[n+1];
        for(int i=0; i<section.length;i++){
            uncolor[section[i]] = true;
        }
        int index = section[0];
        while(index<=n){
            // System.out.print(index);
            answer++;
            index += m;
            // System.out.println(" "+index);
            while(index<=n&&!uncolor[index]){
                index++;
            }
        }
        return answer;
    }
}