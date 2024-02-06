import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO 순열 : 서로 다른 n개 중 r개를 뽑아서 나열 <-> 조합 : 서로 다른 n개 중 r개를 순서 없이 나열

// TODO N개의 자연수 중에서 M개를 고른 순열 + 같은 수를 여러 번 골라도 된다. -> 중복 순열 또는 중복 조합
// TODO 고른 수열은 비내림차순이어야 한다. -> 다음 항이 같거나 큰 비내림차순
// TODO 중복되는 수열을 여러 번 출력하면 안됨 -> (1, 7) = (7, 1) -> 중복 조합
// TODO 한 줄에 하나씩 + 한 줄에는 공백으로 구분 -> sb.append().append("\n")
// TODO 사전 순으로 출력 -> Arrays.sort()
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // TODO duplicateCombination()의 전 범위에서 필요한 배열이므로 만들어서 넘겨주자. 메서드 내에서 생성하면 재귀를 반복할 때마다 초기화될테니까..
        int[] tempArr = new int[m];

        duplicateCombination(0, 0, n, m, arr, tempArr);
        br.close();
    }

    private static void duplicateCombination(int start, int depth, int n, int m, int[] arr, int[] tempArr) {
        // 더 나은 위치가 있을 것 같은데 ..
        if (depth == m) {
            StringBuilder sb = new StringBuilder(); // depth == m이 true인 경우만 StringBuilder를 생성하도록?

            for (int result : tempArr) {
                sb.append(result + " "); // 출력용 배열을 만들어두고, ..
            }
            // TODO 그냥 행 바꿈을 하는 것이 아니라 출력 후, 행 바꿈을 진행해야하므로 sout
            // 인데, 그냥 sb.append("\n"); 후, main()에서 출력해도 될 것 같은데?
            System.out.println(sb);
            // TODO m만큼 출력했다면, 해당 재귀를 탈출
            return;
        }

        for (int i = start; i < n; i ++) {
            // resultArr을 만들어야 할텐데.. 어느 위치에다가?
            tempArr[depth] = arr[i];

            duplicateCombination(i, depth + 1, n, m, arr, tempArr);
        }
    }
}
