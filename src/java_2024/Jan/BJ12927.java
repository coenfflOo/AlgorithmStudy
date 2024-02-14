package java_2024.Jan;

import java.util.*;
import java.io.*;

public class BJ12927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strLight = br.readLine();
        String[] light = strLight.split("");
        if (Arrays.stream(light).allMatch(str -> str.equals("Y"))) {
            System.out.println("1");
        } else if (Arrays.stream(light).allMatch(str -> str.equals("N"))) {
            System.out.println("0");
        } else {
            int count = 0;
            String strLight2 = "N".concat(strLight);
            String[] light2 = strLight2.split("");
            for (int i = 1; i < light2.length; i++) {
                if (light2[i].equals("Y")){
                    for (int j = 1; j*i < light2.length; j++) {
                        if (light2[j*i].equals("Y"))
                            light2[j*i]="N";
                        else
                            light2[j*i]="Y";
                    }
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
