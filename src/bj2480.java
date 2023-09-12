import java.io.*;
import java.util.*;

public class bj2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = {f,s,t};
        Arrays.sort(arr);
        int count  = 0;
        int result = 0;

        for (int i = 1; i < 3; i++) {
            if (arr[0] == arr[i]) {
                count++;
            }
        }

        if (count == 0){
            if (arr[1] == arr[2])
                result = 1000+arr[1]*100;
            else
                result = arr[2]*100;
        }
        else {
            if (count == 1){
                result = 1000+arr[0]*100;
            }
            else if (count == 2){
                result = 10000 + arr[0]*1000;
            }
        }

        System.out.println(result);
    }
}
// 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
//같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
//모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.