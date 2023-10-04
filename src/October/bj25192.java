package October;
import java.util.*;
import java.io.*;
public class bj25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> member = new HashSet<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                count += member.size();
                member.clear();
            }
            else member.add(str);
        }
        count += member.size();
        bw.write(String.valueOf(count));
        bw.close();
    }
}
