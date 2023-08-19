import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // ※ 자바는 문자열에 * n만큼 반복시킬 수 없음
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 3
            int a = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            // j = 0
            // j = 1..
            for (int j = 0; j < str.length(); j ++) {
                // k = 0 -> str.charAt(0) -> A
                // k = 1 -> str.charAt(1) -> AA
                // k = 2 -> str.charAt(2) -> AAA
                // k = 0 - > str.charAt(0) -> AAAB
                // k = 1 -> str.charAt(1) -> AAABB
                /// K = 2 -> str.charAt(2) -> AAABBB..
                for (int k = 0; k < a; k ++) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }

        br.close();
    }
}