import java.io.IOException;
import java.util.Scanner;

public class bj1330 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        long A = Long.parseLong(st.nextToken());
//        long B = Long.parseLong(st.nextToken());
//        if (A>B)
//            System.out.println(">");
//        else if (A<B)
//            System.out.println("<");
//        else
//            System.out.println("==");
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        if (A>B)
            System.out.println(">");
        else if (A<B)
            System.out.println("<");
        else
            System.out.println("==");
    }
}
