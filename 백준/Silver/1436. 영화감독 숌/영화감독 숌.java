import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int cnt = 1; // ※ n번째 666 수

        while (cnt != n) {
            // ※ "666"을 만날 때까지 num을 증가시킴
            num ++;

            // ※ "666"을 만났다면, 즉시 cnt 증가
            if (String.valueOf(num).contains("666"))
                cnt ++;
        }

        System.out.println(num);

        br.close();
    }
}