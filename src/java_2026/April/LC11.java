package java_2026.April;

public class LC11 {
    public static void main(String[] args) {
        System.out.println(getSum(1,2));
        System.out.println(getSum(1,-2));
        System.out.println(getSum(2,3));
    }

    public static int getSum(int a, int b) {

        // b는 "자리올림(carry)" 역할
        // carry가 없을 때까지 반복
        while (b != 0) {

            // AND: 두 비트가 모두 1인 자리 → carry 발생 위치
            // << 1: 자리올림이므로 한 칸 왼쪽으로 이동
            int carry = (a & b) << 1;

            // XOR: 자리올림 없이 더한 결과
            a = a ^ b;

            // 다음 반복에서 carry를 더해야 하므로 b에 저장
            b = carry;
        }

        // 최종적으로 a에 합이 저장됨
        return a;
    }
}