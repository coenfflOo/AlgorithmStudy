package java_2024.Mar;
import java.util.*;
import java.io.*;
public class BOj20055 {
    static int n,k;
    static Point[][] belt;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        belt = new Point[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                belt[i][j] = new Point(sc.nextInt(),false);
            }
        }
        belt[0][0].putRobot();
        belt[0][n-1].putRobot();

        int res = 0;
        while (checkBeltRunning()){
            rotate();

            res++;
        }
    }

    static void rotate(){
        Point temp = belt[1][0];
        for (int i = 0; i+1 < n; i++) {
            belt[1][i]=belt[1][i+1];
        }
        belt[1][n-1] = belt[0][n-1];
        for (int i = n-1; i>0; i--) {
            belt[0][i]=belt[0][i-1];
        }
        belt[0][0] = temp;
    }

    static void print(){
        System.out.println("-----------");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(belt[i][j].power+" ");
            }
            System.out.println();
        }
    }

    static boolean checkBeltRunning(){
        int cnt = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (belt[i][j].power == 0){
                    if(++cnt == k)
                        return false;
                }
            }
        }
        return true;
    }
    static class Point{
        int power;
        boolean robot;

        public Point(int power, boolean robot) {
            this.power = power;
            this.robot = robot;
        }

        public void getRobot(){
            robot = true;
            power--;
        }

        public void putRobot(){
            robot = false;
        }
    }
}
