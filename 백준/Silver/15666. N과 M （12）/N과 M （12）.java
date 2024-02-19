import java.io.*;
import java.util.*;

// TODO 1. N개의 자연수 중에서 M개를 고른 수열 -> 순열과 조합
// TODO 2. 같은 수를 여러 번 골라도 된다. -> ex. (1, 1) / (7, 7) / (9, 9) => 중복을 허용
// TODO 3. 비내림차순 -> 다음항이 크거나 같아도 된다.
// TODO 4. 중복되는 수열을 여러 번 출력하면 안되며, -> ex. (1, 1) / (1, 1) (x)
// TODO 5. 각 수열은 공백으로 구분해서 출력 -> ex. (1, 1) / (1, 7) => sb.append("\n");
// TODO 6. 수열은 사전 순으로 증가하는 순서로 출력 -> Arrays.sort():
// TODO 7. (1, 7) = (7, 1) = 조합 (중복을 허용하는)
public class Main {
    static int n, m;
    // static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

//        for (int number : numbers) {
//            System.out.println(number);
//        }

        Arrays.sort(numbers);

        int[] tempResult = new int[m];
        duplicateCombination(numbers, tempResult, 0, 0);

        br.close();
    }

    private static void duplicateCombination(int[] numbers, int[] tempResult, int start, int depth) {
        if (depth == m) {
            StringBuilder temp = new StringBuilder();
            for (int result : tempResult) {
                temp.append(result).append(" ");
            }

            String combination = temp.toString();
            if (!set.contains(combination)) {
                set.add(combination);
                System.out.println(temp); // temp.append("\n");의 역할을 sout()가 수행
            }

            return;
        }

        for (int i = start; i < n; i++) {
            tempResult[depth] = numbers[i];

            duplicateCombination(numbers, tempResult, i, depth + 1);
        }
    }
}
