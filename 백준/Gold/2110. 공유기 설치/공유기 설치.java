import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 초기화
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] house = new int[n];

        // 2. 입력
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        // 3. 정렬
        Arrays.sort(house);

        // 4. 탐색 및 출력
        System.out.println(getMaxDistance(n, c, house));
        br.close();
    }

    /*
     * 가장 인접한 공유기 사이의 최대 거리 구하기
     * -> 최소 거리(= 인접한 공유기 사이의 거리)가 최대가 될 때의 거리 구하기
     * l : 인접한 공유기 사이의 최소 거리
     * r : 인접한 공유기 사이의 최대 거리
     * m : 찾고자 하는 인접한 공유기 사이의 최소 거리가 "최대"가 될 때의 거리
     * = 설치한 공유기의 수가 설치할 수 있는 공유기의 수와 같아졌을 때, 최대 거리인지 알 수 없으므로
     * 구하고자 하는 최소 거리를 늘리면서 최대인 경우의 거리
     */

    /*
     * - 최소 거리에 따라 설치할 수 있는 공유기의 수(= c)가 정해짐
     * - 이때, 최소 거리가 최대일 때를 찾는 것
     * 1. 첫 번째 집에 공유기를 설치
     * 2. 최소 거리를 설정
     * 3. 직전에 공유기를 설치한 집으로부터 최소 거리만큼 거리를 두고 있는 집들 중, 가장 가까운 거리에 공유기를 설치
     * 4. 반복한 후, 설치된 공유기의 수와 c를 비교
     */

    // lower
    private static int getMaxDistance(int houseCnt, int target, int[] house) {
        int l = 0; // ※ 거리(값)를 구하는 것이기 때문에 인덱스로 둔게 애매
        int r = house[houseCnt - 1];
        int maxDistance = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int routerPosition = 0;
            int installRouter = 1;

            for (int i = 1; i < houseCnt; i++) {
                if (house[i] - house[routerPosition] >= m) {
                    routerPosition = i;
                    installRouter++;
                }
            }
            
            if (target <= installRouter) { 
                // 가지고 있는 공유기(= 설치 해야 할 공유기)가 설치한 공유기의 수보다 작다면
                // 너무 많이 설치했다는 것 = 최소 거리를 작게 잡았다는 것 = 최소 거리를 늘려야 함
                maxDistance = m;
                l = m + 1;
            } else {
                r = m - 1; // target > installRouter
            }
        }

        return maxDistance;
    }
}