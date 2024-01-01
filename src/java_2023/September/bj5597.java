import java.util.*;
import java.io.*;
public class bj5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] student = new int[30];
        for (int i = 0; i < 28; i++) {
            int a = Integer.parseInt(br.readLine());
            student[a-1] = 1;
        }

        for (int i = 0; i < student.length; i++) {
            if (student[i] != 1)
                bw.write((i+1)+"\n");
        }
        bw.flush();
    }
}