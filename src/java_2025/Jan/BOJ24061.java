package java_2025.Jan;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24061 {
    private static String str;
    private static boolean flag;
    private static final String yes = "AKARAKA";
    private static final String no = "IPSELENTI";
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int len = str.length();
        palinDrome(0, len-1);
        for (int i = len / 2; i > 0 && flag; i /= 2) {
            palinDrome(0, i - 1);
        }
        if(flag)
            System.out.println(yes);
        else
            System.out.println(no);
    }

    private static void palinDrome(int left, int right){
        if(left>=right){
            flag = true;
            return;
        }

        if(str.charAt(left) == str.charAt(right)){
            palinDrome(left+1, right-1);
        } else {
            flag = false;
        }
    }
}
