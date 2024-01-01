package java_2023.September;
import java.util.*;
import java.io.*;
public class bj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                st.pop();
            else 
                st.push(num);
        }
        int sum = 0;
        if (!st.empty()){
            for (int i = 0; i < st.size(); i++) {
                sum += st.get(i);
            }
        }
        System.out.println(sum);
    }
}
