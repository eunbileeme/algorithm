import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // st.countTokens() : 토큰, 즉 공백을 기준으로 입력받은 문자열의 개수를 센다.
        System.out.println(st.countTokens());
        br.close();
    }
}