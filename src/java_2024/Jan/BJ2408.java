package java_2024.Jan;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ2408 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] expression = new String[2 * N-1];
        for (int i = 0; i < 2 * N-1; i++) {
            expression[i] = scanner.next();
        }
        System.out.println(calculateExpression(expression));
    }

    public static BigDecimal calculateExpression(String[] expression) {
        List<BigDecimal> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        // 숫자와 연산자 분리
        for (int i = 0; i < expression.length; i++) {
            if (i % 2 == 0) {
                numbers.add(new BigDecimal(expression[i]));
            } else {
                operators.add(expression[i].charAt(0));
            }
        }

        // 곱셈과 나눗셈 먼저 처리
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '*' || operators.get(i) == '/') {
                BigDecimal result = operators.get(i) == '*' ? numbers.get(i).multiply(numbers.get(i + 1))
                        : numbers.get(i).divide(numbers.get(i + 1), 0, RoundingMode.FLOOR);
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

        // 덧셈과 뺄셈 처리
        BigDecimal result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                result = result.add(numbers.get(i + 1));
            } else if (operators.get(i) == '-') {
                result = result.subtract(numbers.get(i + 1));
            }
        }

        return result;
    }
}