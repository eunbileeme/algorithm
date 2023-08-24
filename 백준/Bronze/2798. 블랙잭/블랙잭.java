import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken()); // 5
        int m = Integer.parseInt(st1.nextToken()); // 21
        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        boolean find = false;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i + 1; j < arr.length; j ++) {
                for (int k = j + 1; k < arr.length; k ++) {
                    if (arr[i] + arr[j] + arr[k] == m) {
                        answer = m;
                        find = true;
                        // ※ 아래의 break는 3중 for문만 탈출, 1과 2중 for문은 탈출하지 않음
                        break;
                    } else if (answer < arr[i] + arr[j] + arr[k] && arr[i] + arr[j] + arr[k] < m) {
                        answer = arr[i] + arr[j] + arr[k];
                    }
                }
                if (find)
                    break;
            }
            if (find)
                break;
        }

        System.out.println(answer);

        br.close();
    }
}