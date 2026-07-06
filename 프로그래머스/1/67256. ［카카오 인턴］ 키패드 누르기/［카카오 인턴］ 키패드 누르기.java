class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] arr = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        String answer = "";
        int[] left = {3,0};
        int[] right = {3,2};
        for(int num: numbers){
            int[] n = arr[num];
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                left[0] = n[0];
                left[1] = n[1];
            } else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right[0] = n[0];
                right[1] = n[1];
            } else {
                int ll = Math.abs(left[0]-n[0])+Math.abs(left[1]-n[1]);
                int rl = Math.abs(right[0]-n[0])+Math.abs(right[1]-n[1]);
                if(ll==rl){
                    switch(hand){
                        case "right":
                            answer += "R";
                            right[0] = n[0];
                            right[1] = n[1];
                            break;
                        case "left":
                            answer += "L";
                            left[0] = n[0];
                            left[1] = n[1];
                            break;
                    }
                } else if (ll<rl){
                    answer += "L";
                    left[0] = n[0];
                    left[1] = n[1];
                } else {
                    answer += "R";
                    right[0] = n[0];
                    right[1] = n[1];
                }
            }
        }
        return answer;
    }
}