// 그리디 : https://tang25.tistory.com/entry/%EB%B0%B1%EC%A4%80-1343%EB%B2%88-%ED%8F%B4%EB%A6%AC%EC%98%A4%EB%AF%B8%EB%85%B8-%EC%97%84%ED%83%B1-%EA%B0%9C%EB%B0%9C-%EB%B8%94%EB%A1%9C%EA%B7%B8-%EA%B7%B8%EB%A6%AC%EB%94%94-%EC%9E%90%EB%B0%94
// 가장 큰 블록인 "AAAA"로 대체한 후 나머지가 있다면 "BB"로 대체
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("\\.");
        StringBuilder sb = new StringBuilder();

        // XXXX..XX.XX
        // ["XXXX", "", "XX", "XX"]
        for (int i = 0; i < strArr.length; i ++) {
            if (strArr[i].length() % 2 != 0) {
                // 무조건 중간에 2 또는 4로 나눌 수 없다면, 새로운 StringBuilder에 "-1"을 붙인 후 반환
                sb = new StringBuilder("-1");
                break;
            } else if (strArr[i].length() % 4 == 0) {
                // ※ 'A'씩 붙이는게 아니라 "AAAA"로 붙일 수 있음
                sb.append("AAAA".repeat(strArr[i].length() / 4));

            } else {
                // ※ 몫만큼 "AAAA"를 붙여줌으로써 "XX"일 경우는 "BB"만 추가
                sb.append("AAAA".repeat(strArr[i].length() / 4));
                sb.append("BB");
            }
            // 알파벳 사이의 "."를 붙여주기 위한 조건문
            // ※ 연속된 n개의 "."가 있다면, n - 1개의 ""로 구성됨

            // XXXX..XX.XX -> ["XXXX", "", "XX", "XX"]
            // i = 0일 때, "AAAA" -> if -> "AAAA."
            // i = 1일 때, if -> "AAAA.."
            // i = 2일 때, "AAAA..BB" -> if -> "AAAA..BB."
            if (i != strArr.length - 1)
                sb.append(".");
        }

        String answer = sb.toString();
        if (!answer.equals("-1")) {
            // 알파벳의 맨 끝에 "."가 있었다면, 다시 붙여주기 위한 조건문
            sb.append(".".repeat(str.length() - answer.length()));
        }

        System.out.println(sb.toString());

        br.close();
    }
}
