import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        // ※ 입력의 첫 번째 혹은 두 번째 줄에 n개의 값이 주어지지 않았으므로
        // String + while() 문을 이용해 행에 데이터가 없을 때까지 반복
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a + b);
        }

        br.close();
    }
}