import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        // ※ 연속되는 문자열을 어떻게 카운트할까?
        for (int i = 0; i < n; i ++) {
            int cnt = 0;
            int sum = 0;
            arr[i] = br.readLine();
            for (int j = 0; j < arr[i].length(); j ++) {
                // ※ 한 글자씩 가져와서 비교하며 카운트
               if (arr[i].charAt(j) == 'O') {
                   cnt ++;
               } else {
                   cnt = 0;
               }
                sum += cnt;
            }
            System.out.println(sum);
        }

        br.close();
    }
}