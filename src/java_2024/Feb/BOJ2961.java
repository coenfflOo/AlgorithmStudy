package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ2961 {
    static Ingredient[] ingredients;
    static boolean[] isSelected;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ingredients = new Ingredient[N];
        isSelected = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        min = Integer.MAX_VALUE;
        ingredientSubset(0);
        System.out.println(min);
    }

    private static void ingredientSubset(int index) {

        if (index == ingredients.length) {
            if (booleanCheck() > 0) {
                int sour = 1;
                int bitter = 0;
                for (int i = 0; i < ingredients.length; i++) {
                    if (isSelected[i]) {
                        sour *= ingredients[i].sour;
                        bitter += ingredients[i].bitter;
                    }
                }

                int sub = Math.abs(sour - bitter);
                min = Math.min(sub, min);
            }
            return;
        }

        isSelected[index] = true;
        ingredientSubset(index + 1);
        isSelected[index] = false;
        ingredientSubset(index + 1);
    }

    static int booleanCheck() {
        int cnt = 0;
        for (int i = 0; i < isSelected.length; i++) {
            if (isSelected[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    static class Ingredient {
        int sour;
        int bitter;

        Ingredient(int s, int b) {
            sour = s;
            bitter = b;
        }
    }
}
