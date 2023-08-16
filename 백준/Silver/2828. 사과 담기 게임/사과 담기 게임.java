// 그리디
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