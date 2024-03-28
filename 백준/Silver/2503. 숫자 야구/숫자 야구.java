import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] questions = new int[n][3]; // 각 질문과 스트라이크, 볼 저장

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            questions[i][0] = Integer.parseInt(st.nextToken()); // 질문한 수
            questions[i][1] = Integer.parseInt(st.nextToken()); // 스트라이크 수
            questions[i][2] = Integer.parseInt(st.nextToken()); // 볼 수
        }

        int cnt = 0; // 가능한 수의 개수
        for (int i = 123; i <= 987; i++) {
            if (isValidNumber(i, questions)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isValidNumber(int number, int[][] questions) {
        String numStr = String.valueOf(number);
        if (numStr.charAt(0) == '0' || numStr.charAt(1) == '0' || numStr.charAt(2) == '0' || 
            numStr.charAt(0) == numStr.charAt(1) || numStr.charAt(0) == numStr.charAt(2) || 
            numStr.charAt(1) == numStr.charAt(2)) {
            return false; // 유효하지 않은 숫자 조건 검사
        }

        for (int[] question : questions) {
            String questionStr = String.valueOf(question[0]);
            int strike = 0, ball = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (questionStr.charAt(i) == numStr.charAt(j)) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }

            if (strike != question[1] || ball != question[2]) {
                return false; // 하나라도 조건에 맞지 않으면 false
            }
        }

        return true; // 모든 조건을 만족하면 true
    }
}
