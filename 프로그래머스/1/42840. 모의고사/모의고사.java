class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] collect = new int[3];
        int max=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i]==one[i%5]) collect[0]++;
            if(answers[i]==two[i%8]) collect[1]++;
            if(answers[i]==three[i%10]) collect[2]++;
            max = Math.max(collect[0],Math.max(collect[1],collect[2]));
        }
        int len = 0;
        for(int i=0; i<3; i++) {
            if(max==collect[i]) len++;
        }
        int[] answer = new int[len];
        int index = 0;
        for(int i=0; i<3; i++) {
            if(max==collect[i]) answer[index++]=i+1;
        }
        return answer;
    }
}