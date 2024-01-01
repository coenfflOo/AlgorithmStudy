package java_2023.September;
import java.io.*;

public class bj13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = findOpenWindows(N);
        System.out.println(result);
    }

    private static long findOpenWindows(long num){

//        long openWindows = 0;
//        for (long i = 1; i <= Math.sqrt(num); i++) {
//            long sqrt = (long) Math.sqrt(i);
//            if (sqrt * sqrt == i) {
//                openWindows++;
//            }
//        }

        // 완전제곱수의 개수는 sqrt(num)의 정수 부분과 같습니다.
        long sqrtNum = (long) Math.sqrt(num);
        return sqrtNum;
    }
}

//1111111111
//1010101010
//1000111000
//1001111100
//1001011101
//1001001101
//1001000101
//1001000001
//1001000011
//1001000010
//1 4 9