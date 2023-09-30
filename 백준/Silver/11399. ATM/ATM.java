import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람의 수
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 각 사람이 돈을 인출하는데 걸리는 시간

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        int answer = 0;
        int[] record = new int[arr.length];
        for (int i = 0; i < record.length; i ++) {
            sum += arr[i];
            record[i] = sum;
            answer += record[i];
        }

        System.out.println(answer);
    }
}
