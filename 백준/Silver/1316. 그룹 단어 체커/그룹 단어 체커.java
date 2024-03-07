import java.io.*;
import java.util.*;

public class Main {
    // TODO 그룹 단어 : "각 문자가 연속해서 나타나는 경우"
    // ex. cc / a / zzzz / bb
    // TODO 그룹 단어가 아닌 것
    // ex. aa / bbb / cc / b

    // TODO 그룹 단어의 개수 출력하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1-1. int n = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        // 1-2. for (int i = 0; i < n; i ++) {
        // str.
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            // TODO Q. isGroupWord는 왜 필요할까?
            boolean isGroupWord = true;
            // TODO Q. 왜 list가 1중 for문 내부에 있어야 할까?
            // list는 다음 반복에 영향을 미치면 안되기 때문에, 초기화되어야 함.
            List<Character> list = new ArrayList<>();

            for (int j = 0; j < str.length(); j++) {
                // 1-4. if (str.charAt(j - 1) != str.charAt(j))
                // 1-5. if (list.contains(str.charAt(j))
                // TODO Q. (int j = 0; j < str.length()) && (j > 0)이어야 할까?
                if (j > 0 && str.charAt(j - 1) != str.charAt(j) && list.contains(str.charAt(j))) {
                    isGroupWord = false;
                    // 1-6. break;
                    break;
                }

                if (!list.contains(str.charAt(j))) {
                    list.add(str.charAt(j));
                }
            }

            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);
    }
}
