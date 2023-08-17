import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCount = Integer.parseInt(br.readLine());
        // ※ 한 줄에 여러 데이터가 붙어서 입력되었을 경우
        // String에 해당 한 줄을 보관 -> char로 한 문자씩 가져온 후 정수로 변환 -> sum에 데이터 누적
        String str = br.readLine();
        int sum = 0;

        for (int i = 0; i < numCount; i ++) {
            sum += str.charAt(i) - '0';
        }

        System.out.println(sum);

        br.close();
    }
}