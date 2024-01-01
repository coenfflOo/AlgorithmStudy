import java.util.*;
import java.io.*;

public class bj2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        int cook = Integer.parseInt(br.readLine());
        minutes += cook;
        if (minutes >= 60) {
            hour += minutes/60;
            minutes %= 60;
        }
        if (hour>=24)
            hour -= 24;
        System.out.println(hour+" "+minutes);
    }
}
