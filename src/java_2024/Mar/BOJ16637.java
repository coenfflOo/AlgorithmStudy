package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ16637 {
    static int n, maxResult;
    static int[] number;
    static String[] operator;
    static boolean[] selected;
    static boolean usedBefore;
    static List<Integer> noBracketNumber;
    static List<String> noBracketOperator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n / 2 + 1];
        operator = new String[n / 2];
        String[] str = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                number[i / 2] = Integer.parseInt(str[i]);
            } else {
                operator[i / 2] = str[i];
            }
        }

        if (n == 1) {
            System.out.println(number[0]);
        } else {
            selected = new boolean[n / 2];
            usedBefore = false;
            maxResult = Integer.MIN_VALUE;
            subsetBracket(0);
            System.out.println(maxResult);
        }
    }

    private static void subsetBracket(int idx) {
        if (idx == n / 2) {
            // 괄호 선택
            boolean bracket = false;
            noBracketNumber = new ArrayList<>();
            noBracketOperator = new ArrayList<>();
            for (int i = 0; i < n / 2; i++) {
                // 선택된 괄호 계산
                if (selected[i]) {
//                    System.out.print(operator[i]+" ");
                    bracket = true;
                    noBracketNumber.add(calculate(i));
                } else {
                    if (!bracket) {
                        noBracketNumber.add(number[i]);
                    }
                    noBracketOperator.add(operator[i]);
                    bracket = false;
                }
                if (i == n / 2 - 1 && !selected[i]) {
                    noBracketNumber.add(number[i + 1]);
                }
            }
//            System.out.println();
//            for (int i = 0; i < noBracketOperator.size(); i++) {
//                // 선택된 괄호 계산
//                System.out.print(noBracketOperator.get(i)+" ");
//            }
//            System.out.println();
//            for (int i = 0; i < noBracketOperator.size(); i++) {
//                System.out.print(noBracketNumber.get(i)+" "+noBracketOperator.get(i));
//            }
//            System.out.println(noBracketNumber.get(noBracketNumber.size()-1));
//            System.out.println();
            if (!noBracketOperator.isEmpty()) {
                int res = noBracketNumber.get(0);
                for (int i = 0; i < noBracketOperator.size(); i++) {
                    res = calculate2(res, i);
                }
                maxResult = Math.max(res, maxResult);
            } else {
                maxResult = Math.max(noBracketNumber.get(0), maxResult);
            }
            return;
        }

        if (!usedBefore) {
            selected[idx] = true;
            usedBefore = true;
            subsetBracket(idx + 1);
            selected[idx] = false;
            usedBefore = false;
            subsetBracket(idx + 1);
        } else {
            usedBefore = false;
            selected[idx] = false;
            subsetBracket(idx + 1);
        }

    }

    private static int calculate(int i) {
        int ans = 0;
        switch (operator[i]) {
            case "+":
                ans = number[i] + number[i + 1];
                break;
            case "-":
                ans = number[i] - number[i + 1];
                break;
            case "*":
                ans = number[i] * number[i + 1];
                break;
            case "/":
                ans = number[i] / number[i + 1];
                break;
        }
        return ans;
    }

    private static int calculate2(int res, int i) {
        int ans = 0;
        switch (noBracketOperator.get(i)) {
            case "+":
                ans = res + noBracketNumber.get(i + 1);
                break;
            case "-":
                ans = res - noBracketNumber.get(i + 1);
                break;
            case "*":
                ans = res * noBracketNumber.get(i + 1);
                break;
            case "/":
                ans = res / noBracketNumber.get(i + 1);
                break;
        }
        return ans;
    }
}
