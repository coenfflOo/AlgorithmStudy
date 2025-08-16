package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(list.size()-Integer.parseInt(st.nextToken()),i+1);
        }
        for(int i=0; i<n; i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
