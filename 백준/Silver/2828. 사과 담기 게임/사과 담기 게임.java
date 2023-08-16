// 그리디 : https://buzz-program.tistory.com/entry/%ED%8C%8C%EC%9D%B4%EC%8D%AC-BOJ2828%EC%82%AC%EA%B3%BC-%EB%8B%B4%EA%B8%B0-%EA%B2%8C%EC%9E%84
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int appleCount = Integer.parseInt(br.readLine());

        // ※ 바구니의 크기를 어떻게 표현해야할지 몰랐기에 실패
        int left = 1; int right = m;
        int bucketDistance = 0;

        for (int i = 0; i < appleCount; i ++) {
            int where = Integer.parseInt(br.readLine());

            // ※ 아래와 같이 고려하거나 또는 고려하지 않고 사과가 바구니의 오른쪽에 가깝게 떨어지는 경우를 else if로 처리하거나 ❗
            // 바구니 안에 떨어지는 경우
            if(left <= where && where <= right) {
                continue;
            }
            // 사과가 바구니의 왼쪽에 가깝게 떨어지는 경우
            if (left > where) {
                bucketDistance += (left - where);
                // ※ 사과가 떨어진 위치가 왼쪽보다 앞쪽에 위치하므로 왼쪽이 더 큰 값
                // 따라서, 왼쪽 - 사과가 떨어진 위치
                // 이후, 오른쪽이 왼쪽보다 큰 값이므로
                // 오른쪽 - (왼쪽 - 사과가 떨어진 위치)
                right -= (left - where);
                left = where;
                // 사과가 바구니의 오른쪽에 가깝게 떨어지는 경우(= where > right)
            } else {
                bucketDistance += (where - right);
                left += (where - right);
                right = where;
            }
        }
        System.out.println(bucketDistance);

        br.close();
    }
}
