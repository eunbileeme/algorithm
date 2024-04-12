import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 이전 순열 로직 수행
        if (previousPermutation(nums)) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
        br.close();
    }

    private static boolean previousPermutation(int[] nums) {
        // 2. nums[i - 1] > nums[i]를 만족하는 첫 번째 수 찾기
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] <= nums[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        // 2. nums[i - 1] > nums[j]를 만족하는 첫 번째 수 찾기?
        int j = nums.length - 1;
        while (nums[j] >= nums[i - 1]) {
            j -= 1;
        }

        // 3. nums[i - 1]과 nums[j] swap
        swap(nums, i - 1, j);

        // 4. i부터 nums.length - 1까지 순열 뒤집기
        j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i += 1;
            j -= 1;
        }

        return true;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
