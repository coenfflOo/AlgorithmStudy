class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                if(j%i==0) arr[j]++;
            }
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(arr[i]>=3) answer++;
        }
        return answer;
    }
}