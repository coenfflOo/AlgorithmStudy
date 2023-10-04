import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        if (N == 1){
            System.out.println((int)Math.pow(arr[0],2));
        } else {
            System.out.println(findN(arr));
        }
    }

    private static int findN(int[] arr){
        int index = arr.length/2;
        int n;
        if (arr.length%2==0)
            n = arr[index - 1] * arr[index];
        else
            n=arr[index - 1] * arr[index+1];
        return n;
    }
}