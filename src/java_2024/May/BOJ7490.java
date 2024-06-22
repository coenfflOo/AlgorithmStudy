package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ7490 {
    static int n;
    static int[] arr;
    static String[] symbol;
    static String[] selectedSymbol;
    static List<Integer> number = new ArrayList<>();
    static List<String> operator = new ArrayList<>();
    static int calRes;
    static StringBuilder res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        res = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for (int i = 1; i <= n; i++) {
                arr[i - 1] = i;
            }
            symbol = new String[]{" ", "+", "-"};

            selectedSymbol = new String[n - 1];
            permSymbol(0);
            res.append("\n");
        }
        System.out.println(res);
    }

    private static void permSymbol(int target) {
        if (target == n - 1) {
            number = new ArrayList<>();
            operator = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int num = 0;
            for (int i = 1; i <= n; i++) {
                if (i < n) {
                    if (selectedSymbol[i - 1].equals(" ")) {
                        num = num * 10 + i;
                        sb.append(i).append(selectedSymbol[i - 1]);
                    } else {
                        number.add(num * 10 + i);
                        num = 0;
                        operator.add(selectedSymbol[i - 1]);
                        sb.append(i).append(selectedSymbol[i - 1]);
                    }
                } else {
                    sb.append(i);
                    number.add(num * 10 + i);
                    num = 0;
                }
            }

            calRes = number.get(0);
            for (int i = 0; i < operator.size(); i++) {
                calculation(i);
            }

            if (calRes == 0) {
                res.append(sb).append("\n");
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            selectedSymbol[target] = symbol[i];
            permSymbol(target + 1);
        }
    }

    private static void calculation(int i) {
        switch (operator.get(i)) {
            case "+":
                calRes += number.get(i + 1);
                break;
            case "-":
                calRes -= number.get(i + 1);
                break;
        }
    }
}
