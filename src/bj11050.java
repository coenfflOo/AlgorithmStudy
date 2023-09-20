import java.util.*;
import java.io.*;
//public class bj11050 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        bw.write(String.valueOf(bino_factorial(N,K)));
//        bw.flush();
//    }
//
//    public static int factorial(int n) {
//        if (n <= 1)
//            return n;
//        else
//            return factorial(n-1) * n;
//    }
//
//    private static int bino_factorial(int n, int k){
//        if (n <= k)
//            return 0;
//        return factorial(n) / (factorial(k) * factorial(n - k));
//    }
//}
// java.lang.ArithmeticException: / by zero 오류가 발생하는 이유는
// 분모 또는 분자 중 하나의 팩토리얼 값을 0으로 나누려고 시도하기 때문
// 수학적으로 이항 계수(조합)는 다음과 같이 정의됩니다.
// C(n, r) = n! / (r! * (n - r)!)
// factorial 함수가 0 이상의 정수에 대해서도 잘 동작하도록 해야 함
public class bj11050 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        System.out.print(binomial(N, K));
    }

    public static int binomial(int N, int K) {
        return fact(N) / (fact(K) * fact(N - K));
    }

    public static int fact(int n) {
        if (n <= 1)
            return 1;
        else
            return fact(n - 1) * n;
    }
}
// 이항 계수 계산 조건: 두 코드는 이항 계수를 계산하는 방법에 차이가 있습니다.
// 첫 번째 코드에서는 n이 k보다 작거나 같을 때 계산을 중단하고 0을 반환하며,
// 두 번째 코드에서는 그런 조건을 처리하지 않습니다.
// 첫 번째 코드에서는 n이 k보다 작거나 같을 때 0을 반환하므로 이러한 조건에서 테스트가 실패할 수 있습니다.