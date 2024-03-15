import java.io.*;
import java.util.*;

public class Main {
    // 한 세트 : 0 ~ 9
    // ex. 9999 -> 69  69 : 총 2세트
    // ex. 122 -> 12  2 : 총 2세트
    // ex. 12635 -> 12635 : 총 1세트
    // ex.888888 -> 8 8 8 8 8 8 : 총 6세트

    // TODO (1) 6 또는 9만 하나만 증가시키면 됨
    // TODO (2) "중복의 최대 수" = int 배열로 카운트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        // 1. 중복의 최대 수 카운트
        int[] plastics = new int[10];
        for (int i = 0; i < n.length(); i++) {
            int idx = Character.getNumericValue(n.charAt(i));

            if (idx == 9) idx = 6;
            plastics[idx]++;
        }

        // TODO 1.5개는 결과적으로 2개
        // ex. 69(= 66) -> (2 / 2) + (2 % 2) = 1 + 0 = 1 세트
        // ex. 696(= 666) -> (3 / 2) + (3 % 2) = 1 + 1 = 2 세트
        plastics[6] = (plastics[6] / 2) + (plastics[6] % 2);

        Arrays.sort(plastics);
        System.out.println(plastics[9]);
        br.close();
    }
}
