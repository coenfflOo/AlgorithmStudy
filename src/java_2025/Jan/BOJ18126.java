package java_2025.Jan;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ18126 {
    private static int n;
    private static ArrayList<ArrayList<Room>> rList;
    private static boolean[] visited;
    private static long max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         if(n==1){
             System.out.println("0");
             exit(0);
         }

        rList = new ArrayList<>();
         for(int i = 0; i < n+1; i++){
             rList.add(new ArrayList<>());
         }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            rList.get(a).add(new Room(b,c));
            rList.get(b).add(new Room(a,c));
        }

        visited = new boolean[n+1];
        visited[1] = true;
        max = 0;
        dfsRoom(1,0);
        System.out.println(max);
    }

    private static void dfsRoom(int rNum, long dist){
        for(Room room:rList.get(rNum)){
            if(visited[room.num])
                continue;
            if(dist+room.distance>max)
                max = dist+room.distance;

            visited[room.num] = true;
            dfsRoom(room.num, dist+room.distance);
        }
    }

    static class Room {
        int num;
        long distance;

        public Room(int num, long distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}
