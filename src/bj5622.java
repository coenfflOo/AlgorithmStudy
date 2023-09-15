import java.util.*;
import java.io.*;
public class bj5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String secret = br.readLine();
        int number = Integer.parseInt(changeNumber(secret));

    }

    public static String changeNumber(String s) {
        String number = "";

        String[] alp = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i,(i+1));
            for (int j = 0; j < alp.length; j++) {
                if (alp[j].contains(c))
                    number += String.valueOf(j);
            }
        }

        return number;
    }
}
