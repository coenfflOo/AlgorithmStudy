package java_2026.April;

public class LC12 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n) {
        int count = 0;

        // n이 0이 될 때까지 반복
        while (n != 0) {

            // n & (n - 1):
            // 가장 오른쪽에 있는 1 비트를 하나 제거
            n = n & (n - 1);

            // 1을 하나 제거했으므로 count 증가
            count++;
        }

        // 총 제거한 횟수 = 1의 개수
        return count;
    }
}