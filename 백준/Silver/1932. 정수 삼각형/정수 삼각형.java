import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://upcurvewave.tistory.com/212
// Todo 최댓값(1개)을 찾는 문제이므로 위에서부터 아래로(= 탑 다운) 값을 구한 뒤, max를 통해 답을 구하는 것보다
// Todo 아래에서부터 위로(= 바텀 업) 향하면서 최댓값을 구하는게 나을 것이라 판단, 따라서 바텀 업 방식으로 진행

// Todo 큰 값으로만 더해서 최댓값을 구하는 것이 아니라, 모든 경우를 다 조사해서 최댓값을 구하는 것
// Todo 예제 입력 1을 보면 알 수 있듯이, 왼쪽 대각선 = 현재 값이 속한 열 + 오른쪽 대각선 = 그 다음 열

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangles = new int[n][n];

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i + 1; j ++) { // i, j = 0부터 시작하므로, n까지 순회하기 위해서 i + 1..
                triangles[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i > 0; i --) {
            for (int j = 0; j < i; j ++) { // 맨 마지막 행을 기준으로 행과 열의 수는 일치함 (ex. n = 5, row = 0 ~ 4 / column = 0 ~ 4)
                triangles[i - 1][j] += Math.max(triangles[i][j], triangles[i][j + 1]); // ex. triangles[3][0] = Math.max(triangles[4][0], triangles[4][1])
            }
        }

        System.out.println(triangles[0][0]);
        br.close();
    }
}
