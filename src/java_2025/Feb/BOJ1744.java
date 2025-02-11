package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        boolean isZero = false;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                plus.add(arr[i]);
            } else if(arr[i]<0){
                minus.add(arr[i]);
            } else {
                isZero = true;
            }
        }

        int answer = 0;
        if (isZero&& minus.size()%2==1){
            minus.remove(minus.size()-1);
        }
        while(minus.size()>1){
            answer += (minus.get(0)*minus.get(1));
            minus.remove(0);
            minus.remove(0);
        }
        if (!minus.isEmpty()){
            answer += minus.get(0);
        }

        while (plus.size()>1){
            if(plus.get(plus.size()-1)* plus.get(plus.size()-2)<plus.get(plus.size()-1)+ plus.get(plus.size()-2)) {
                answer += plus.get(plus.size() - 1);
                plus.remove(plus.size()-1);
                continue;
            }
            answer += (plus.get(plus.size()-1)* plus.get(plus.size()-2));
            plus.remove(plus.size()-1);
            plus.remove(plus.size()-1);
        }
        if (!plus.isEmpty()){
            answer += plus.get(0);
        }
        System.out.println(answer);
    }
}
