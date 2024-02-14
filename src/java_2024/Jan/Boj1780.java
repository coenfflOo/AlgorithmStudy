package java_2024.Jan;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1780 {
    static int zeroPaper = 0;
    static int onePaper = 0;
    static int minusPaper = 0 ;
    static int[][] paper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        findPaper(paper);
        System.out.println(zeroPaper);
        System.out.println(onePaper);
        System.out.println(minusPaper);
    }

    private static void findPaper(int[][] panel) {
        if(allMatch(panel)) {
            return;
        }

        int[][] newArr = new int[panel.length/3][panel.length/3];
        for (int i = 0; i < panel.length; i+=panel.length/3) {
            for (int j = 0; j < panel.length; j+=panel.length/3) {
//                newArr[i][j] = panel[k*3+i][k*3+j];
            }
        }
        findPaper(newArr);
    }

    private static boolean allMatch(int[][] panel) {
        int[] arr = new int[panel.length*panel.length];
        for (int i = 0; i < panel.length; i++) {
            for (int j = 0; j < panel.length; j++) {
                arr[1*i+j] = panel[i][j];
            }
        }
        if(Arrays.stream(arr).allMatch(a->a==0)) {
            zeroPaper++;
            return true;
        } else if(Arrays.stream(arr).allMatch(a->a==1)) {
            onePaper++;
            return true;
        } else if(Arrays.stream(arr).allMatch(a->a==-1)) {
            minusPaper++;
            return true;
        }
        return false;
    }
}

