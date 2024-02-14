package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        boolean six = false;
        for (int i = 0; i < number.length(); i++) {
            char c= number.charAt(i);
            if (c == '6' || c == '9'){
                six = true;
                map.put('6', map.getOrDefault('6',0)+1);
            } else {
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        if (six && map.get('6')>=2){
            if (map.get('6')%2==0)
            map.put('6', map.get('6')/2);
            else
                map.put('6', map.get('6')/2+1);
        }
        int max = 0;
        for (int num :
                map.values()) {
            if (max < num)
                max = num;
        }
        System.out.println(max);
    }
}
