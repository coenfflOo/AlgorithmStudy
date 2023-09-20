import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class bj15829 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int L = Integer.parseInt(br.readLine());
//        String s = br.readLine();
//        int[] num = alphabet(s);
//        int sum = 0;
//        for (int i = 0; i < L; i++) {
//            sum += num[i]*Math.pow(31,i);
//        }
//        sum %= 1234567891;
//        bw.write(String.valueOf(sum));
//        bw.flush();
//    }
//
//    private static int[] alphabet(String s){
//        int[] arr = new int[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            arr[i] = s.charAt(i)-96;
//        }
//        return arr;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();
        BigInteger result = new BigInteger("0");

        for(int i = 0; i < L; i++) {
            // result에 현자 자릿수의 알파벳에서 정수 1~26중 해당 값을 더해주고
            // 그 값에 31의 i제곱한 값을 곱해주는 것이다.
            result = result.add(BigInteger.valueOf(S.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
        }
        // 출력할때는 1234567891을 나눠주자.
        bw.write(String.valueOf((result.remainder(BigInteger.valueOf(1234567891)))));
        bw.flush();
    }
    // BigInteger 클래스를 사용하여 중간 결과를 저장하며, 이 클래스는 임의 정밀도 정수를 처리하는 데 사용됩니다.
    // BigInteger를 사용하면 매우 큰 수를 처리할 수 있으며, 정수 범위에 제한을 받지 않습니다.
    // 따라서 더 큰 정수 값을 다룰 수 있으며, 정확한 결과를 얻을 수 있습니다.
    // 특히 큰 수의 경우, BigInteger를 사용하는 것이 더 안전하고 정확한 방법입니다.
}
