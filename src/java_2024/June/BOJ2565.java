package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            map.put(index,num);
        }
//        System.out.println(map);

        Pole[] pole = new Pole[map.lastKey()+1];
        pole[0] = new Pole(0,0);
        int max=0;
        for (int i = 1; i <= map.lastKey(); i++) {
//            System.out.println(i);
            boolean flag = false;
            int maxIndex = Integer.MIN_VALUE;
            int minNumber = Integer.MAX_VALUE;
            int c = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (pole[j]!=null&&map.get(i)!=null){
                    if (pole[j].connection>c&&pole[j].number<map.get(i)) {
                        flag=true;
                        maxIndex = Math.max(maxIndex, j);
                        c=Math.max(c,pole[j].connection);
                        minNumber=pole[j].number;
                    } else if (pole[j].connection==c&&pole[j].number<minNumber&&pole[j].number<map.get(i)){
                        flag=true;
                        minNumber=Math.min(minNumber,pole[j].number);
                        maxIndex = Math.max(maxIndex, j);
                    }
                }
            }
            if (flag)
                pole[i] = new Pole(pole[maxIndex].connection+1, map.get(i));
            if (pole[i]!=null&&max<pole[i].connection)
                max = Math.max(max,pole[i].connection);
        }
//        System.out.println(Arrays.toString(pole));
        System.out.println(n-max);
    }

    static class Pole {
        int connection;
        int number;

        public Pole(int connection, int number) {
            this.connection = connection;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Pole{" +
                    "connection=" + connection +
                    ", number=" + number +
                    '}';
        }
    }
}
