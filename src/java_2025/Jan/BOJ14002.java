package java_2025.Jan;
import java.util.*;
import java.io.*;
public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpA = new int[n];
        int[] dpC = new int[n];
        dpA[0] = -1;
        dpC[0] = 1;
        for (int i = 1; i < n; i++) {
            dpC[i] = 1;
            dpA[i] = i;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]){
                    if(dpC[i]<dpC[j]+1){
                        dpC[i] = dpC[j]+1;
                        dpA[i] = j;
                    }
                }
            }
        }

        int index = 0;
        int count = dpC[0];
        for (int i = 1; i < n; i++) {
            if (count<dpC[i]){
                index = i;
                count = dpC[i];
            }
        }
        System.out.println(count);
        Stack stack = new Stack();
        while (index>-1){
            stack.push(arr[index]);
            if (index == dpA[index])
                break;
            index = dpA[index];
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
