import java.io.*;
import java.util.Objects;

public class bj1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String n = br.readLine();
            if (Objects.equals(n, "0"))
                break;

            String answer = "yes";
            int j = n.length()-1;
            for (int i = 0; i < n.length()/2; i++) {
                if (n.charAt(i) != n.charAt(j--))
                    answer = "no";
            }
            // 한자리 수도 팰린드롬 수다......
            if (n.length() == 1)
                answer = "yes";

            bw.write(answer+"\n");
            bw.flush();
        }
    }
}
