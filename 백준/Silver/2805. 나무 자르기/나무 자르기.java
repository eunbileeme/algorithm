import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 나무의 수 : n
        int m = Integer.parseInt(st.nextToken()); // 집으로 가져가려는 나무의 길이 : m

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // [10, 15, 17, 20]

        System.out.println(bst(arr, m)); // m만큼 길이의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
        br.close();
    }

    private static long bst(int[] arr, int target) {
        int l = 0, r = arr[arr.length - 1]; // l = 0, r = 20
        long result = 0; // ※ 리턴해주기 위한 변수

        while (l <= r) {
            int m = l + (r - l) / 2;
            long sum = 0; // ※ 오버플로우 방지를 위해 long으로 변경

            for (int i = 0; i < arr.length; i ++) {
                if (arr[i] >= m) {
                    sum += arr[i] - m;
                }
            }

            // if (sum == target) return m;

            // ※ 자른 나무 길의 합(sum)이 집으로 가져가려고 하는 나무의 길이보다 작다면
            // 절단기의 높이가 너무 높은 것, 따라서 높이를 줄여야 함
            if (sum < target) {
                // result = m;
                r = m - 1;
            } else {
                result = m;
                l = m + 1;
            }
        }

        return result;
    }
}