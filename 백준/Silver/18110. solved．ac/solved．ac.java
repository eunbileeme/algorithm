import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 문자열의 길이

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // ※ 0.3 : 가장 높은 난이도에 투표한 n명 + 가장 낮은 난이도에 투표한 n명
        double jAvg = arr.length * 0.3;
        // ※ 0.15 : 가장 높은 난이도에 투표한 n명 / 가장 낮은 난이도에 투표한 n명 -> 반올림 -> int
        int criteria = (int) Math.round(jAvg / 2);

        int sum = 0;
        int cnt = 0;
        // ※ 가장 낮은 난이도에 투표한 n명과 가장 높은 난이도에 투표한 n명 사이를 순회
        for (int i = criteria; i < arr.length - criteria; i ++) {
            sum += arr[i];
            cnt ++;
        }

        // ※ java : 정수 / 정수 = 정수
        // ※ 따라서 int -> float -> int
        int result = Math.round((float) sum / cnt);

        System.out.println(result);

        br.close();
    }
}