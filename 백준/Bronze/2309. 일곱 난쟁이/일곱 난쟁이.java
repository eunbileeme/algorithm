import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
            // ※ 일단 난쟁이 9명 모두의 키 합을 저장
            sum += arr[i];
        }

        Arrays.sort(arr);

        int fake1 = 0;
        int fake2 = 0;
        boolean find = false;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i + 1; j < arr.length; j ++) {
                // ※ (오름차순 기준) arr[i] 및 arr[j]를 제외한 sum = 100이라면
                if (sum - arr[i] - arr[j] == 100) {
                    // ※ 두 값은 가짜
                    fake1 = arr[i];
                    fake2 = arr[j];
                    find = true;
                    break;
                }
                if (find)
                    break;
            }
            if (find)
                break;
        }

        for (int i = 0; i < arr.length; i ++) {
            if (fake1 == arr[i] || fake2 == arr[i]) {
                continue;
            }
            System.out.println(arr[i]);
        }

        br.close();
    }
}