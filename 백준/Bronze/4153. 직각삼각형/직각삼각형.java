import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;

        // ※ (str = br.readLine().split(" "))[0] Ok.
        while (!(str = br.readLine().split(" "))[0].equals("0")) {
            // ※ 주어진 세 값이 항상 오름차순으로 정렬되어 들어온다는 보장이 없음
            // ※ 또한 이때, String 정렬 시 사전순으로 정렬이 되므로 int로 변환 후 수행
            int[] nums = new int[3];
            for (int i = 0; i < 3; i ++) {
                nums[i] = Integer.parseInt(str[i]);
            }

            Arrays.sort(nums);

            if (Math.pow(nums[0], 2) + Math.pow(nums[1], 2) == Math.pow(nums[2], 2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }

        br.close();
    }
}