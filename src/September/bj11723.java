package September;
import java.util.*;
import java.io.*;
public class bj11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "add":
                    set.add(Integer.parseInt(str[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(str[1]));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(str[1])))
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "toggle":
                    if (set.contains(Integer.parseInt(str[1])))
                        set.remove(Integer.parseInt(str[1]));
                    else
                        set.add(Integer.parseInt(str[1]));
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
    }
}
