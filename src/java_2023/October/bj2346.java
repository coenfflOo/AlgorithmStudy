package java_2023.October;
import java.util.*;
import java.io.*;

//public class bj2346 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Deque<Integer> balloon = new LinkedList<>();
//        List<String> num = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            num.add(st.nextToken());
//            balloon.add(Integer.parseInt(num.get(i)));
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int count = 0;
//        while (count < N){
//            int index = balloon.peekFirst();
//            sb.append(balloon.pop()+" ");
//            count++;
//
//            if (index>0) {
//                for (int i = 0; i < index-1; i++) {
//                    balloon.addLast(balloon.pollFirst());
//                }
//            } else {
//                for (int i = 0; i < Math.abs(index); i++) {
//                    balloon.addFirst(balloon.pollLast());
//                }
//            }
//        }
//
//        for (String str :
//                sb.toString().split(" ")) {
//            bw.write(String.valueOf(num.indexOf(str)+1)+" ");
//        }
//        bw.close();
//    }
//}

public class bj2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Balloon> balloons = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        int currentIndex = 0;

        while (!balloons.isEmpty()) {
            Balloon balloon = balloons.remove(currentIndex);
            sb.append(balloon.index).append(" ");

            int move = balloon.value;
            int size = balloons.size();

            if (size == 0) break;

            if (move > 0) {
                currentIndex = (currentIndex + move - 1) % size;
            } else {
                currentIndex = (currentIndex + move) % size;
                if (currentIndex < 0) currentIndex += size;
            }
        }

        bw.write(sb.toString());
        bw.close();
    }

    static class Balloon {
        int index;
        int value;

        public Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
