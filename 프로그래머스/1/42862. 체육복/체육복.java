import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students,1);
        for(int l : lost){
            students[l-1]--;
        }
        for(int r : reserve){
            students[r-1]++;
        }
        System.out.println(Arrays.toString(students));
        for(int i=0; i<n; i++){
            if(students[i]==2){
                if(i==0&&students[i+1]==0){
                    students[i+1] = 1;
                } else if(i==n-1&&students[i-1]==0){
                    students[i-1] = 1;
                } else if(i>0&&i<n-1){
                    if(students[i-1]==0){
                        students[i-1] = 1;
                    } else if(students[i+1]==0){
                        students[i+1] = 1;
                    }
                }
                students[i] = 1;
            }
        }
        int answer = 0;
        for(int s : students){
            if(s>=1) answer++;
        }
        return answer;
    }
}