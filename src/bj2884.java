import java.util.*;
import java.io.*;
public class bj2884 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        if (minute < 45) {
            if (hour == 0){
                hour = 23;
                minute  = minute + 60 - 45;
            }
            else {
                hour--;
                minute  = minute + 60 - 45;
            }
        }
        else
            minute -= 45;
        System.out.println(hour+" "+minute);
    }
}