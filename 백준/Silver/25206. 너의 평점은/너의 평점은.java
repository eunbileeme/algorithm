import java.io.*;
import java.util.*;

public class Main {
    // 전공 평점 : (학점 x 과목평점)의 합 / 총합
    // 단, 등급이 P인 과목은 계산에서 제외
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. (학점 x 과목평점)의 합 및 학점 총합을 담을 변수
        double creditMultiplicationScore = 0;
        double creditSum = 0;

        // 2. (학점 x 과목평점) 및 학점의 총합 계산
        for (int i = 0; i < 20; i++) {
            String[] nameScoreRank = br.readLine().split(" ");
            double credit = Double.parseDouble(nameScoreRank[1]);

            if (nameScoreRank[2].equals("P")) continue;
            else if (nameScoreRank[2].equals("A+")) creditMultiplicationScore += (credit * 4.5);
            else if (nameScoreRank[2].equals("A0")) creditMultiplicationScore += (credit * 4.0);
            else if (nameScoreRank[2].equals("B+")) creditMultiplicationScore += (credit * 3.5);
            else if (nameScoreRank[2].equals("B0")) creditMultiplicationScore += (credit * 3.0);
            else if (nameScoreRank[2].equals("C+")) creditMultiplicationScore += (credit * 2.5);
            else if (nameScoreRank[2].equals("C0")) creditMultiplicationScore += (credit * 2.0);
            else if (nameScoreRank[2].equals("D+")) creditMultiplicationScore += (credit * 1.5);
            else if (nameScoreRank[2].equals("D0")) creditMultiplicationScore += (credit * 1.0);
            else creditMultiplicationScore += (credit * 0);

            creditSum += credit;
        }

        // 3. 출력
        double result = creditMultiplicationScore / creditSum;
        System.out.println(result);
        br.close();
    }
}
