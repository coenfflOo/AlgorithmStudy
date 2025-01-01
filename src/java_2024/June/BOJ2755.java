package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ2755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        double sum = 0;
        double sumN=0;
        for (int i = 0; i <n; i++) {
            String[] str = br.readLine().split(" ");
            int score = Integer.parseInt(str[1]);
//            System.out.println(score);
            sumN += score;
            switch (str[2]){
                case "A+":
                    sum += score*4.3;
                    break;
                case "A0":
                    sum += score*4.0;
                    break;
                case "A-":
                    sum += score*3.7;
                    break;
                case "B+":
                    sum += score*3.3;
                    break;
                case "B0":
                    sum += score*3.0;
                    break;
                case "B-":
                    sum += score*2.7;
                    break;
                case "C+":
                    sum += score*2.3;
                    break;
                case "C0":
                    sum += score*2.0;
                    break;
                case "C-":
                    sum += score*1.7;
                    break;
                case "D+":
                    sum += score*1.3;
                    break;
                case "D0":
                    sum += score*1.0;
                    break;
                case "D-":
                    sum += score*0.7;
                    break;
                case "F":
                    sum += score*0.0;
                    break;
            }
        }
        double res = Math.round(sum/sumN*100);
        System.out.println(String.format("%.2f",res/100));
    }
}
