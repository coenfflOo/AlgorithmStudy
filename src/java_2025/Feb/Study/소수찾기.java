package java_2025.Feb.Study;

import java.util.*;

class 소수찾기 {
    private static int n;
    private static int[] number;
    private static boolean[] impossible;
    private static HashSet<Integer> set;
    private static boolean[] select;
    public int solution(String numbers) {
        n = numbers.length();
        number = new int[n];
        for(int i=0; i<n;i++){
            char c = numbers.charAt(i);
            number[i] = c-'0';
        }

        impossible = new boolean[10000000];
        for(int i=2;i<10000000;i++){
            if(impossible[i])
                continue;

            for(int j=2*i;j<10000000;j+=i){
                impossible[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        set = new HashSet<>();
        select = new boolean[n];
        comb(0,sb);

        int answer = 0;
        for(int num:set){
            // System.out.print(num+" ");
            if(!impossible[num]&&num!=1){
                answer++;
            }
        }
        return answer;
    }

    private static void comb(int idx, StringBuilder sb){
        if(sb.length()>0){
            String str = sb.toString();
            if(!str.startsWith("0"))
                set.add(Integer.parseInt(str));
        }

        if(idx==n){
            return;
        }

        for(int i=0;i<n;i++){
            if(select[i])
                continue;
            select[i] = true;
            sb.append(number[i]);
            comb(idx+1, sb);
            select[i] = false;
            sb.delete(sb.length()-1,sb.length());
        }
    }
}