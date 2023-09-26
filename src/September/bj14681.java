import java.util.*;
import java.io.*;
public class bj14681 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        if (A > 0 && B > 0)
            System.out.println("1");
        else if (A < 0 && B > 0)
            System.out.println("2");
        else if (A < 0 && B < 0)
            System.out.println("3");
        else if (A > 0 && B < 0)
            System.out.println("4");
    }
}