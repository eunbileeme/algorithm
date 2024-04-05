import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        String str = br.readLine();

        // 2. 출력용 변수
        StringBuilder sb = new StringBuilder();

        // 3. X 카운트용 변수
        int cntX = 0;

        for (int i = 0; i < str.length(); i++) {
            // 4. 문자열의 문자가 'X'일 경우
            if (str.charAt(i) == 'X') {
                // 5. X의 개수를 증가
                cntX++;
            } else {
                // 6. X가 아니라면(= '.'이라면), 현재까지의 X를 변환
                // TODO StringBuilder에 문자열 저장은 .append()
                sb.append(replace(cntX));
                // 14. X의 개수를 초기화
                cntX = 0;
                // 15. 현재 마주한 '.' 추가
                sb.append(".");
            }
        }

        // TODO 16. '.'가 없는 문자열에서, X를 처리
        // 이 과정이 없을 경우, 아래의 경우는 공백이 출력
        // ex. "XXXXXX" -> for문의 if만 수행하여, cntX만 증가했기 때문에 sb에는 어떠한 값도 담기지 않았기 때문
        sb.append(replace(cntX));

        // 17. 'X'가 있다면 -1 반환
        if (sb.toString().contains("X")) {
            System.out.println(-1);
            return;
        }

        // 18. 출력
        System.out.println(sb);
        br.close();
    }

    private static String replace(int cntX) {
        StringBuilder tmp = new StringBuilder();

        // 7. X가 4 이상이라면
        while (cntX >= 4) {
            // 8. A 4개 추가
            tmp.append("AAAA");
            // 9. cntX에서 -4
            cntX -= 4;
        }

        // 10. X가 2라면
        if (cntX == 2) {
            // 11. B 2개 추가
            tmp.append("BB");
            // 12. 남은 X가 있다면
        } else if (cntX != 0) {
            // 13. 그대로 X
            tmp.append("X");
        }

        return tmp.toString();
    }
}