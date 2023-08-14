import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        // ※ st.countTockens(): StringTokenizer에 남아있는 토큰의 수를 반환
        // 따라서 사전에 토큰의 개수를 따로 변수에 보관
        int tokenCount = st.countTokens();
        
        for (int i = 0; i < tokenCount; i ++) {
            answer += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        System.out.println(answer % 10);

        br.close();
    }
}