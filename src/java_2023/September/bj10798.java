import java.io.*;

public class bj10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] A = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            String[] wordArr = word.trim().split("");
            for (int j = 0; j < 15; j++) {
                if (j< wordArr.length)
                    A[i][j] = wordArr[j];
                else
                    A[i][j] = " ";
            }
        }

        String str = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (A[j][i] != " ")
                    str += A[j][i];
            }
        }

        bw.write(str.trim());
        bw.flush();
    }
}
