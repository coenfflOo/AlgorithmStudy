class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i] = "";
            String one = Integer.toBinaryString(arr1[i]);
            String two = Integer.toBinaryString(arr2[i]);
            if(one.length()!=n){
                String plus = "0".repeat(n-one.length());
                one = plus+one;
            }
            if(two.length()!=n){
                String plus = "0".repeat(n-two.length());
                two = plus+two;
            }
            for(int j=0; j<n; j++){
                if(one.charAt(j)=='1'||two.charAt(j)=='1')
                    answer[i]+="#";
                else answer[i]+=" ";
            }
        }
        return answer;
    }
}