package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int r = 0;
        int c = 0;
        for(r = (int)Math.sqrt(n); r>0; r--){
            if(n%r==0){
                c = n/r;
                break;
            }
        }
        Character[][] arr = new Character[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = str.charAt(j*r+i);
                System.out.print(arr[i][j]);
            }
        }
    }
}
