package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            int b = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (st.nextToken().equals("0"))
                    b++;
            }

            switch (b){
                case 1:
                    bw.write("A");
                    break;
                case 2:
                    bw.write("B");
                    break;
                case 3:
                    bw.write("C");
                    break;
                case 4:
                    bw.write("D");
                    break;
                case 0:
                    bw.write("E");
                    break;
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
