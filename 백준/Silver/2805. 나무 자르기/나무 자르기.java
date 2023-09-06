import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i ++) {
            arr[i] += Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(getValue(arr, m));

        br.close();
    }

    private static int getValue(int[] arr, int heightMax) {
        int l = 0, r = arr[arr.length - 1]; // ※ 왜 l = arr[0]이면 틀릴까?
        int result = 0;

        while (l <= r) {
            int m = l + (r - l) / 2; // ※ 절단기의 높이(단, 최댓값을 구하는 게 목적)
            long sum = 0; // ※ 오버플로우가 왜 발생?

            for (int i = 0; i < arr.length; i ++) {
                if (arr[i] > m)
                    sum += arr[i] - m;
            }

            // ※ sum이 heightMax보다 작다면
            // = 원하는 나무의 길이보다 덜 잘랐다면
            // = 절단기의 높이가 너무 높게 설정된 것이므로, 절단기의 높이를 낮추기 위해 r의 범위를 줄임
            if (sum < heightMax) {
                r = m - 1;
            } else {
                result = m;
                l = m + 1;
            }
        }

        return result; // ※ 반환하고자 하는 값
    }
}