import java.util.*;
import java.io.*;
public class bj25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";
        double scoreSum = 0;
        double gradeSum = 0;
        while ((s = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(s);
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")){
                scoreSum += score;
                gradeSum = score*gradeScore(grade);
            }
        }
        double avg = gradeSum/scoreSum;
        bw.write(String.valueOf(avg));
        bw.flush();
    }

    private static double gradeScore(String grade){
        double result = 0;
        switch (grade){
            case "A+":
                result = 4.5;
                break;
            case "A0":
                result = 4.0;
                break;
            case "B+":
                result = 3.5;
                break;
            case "B0":
                result = 3.0;
                break;
            case "C+":
                result = 2.5;
                break;
            case "C0":
                result = 2.0;
                break;
            case "D+":
                result = 1.5;
                break;
            case "D0":
                result = 1.0;
                break;
            case "F":
                result = 0.0;
                break;

        }
        return result;
    }
}
