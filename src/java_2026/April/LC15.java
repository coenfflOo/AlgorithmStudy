package java_2026.April;

public class LC15 {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(2147483644));
    }

    public static int reverseBits(int n) {

        int ans = 0; // 뒤집힌 비트를 저장할 변수

        // 32비트 정수이므로 정확히 32번 반복
        for (int i = 0; i < 32; i++) {

            // 결과를 왼쪽으로 한 칸 이동 → 새로운 비트를 넣을 자리 확보
            ans <<= 1;

            // n의 가장 오른쪽 비트 추출 (0 또는 1)
            // 그 값을 ans의 마지막 자리에 붙임
            ans |= (n & 1);

            // n을 오른쪽으로 이동 → 다음 비트를 처리하기 위해
            n = n >> 1;
        }

        // 최종적으로 뒤집힌 비트 값 반환
        return ans;
    }
}