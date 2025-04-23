package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1976 {
    private static int n,m;
    private static int[] city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        setCity();
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken())==1)
                    unionCity(i,j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (findCity(start) != findCity(nextCity)) {
                System.out.println("NO");
                return;
            }
            start = nextCity;
        }
        System.out.println("YES");
    }

    private static void setCity() {
        city = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            city[i] = i;
        }
    }

    private static void unionCity(int a, int b) {
        a = findCity(a);
        b = findCity(b);

        if (a != b) {
            if (a < b) city[b] = a;
            else city[a] = b;
        }
    }

    private static int findCity(int c) {
        if (city[c] == c) return c;
        else return city[c] = findCity(city[c]);
    }
}
