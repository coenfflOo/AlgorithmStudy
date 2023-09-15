import java.io.*;

public class bj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        int max = arr[0];
        for(int i=0; i<9; i++){
            if(max<arr[i]){
                max = arr[i];
                index = i;
            }
        }

        bw.write(max+"\n"+(index+1));
        bw.flush();
    }
}
