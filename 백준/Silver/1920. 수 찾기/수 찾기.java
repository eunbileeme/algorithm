import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // n
        int[] nrr = new int[n]; // n개의 정수 A
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i ++) {
            nrr[i] = Integer.parseInt(st1.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // m
        int[] mrr = new int[m]; // m개의 수
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i ++ ) {
            mrr[i] = Integer.parseInt(st2.nextToken());
        }

        // ※ nrr = 이진 탐색 트리
        // ※ mrr = target을 담은 배열, 즉 이진 탐색 트리가 아님
        Arrays.sort(nrr);

        for (int i = 0; i < m; i ++) {
            System.out.println(getIndex(nrr, mrr[i]));
        }

        br.close();
    }

    private static int getIndex(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == target) return 1;

            if (target < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return 0;
    }
}