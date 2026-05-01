import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i=0; i<a.length(); i++){
            String s = String.valueOf(a.charAt(i));
            if(a.charAt(i)-'a'>=0){
                System.out.print(s.toUpperCase());
            } else {
                System.out.print(s.toLowerCase());
            }
            
        }
    }
}