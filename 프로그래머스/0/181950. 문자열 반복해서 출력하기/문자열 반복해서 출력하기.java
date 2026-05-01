import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        String answer="";
        while(n-->0){
            answer+=str;
        }
        System.out.println(answer);
    }
}