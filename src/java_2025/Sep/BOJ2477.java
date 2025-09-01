package java_2025.Sep;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dirs = new int[6];
        int[] dist = new int[6];
        int maxL = 0, maxH=0;
        int maxLIndex = 0, maxHIndex = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dirs[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());
            if (dirs[i]==1||dirs[i]==2){
                if (maxH<dist[i]){
                    maxH = dist[i];
                    maxHIndex = i;
                }
            } else {
                if (maxL<dist[i]){
                    maxL = dist[i];
                    maxLIndex = i;
                }
            }
        }
        int answer = (maxL*maxH-(dist[(maxLIndex+3)%6]*dist[(maxHIndex+3)%6]))*n;
        System.out.println(answer);
    }
}
