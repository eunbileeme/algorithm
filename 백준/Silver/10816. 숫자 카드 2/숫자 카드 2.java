import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        HashMap<Integer, Integer> map = new HashMap<>(); // 6 3 2 10 10 10 -10 -10 7 3

        // ※ 숫자 카드에 적힌 수를 입력받을 때, 해당 수를 key로 하여 빈도수를 value로 저장
        for (int i = 0; i < n; i ++) {
            int card = Integer.parseInt(st1.nextToken());
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int[] num = new int[m]; // 10 9 -5 2 3 4 5 -10
        for (int i = 0; i < m; i ++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        // ※ m개의 정수를 순회하면서, 해당 수가 있다면(= key로 있다면) value를 뱉어내고 아니라면 0을 도출
        for (int i = 0; i < m; i ++) {
            sb.append(map.getOrDefault(num[i], 0)).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}