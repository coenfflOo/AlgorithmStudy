package java_2024.June;

import java.util.*;
import java.io.*;
public class BOJ1351 {
    static HashMap<Long,Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        map = new HashMap<>();

        map.put(0L,1L);
        System.out.println(solve(n,p,q));
    }

    private static long solve(long n, long p, long q) {
        if (map.containsKey(n))
            return map.get(n);

        long np =  solve(n/p,p,q);
        long nq = solve(n/q,p,q);

        map.put(n,np+nq);
        return np+nq;
    }
}
