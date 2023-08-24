import java.io.*;

// ※ 어디까지 삼각수를 구해야하지? + 삼각수의 합을 어떻게 조합하지? (ex. 1 + 1 + 1, 1 + 1 + 3, ..)
public class Main {
    static int arr[];
    static int answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // ※ 입력 범위가 1000까지이므로, 충분히 직접 구현 가능
        int triple[] = new int[44];

        // (1) ~ T44까지 삼각수 구하기
        // 즉, n = 43일 때 1000을 넘지 않은 최댓값 990을 가짐
        for (int i = 1; i < 44; i++) {
            triple[i] = (i * (i + 1)) / 2;
        }

        // (2) 삼각수 합 조합하기
        // ※ 1 + 1 + 1 이든 1 + 1 + 3이든 상관없이 중복해서 삼각수의 합을 조합할 수 있으므로 범위는 1 ~ 44까지
        for (int i = 1; i < 44; i++) {
            for (int j = 1; j < 44; j++) {
                for (int k = 1; k < 44; k++) {
                    int sum = 0;
                    sum += triple[i] + triple[j] + triple[k];
                    matching(sum);
                }
            }
        }

        // (4) 출력
        for (int i = 0; i < answer.length; i ++) {
            System.out.println(answer[i]);
        }

        br.close();
    }

    // (3) 삼각수의 합이 주어진 수와 같다면 1을 저장
    // ※ 답을 위한 answer 배열 선언 -> 이때, main 함수와 matching 함수는 분리되어야 하므로
    // arr 및 answer 배열은 static 변수로 선언
    private static void matching (int sum) {
        for (int i = 0; i < arr.length; i ++) {
            if (answer[i] != 1) {
                if (arr[i] == sum)
                    answer[i] = 1;
                else
                    answer[i] = 0;
            }
        }
    }
}