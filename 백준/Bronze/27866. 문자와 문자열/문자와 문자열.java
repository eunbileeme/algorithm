import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ※ StringTokenizer : 문자열을 특정 구분자를 기준으로 나누는 데 사용되는 클래스
        // 따라서, 직접적으로 .charAt()와 같은 메서드 사용 불가
        String str = br.readLine();
        int a = Integer.parseInt(br.readLine());

        System.out.println(str.charAt(a - 1));

        br.close();
    }
}