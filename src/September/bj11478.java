package September;
import java.util.*;
import java.io.*;
public class bj11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length()+1; j++) {
                result.add(str.substring(i,j));
            }
        }
        System.out.println(result.size());
    }
}
// String substring(int beginIndex, int endIndex)
// : beginIndex 위치에서 시작하여 endIndex의 이전 index까지의 값을 리턴