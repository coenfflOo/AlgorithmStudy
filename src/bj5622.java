import java.util.*;
import java.io.*;
public class bj5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String secret = br.readLine();
        String number = changeNumber(secret);
        String result = String.valueOf(changeTime(number));
        bw.write(result);
        bw.flush();
    }

    public static String changeNumber(String s) {
        String number = "";

        String[] alp = {" ","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i,(i+1));
            for (int j = 0; j < alp.length; j++) {
                if (alp[j].contains(c)){
                    number += String.valueOf(j+1);}
            }
        }

        return number;
    }

    public static int changeTime(String number) {
        int sum=0;

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (i+2);
        }

        String[] num = number.split("");
        for (int i = 0; i < num.length; i++) {
            int n = Integer.parseInt(num[i])-1;
            sum+=arr[n];
        }

        return sum;
    }
}
