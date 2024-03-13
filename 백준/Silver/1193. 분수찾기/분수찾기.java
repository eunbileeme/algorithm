import java.io.*;

public class Main {
    // 1 : 1/1
    // 2 : 1/2
    // 3 : 2/1
    // 4 : 3/1
    // 5 : 2/2
    // 6 : 1/3
    // 7 : 1/4
    // 8 : 2/3
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        // TODO 해당 범위의 대각선 칸 개수가 홀수(= T가 짝수)라면 왼 -> 오
        // TODO 해당 범위의 대각선 칸 개수가 짝수(= T가 홀수)라면 오 -> 왼

        // TODO "crossCount"를 1씩 증가시키니까, 바로바로 다음 대각선으로 넘어가네?
        int crossCount = 1; // 현재 범위의 대각선 칸 개수, T
        int prevCountSum = 0; // 현재 대각선 직전 대각선까지의, 칸의 누적 합

        while (true) {
            if (x <= prevCountSum + crossCount) {
                if (crossCount % 2 == 1) { // 홀수라면, 왼 -> 오
                    // TODO (crossCount - (x - prevCountSum - 1) ?
                    System.out.println((crossCount - (x - prevCountSum - 1)) + "/" + (x - prevCountSum));
                    break;
                } else { // 짝수라면, 오 -> 왼
                    int temp = x - prevCountSum;
                    System.out.println((temp) + "/" + (crossCount - (temp - 1)));
                    break;
                }

            } else {
                prevCountSum += crossCount;
                crossCount++;
            }
        }
    }
}
