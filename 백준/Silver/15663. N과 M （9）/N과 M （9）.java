import java.io.*;
import java.util.*;

// TODO 1. n개의 자연수 중에서 m개를 고른 수열
// TODO 2. 순열 : 서로 다른 n개 중 r개를 뽑아서 나열한 것 <-> 조합 : 서로 다른 n개 중 r개를 순서 없이 골라낸 것
// TODO (1, 7) <-> (7, 1) => 순열
// TODO 3. (9, 9) -> 같은 원소를 반복해서 뽑을 수 있음 => 문제를 잘못 읽었다, 9개 2개라서 뽑았을 뿐임
// TODO 따라서 visited를 통해 중복을 구별해놔야 함
// TODO 4. 공백으로 구분해서 출력 -> sb.append("\n");
// TODO 5. 사전 순으로 증가하는 순서 -> Arrays.sort();

// TODO 의식의 흐름
// TODO 1. int[] -> "입력 때부터 들어오는 중복값을 없애야지"
// TODO 2. int[] -> set -> "정렬하려면 list를 써야지"
// TODO 3. int[] -> set -> list -> "백트래킹할 때마다 for-each문을 통해 값을 가져오므로 자꾸 첫 입력값부터 접근하네..?"
// TODO 4. 결론 : int[] + set(단, 백트래킹 시에 출력용) 또는 int[] + before(중복 출력을 방지하기 위한 비교 변수) 사용해야함
public class Main {
    private static int n, m;
    private static int[] sequence;
    private static int[] tempArr;
    private static boolean[] visited;
    private static final Set<String> set = new HashSet<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sequence = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sequence);

        visited = new boolean[n];
        tempArr = new int[m];
        duplicatePermutation(0);

        System.out.println(sb);
        br.close();
    }

    private static void duplicatePermutation(int depth) {
        if (depth == m) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < m; i++) {
                temp.append(tempArr[i]).append(" ");
            }

            String tempStr = temp.toString();
            if (!set.contains(tempStr)) {
                set.add(tempStr); // 그 이후에 1이 나와야 하는 모든 출력값에서
                sb.append(temp).append("\n");
            }

            return;
        }

        // for (int seq : seqList) { // 재귀를 반복할 때마다 처음부터 시작해서 그런 것 같은데.., 배열의 인덱스와 같은 역할을 할 친구가 cnt라고 생각했는데, for-each로 뽑는 이상 의미가 없다.
        // (수정) 위 이유가 아니라 방문 처리가 되어 있다면 반복을 다시 하지 않는 것 뿐이었음
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempArr[depth] = sequence[i];

                duplicatePermutation(depth + 1);
                visited[i] = false;
            }
        }

    }
}

